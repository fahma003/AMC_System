package com.DSE.FinalProject.dto;

import java.time.LocalDate;

public class AmcReminderDTO {
    private String contractName;
    private LocalDate endDate;

    public AmcReminderDTO(String contractName, LocalDate endDate) {
        this.contractName = contractName;
        this.endDate = endDate;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
