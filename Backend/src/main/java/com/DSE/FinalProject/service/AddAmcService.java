
package com.DSE.FinalProject.service;

import com.DSE.FinalProject.dto.*;
import com.DSE.FinalProject.model.AddAmc;
import com.DSE.FinalProject.model.User;
import com.DSE.FinalProject.repository.AddAmcRepository;
import com.DSE.FinalProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AddAmcService {

    @Autowired
    private AddAmcRepository addAmcRepository;  // Repository for AddAmc entity
    @Autowired
    private UserRepository userRepository;      // Repository for User entity
    @Autowired
    private RestTemplate restTemplate;


    /**
     * This method handles the creation of an AddAmc entity.
     * It converts the DTO to the entity, fetches the User associated with the AddAmc,
     * and saves the AddAmc entity to the database.
     */
    public AddAmc addAmc(AddAmcDTO addAmcDTO) {
        // Find the User by userId (assuming the UserDTO contains userId)
        User user = userRepository.findById(addAmcDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + addAmcDTO.getUserId()));


        AddAmc addAmc = new AddAmc();
        addAmc.setContractName(addAmcDTO.getContractName());
        addAmc.setCategory(addAmcDTO.getCategory());
        addAmc.setDescription(addAmcDTO.getDescription());
        addAmc.setStartDate(addAmcDTO.getStartDate());
        addAmc.setEndDate(addAmcDTO.getEndDate());
        addAmc.setCost(addAmcDTO.getCost());
        addAmc.setCompanyName(addAmcDTO.getCompanyName());
        addAmc.setCompanyEmail(addAmcDTO.getCompanyEmail());
        addAmc.setCompanyPhone(addAmcDTO.getCompanyPhone());
        addAmc.setCompanyAddress(addAmcDTO.getCompanyAddress());

        // Set the user (foreign key relationship)
        addAmc.setUser(user);

        // Save the AddAmc entity
        return addAmcRepository.save(addAmc);
    }



    // Fetch the next UserID
    public Long getNextAmcId() {
        Optional<AddAmc> lastAddAmc = addAmcRepository.findTopByOrderByAmcIdDesc();

        if (lastAddAmc.isPresent()) {
            // If there's a user, increment the ID
            return lastAddAmc.get().getAmcId() + 1;
        } else {
            // If no users are present, start from ID 1
            return 1L;
        }
    }




    public List<UserDTO> fetchClients() {
        String url = "http://localhost:8080/api/users/clients";
        ResponseEntity<List<UserDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UserDTO>>() {}
        );
        return response.getBody();
    }




    public AddAmcService(AddAmcRepository addAmcRepository) {
        this.addAmcRepository = addAmcRepository;
    }

    public List<CompanyDTO> getCompanyDetailsByUserId(Long userId) {
        List<AddAmc> amcs = addAmcRepository.findByUserId(userId);
        return amcs.stream().map(amc ->
                new CompanyDTO(

                        amc.getCompanyName(),
                        amc.getCompanyEmail(),
                        amc.getCompanyPhone(),
                        amc.getCompanyAddress(),
                        amc.getContractName()
                )
        ).collect(Collectors.toList());
    }



    public List<AddAmc> getAllAmcs() {
        return addAmcRepository.findAll();
    }



    public AddAmc updateAmc(Long amcId, AddAmc updatedAmc) {
        AddAmc existingAmc = addAmcRepository.findById(amcId).orElseThrow(() -> new RuntimeException("AMC not found"));

        // Update only the fields that can be changed (excluding amcId and userId)
        existingAmc.setContractName(updatedAmc.getContractName());
        existingAmc.setCategory(updatedAmc.getCategory());
        existingAmc.setDescription(updatedAmc.getDescription());
        existingAmc.setStartDate(updatedAmc.getStartDate());
        existingAmc.setEndDate(updatedAmc.getEndDate());
        existingAmc.setCost(updatedAmc.getCost());
        existingAmc.setCompanyName(updatedAmc.getCompanyName());
        existingAmc.setCompanyEmail(updatedAmc.getCompanyEmail());
        existingAmc.setCompanyPhone(updatedAmc.getCompanyPhone());
        existingAmc.setCompanyAddress(updatedAmc.getCompanyAddress());


        return addAmcRepository.save(existingAmc);
    }


    public boolean existsById(Long amcId) {
        return addAmcRepository.existsById(amcId);
    }



    public AddAmc findById(Long amcId) {
        return addAmcRepository.findById(amcId).orElse(null);
    }


    public void deleteById(Long amcId) {
        addAmcRepository.deleteById(amcId);
    }



    public List<ProjectDetailsDTO> getProjectDetailsByContractName(String contractName) {
        List<AddAmc> amcs = addAmcRepository.findByContractName(contractName);
        return amcs.stream().map(amc -> {
            ProjectDetailsDTO dto = new ProjectDetailsDTO();
            dto.setContractName(amc.getContractName());
            dto.setAmcId(amc.getAmcId());
            dto.setCategory(amc.getCategory());
            dto.setDescription(amc.getDescription());
            dto.setStartDate(amc.getStartDate());
            dto.setEndDate(amc.getEndDate());
            dto.setCost(amc.getCost());
            return dto;
        }).toList();
    }


    public List<InvoicePageDTO> getInvoicePageData() {
        // Retrieve all AddAmc entries and map them to InvoicePageDTO
        return addAmcRepository.findAll().stream()
                .map(amc -> {
                    InvoicePageDTO dto = new InvoicePageDTO();
                    dto.setAmcId(amc.getAmcId());
                    dto.setContractName(amc.getContractName());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public BillToInvoiceDTO getBillToInvoiceByAmcId(Long amcId) {
        AddAmc addAmc = addAmcRepository.findById(amcId)
                .orElseThrow(() -> new RuntimeException("AMC not found with id: " + amcId));

        // Create and return BillToInvoiceDTO
        BillToInvoiceDTO billToInvoiceDTO = new BillToInvoiceDTO();
        billToInvoiceDTO.setCompanyName(addAmc.getCompanyName());
        billToInvoiceDTO.setCompanyEmail(addAmc.getCompanyEmail());
        billToInvoiceDTO.setCompanyPhone(addAmc.getCompanyPhone());
        billToInvoiceDTO.setCompanyAddress(addAmc.getCompanyAddress());

        return billToInvoiceDTO;
    }

    public List<ClientWiseAmcReportDTO> getAllClientAmcs() {
        List<AddAmc> addAmcs = addAmcRepository.findAll();

        return addAmcs.stream().map(amc -> {
            User user = amc.getUser();
            return new ClientWiseAmcReportDTO(
                    user.getName(),
                    amc.getCompanyName(),
                    amc.getCompanyEmail(),
                    amc.getCompanyPhone(),
                    amc.getCompanyAddress(),
                    amc.getContractName()
            );
        }).collect(Collectors.toList());
    }

    // Fetch user by role (for client)
    public List<User> getUsersByRole(String role) {
        return userRepository.findByRole(role); // Query users by role to get clients
    }


    public List<Map<String, Object>> getMonthlyCosts() {
        // Fetch aggregated costs from the repository
        List<Object[]> monthlyCosts = addAmcRepository.getMonthlyCosts();

        // Array to map month numbers to month names
        String[] monthNames = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };

        // Transform data to a readable format
        List<Map<String, Object>> transformedMonthlyCosts = new ArrayList<>();
        for (Object[] record : monthlyCosts) {
            int month = (int) record[0];
            int year = (int) record[1];
            double totalCost = (double) record[2];

            Map<String, Object> costData = new HashMap<>();
            costData.put("month", monthNames[month - 1]); // Convert month number to name
            costData.put("year", year); // Include year if needed
            costData.put("totalCost", totalCost);

            transformedMonthlyCosts.add(costData);
        }

        return transformedMonthlyCosts;
    }

//
//    public AddAmcService(AddAmcRepository addAmcRepository) {
//        this.addAmcRepository = addAmcRepository;
//    }

    /**
     * Fetch AMC reminders with only contract name and end date for AMCs expiring in the next 30 days.
     */
    public List<AmcReminderDTO> getAmcReminders() {
        LocalDate today = LocalDate.now();
        LocalDate nextMonth = today.plusDays(30);
        return addAmcRepository.findAmcRemindersBetweenDates(today, nextMonth);
    }


    public List<AmcOverTimeDTO> getAmcCountOverTime() {
        List<Object[]> results = addAmcRepository.getAmcCountOverTime();
        return results.stream()
                .map(result -> new AmcOverTimeDTO(
                        (Integer) result[0], // month
                        (Integer) result[1], // year
                        (Long) result[2]     // count
                ))
                .collect(Collectors.toList());
    }


    public List<CategoryDistributionDTO> getCategoryDistribution() {
        return addAmcRepository.getCategoryDistribution().stream()
                .map(result -> new CategoryDistributionDTO((String) result[0], (Long) result[1]))
                .collect(Collectors.toList());
    }

}

