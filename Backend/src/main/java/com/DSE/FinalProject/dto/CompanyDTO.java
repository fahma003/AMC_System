package com.DSE.FinalProject.dto;

public class CompanyDTO {


    private String companyName;
    private String companyEmail;
    private String companyContact;
    private String companyContract;
    private String companyAddress;

    // Default constructor
    public CompanyDTO() {}

    public CompanyDTO(String companyName, String companyEmail, String companyContact,String companyAddress, String companyContract) {
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyContact = companyContact;
        this.companyAddress = companyAddress;
        this.companyContract = companyContract;

    }

    // Getters and Setters

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

    public String getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(String companyContact) {
        this.companyContact = companyContact;
    }

    public String getCompanyContract() {
        return companyContract;
    }

    public void setCompanyContract(String companyContract) {
        this.companyContract = companyContract;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }
}

