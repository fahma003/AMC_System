//package com.DSE.FinalProject.dto;
//
//public class AddAmcDTO {
//}
package com.DSE.FinalProject.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class AddAmcDTO {

    private long userId;  // Foreign key reference to User entity


    @NotNull( message = "Contract name is required.")
    private String contractName;


    @NotNull(message = "Category is required.")
    private String category;

    private String description;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @NotNull
    private double cost;

    @NotNull
    private String companyName;
    @NotNull
    private String companyEmail;
    @NotNull
    private String companyPhone;
    @NotNull
    private String companyAddress;

    // Getters and Setters

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }
}

