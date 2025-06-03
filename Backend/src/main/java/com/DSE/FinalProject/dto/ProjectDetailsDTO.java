package com.DSE.FinalProject.dto;

import java.time.LocalDate;

public class ProjectDetailsDTO {


    private String contractName;
    private long amcId;
    private String category;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private double cost;


    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public long getAmcId() {
        return amcId;
    }

    public void setAmcId(long amcId) {
        this.amcId = amcId;
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
}
