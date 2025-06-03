package com.DSE.FinalProject.controller;
import com.DSE.FinalProject.dto.*;
import com.DSE.FinalProject.model.AddAmc;
import com.DSE.FinalProject.service.AddAmcService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/addAmcs")
public class AddAmcController {

    @Autowired
    private AddAmcService addAmcService;

    @PostMapping("/addAmc")
    public ResponseEntity<AddAmc> createAddAmc(@Valid @RequestBody AddAmcDTO addAmcDTO) {
        AddAmc savedAddAmc = addAmcService.addAmc(addAmcDTO); // Let the service handle the conversion to User
        return ResponseEntity.ok(savedAddAmc);

    }
    // Endpoint to fetch the next User ID
    @GetMapping("/nextAmcId")
    public ResponseEntity<Long> getNextAmcId() {
        Long nextAmcId = addAmcService.getNextAmcId();
        return ResponseEntity.ok(nextAmcId);
    }

    @GetMapping("/clientDetails/{userId}")
    public ResponseEntity<List<CompanyDTO>> getClientDetails(@PathVariable Long userId) {
        List<CompanyDTO> clientDetails = addAmcService.getCompanyDetailsByUserId(userId);
        return ResponseEntity.ok(clientDetails);
    }


    @GetMapping("/all")
    public ResponseEntity<List<AddAmc>> getAllAmcs() {
        List<AddAmc> amcList = addAmcService.getAllAmcs();
        return ResponseEntity.ok(amcList);
    }

    @PutMapping("/update/{amcId}")
    public ResponseEntity<String> updateAmc(@PathVariable Long amcId, @RequestBody AddAmc updatedAmc) {
        try {
            // Check if AMC exists
            if (addAmcService.existsById(amcId)) {
                // Retrieve the existing AMC record from the database
                AddAmc existingAmc = addAmcService.findById(amcId);

                // Ensure amcId cannot be modified (retain the original values)
                updatedAmc.setAmcId(existingAmc.getAmcId());

                // Update the AMC (except for amcId and userId)
                AddAmc amc = addAmcService.updateAmc(amcId, updatedAmc);

                return ResponseEntity.ok("AMC updated successfully!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("AMC not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating AMC");
        }

    }

    @DeleteMapping("/delete/{amcId}")
    public ResponseEntity<String> deleteAmc(@PathVariable Long amcId) {
        try {
            if (addAmcService.existsById(amcId)) {
                addAmcService.deleteById(amcId);
                return ResponseEntity.ok("AMC deleted successfully!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("AMC not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting AMC");
        }
    }

    @GetMapping("/projectDetails/{contractName}")
    public ResponseEntity<List<ProjectDetailsDTO>> getProjectDetails(@PathVariable String contractName) {
        List<ProjectDetailsDTO> projectDetails = addAmcService.getProjectDetailsByContractName(contractName);
        if (projectDetails.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(projectDetails);
    }


    @GetMapping("/invoicePage")
    public ResponseEntity<List<InvoicePageDTO>> getInvoicePageData() {
        try {
            List<InvoicePageDTO> invoiceData = addAmcService.getInvoicePageData();
            if (invoiceData.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(invoiceData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/billToInvoice/{amcId}")
    public ResponseEntity<BillToInvoiceDTO> getBillToInvoice(@PathVariable Long amcId) {
        try {
            AddAmc addAmc = addAmcService.findById(amcId);

            if (addAmc != null) {
                BillToInvoiceDTO billToInvoiceDTO = new BillToInvoiceDTO();
                billToInvoiceDTO.setCompanyName(addAmc.getCompanyName());
                billToInvoiceDTO.setCompanyEmail(addAmc.getCompanyEmail());
                billToInvoiceDTO.setCompanyPhone(addAmc.getCompanyPhone());
                billToInvoiceDTO.setCompanyAddress(addAmc.getCompanyAddress());

                return ResponseEntity.ok(billToInvoiceDTO);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/api/client-wise-amc-report")
    public List<ClientWiseAmcReportDTO> getClientWiseAmcReport() {
        return addAmcService.getAllClientAmcs();
    }

//    @GetMapping("/monthly-costs")
//    public ResponseEntity<List<Map<String, Object>>> getMonthlyCosts() {
//        return ResponseEntity.ok(addAmcService.getMonthlyCosts());
//    }

    @GetMapping("/monthly-costs")
    public ResponseEntity<List<Map<String, Object>>> getMonthlyCosts() {
        List<Map<String, Object>> monthlyCosts = addAmcService.getMonthlyCosts();
        return ResponseEntity.ok(monthlyCosts);
    }


    /**
     * Endpoint to fetch AMC reminders (contract name and end date).
     * @return List of AMC reminders as AmcReminderDto
     */
    @GetMapping("/amc-reminders")
    public ResponseEntity<List<AmcReminderDTO>> getAmcReminders() {
        List<AmcReminderDTO> reminders = addAmcService.getAmcReminders();
        return ResponseEntity.ok(reminders);
    }

    @GetMapping("/amc-over-time")
    public List<AmcOverTimeDTO> getAmcOverTimeData() {
        return addAmcService.getAmcCountOverTime();
    }


    @GetMapping("/category-distribution")
    public List<CategoryDistributionDTO> getCategoryDistribution() {
        return addAmcService.getCategoryDistribution();
    }
}





