package com.DSE.FinalProject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;



public class UserDTO {



        private Long id;

        @NotBlank(message = "Name is required")
        private String name;

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        private String email;

        @NotBlank(message = "Password is required")
        @Size(min = 8, message = "Password must be at least 8 characters")
        private String password;

        @NotBlank(message = "Role is required")
        @Pattern(regexp = "^(ADMIN|CLIENT|ACCOUNTANT|AMC COORDINATOR)$", message = "Role must be ADMIN,CLIENT,ACCOUNTANT or AMC COORDINATOR")
        private String role;

        @NotBlank(message = "Address is required")
        @Size(max = 100, message = "Address cannot exceed 100 characters")
        private String address;

        @NotBlank(message = "Contact is required")
        @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Contact must be a valid phone number (10-15 digits)")
        private String contact;

    public UserDTO() {}

    // Constructor for userId and name
    public UserDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

        // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }
    }

