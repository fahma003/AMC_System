
package com.DSE.FinalProject.controller;

import com.DSE.FinalProject.dto.ClientCompanyDTO;
import com.DSE.FinalProject.dto.ClientDTO;
import com.DSE.FinalProject.dto.CompanyDTO;
import com.DSE.FinalProject.dto.UserDTO;
import com.DSE.FinalProject.model.User;
import com.DSE.FinalProject.service.AddAmcService;
import com.DSE.FinalProject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AddAmcService addAmcService;

    // Endpoint to create a new user
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDTO) {
        // Use the service to add the user
        User savedUser = userService.addUser(userDTO); // Let the service handle the conversion to User
        return ResponseEntity.ok(savedUser);
    }

    // Endpoint to fetch the next User ID
    @GetMapping("/nextUserId")
    public ResponseEntity<Long> getNextUserId() {
        Long nextUserId = userService.getNextUserId();
        return ResponseEntity.ok(nextUserId);
    }

    @GetMapping("/clients")
    public ResponseEntity<List<UserDTO>> getClients() {
        List<UserDTO> clients = userService.findUsersByRole("CLIENT");
        return ResponseEntity.ok(clients);
    }

    // Endpoint to fetch all clients with specific details
    @GetMapping("/clients-details")
    public ResponseEntity<List<ClientDTO>> getClientDetails() {
        List<ClientDTO> clients = userService.getClientDetails();
        return ResponseEntity.ok(clients);
    }

    // Endpoint to fetch a client by email
    @GetMapping("/clients-details/{email}")
    public ResponseEntity<ClientDTO> getClientByEmail(@PathVariable String email) {
        ClientDTO client = userService.getClientByEmail(email);
        return ResponseEntity.ok(client);
    }
    @GetMapping("/client-company-details/{email}")
    public ResponseEntity<ClientCompanyDTO> getClientAndCompanyDetails(@PathVariable String email) {
        try {
            // Fetch client details
            ClientDTO clientDetails = userService.getClientByEmail(email);

            if (clientDetails == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Client not found
            }

            // Fetch company details for the client
            List<CompanyDTO> companyDetails = addAmcService.getCompanyDetailsByUserId(clientDetails.getId());

            if (companyDetails == null || companyDetails.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Company details not found
            }

            // Combine the results
            ClientCompanyDTO response = new ClientCompanyDTO(clientDetails, companyDetails);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Handle any unexpected errors
        }
    }

    @GetMapping("/total-count")
    public Map<String, Long> getTotalUsers() {
        long totalUsers = userService.getTotalUsers();

        // Return the count as a JSON response
        Map<String, Long> response = new HashMap<>();
        response.put("count", totalUsers);
        return response;
    }

}

