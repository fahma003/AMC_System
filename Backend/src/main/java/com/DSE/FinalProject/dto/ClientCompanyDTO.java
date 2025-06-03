package com.DSE.FinalProject.dto;

import java.util.List;

public class ClientCompanyDTO {
    private ClientDTO clientDetails;
    private List<CompanyDTO> companyDetails;

    public ClientCompanyDTO(ClientDTO clientDetails, List<CompanyDTO> companyDetails) {
        this.clientDetails = clientDetails;
        this.companyDetails = companyDetails;
    }

    // Getters and Setters
    public ClientDTO getClientDetails() {
        return clientDetails;
    }

    public void setClientDetails(ClientDTO clientDetails) {
        this.clientDetails = clientDetails;
    }

    public List<CompanyDTO> getCompanyDetails() {
        return companyDetails;
    }

    public void setCompanyDetails(List<CompanyDTO> companyDetails) {
        this.companyDetails = companyDetails;
    }
}
