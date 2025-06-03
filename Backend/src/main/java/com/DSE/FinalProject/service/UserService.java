
package com.DSE.FinalProject.service;
import com.DSE.FinalProject.dto.ClientDTO;
import com.DSE.FinalProject.dto.UserDTO;
import com.DSE.FinalProject.model.User;
import com.DSE.FinalProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Save a new user in the database
    public User addUser(UserDTO userDTO) {
        // Check if user already exists with the same email
        Optional<User> existingUser = userRepository.findByEmail(userDTO.getEmail());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("User with this email already exists");
        }
        // Convert UserDTO to User
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        user.setAddress(userDTO.getAddress());
        user.setContacts(userDTO.getContact());
        // Save the user
        return userRepository.save(user);
    }

    // Fetch the next UserID
    public Long getNextUserId() {
        Optional<User> lastUser = userRepository.findTopByOrderByIdDesc();

        if (lastUser.isPresent()) {
            // If there's a user, increment the ID
            return lastUser.get().getId() + 1;
        } else {
            // If no users are present, start from ID 1
            return 1L;
        }
    }

    public List<UserDTO> findUsersByRole(String role) {
        return userRepository.findByRole(role)
                .stream()
                .map(user -> new UserDTO(user.getId(), user.getName()))
                .collect(Collectors.toList());
    }


    public List<ClientDTO> getClientDetails() {
        return userRepository.findByRole("CLIENT")
                .stream()
                .map(user -> new ClientDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getContacts()
                ))
                .collect(Collectors.toList());
    }



    // Fetch a single client by email
    public ClientDTO getClientByEmail(String email) {
        User client = userRepository.findByEmailAndRole(email, "CLIENT")
                .orElseThrow(() -> new RuntimeException("Client not found with email: " + email));
        return new ClientDTO(client.getId(), client.getName(), client.getEmail(), client.getContacts());
    }

    public long getTotalUsers() {
        return userRepository.count(); // Use JpaRepository's count() method
    }


    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElse(null);  // or throw exception if you prefer
    }

}
