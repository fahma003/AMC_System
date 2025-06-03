package com.DSE.FinalProject.dto;

import java.util.List;

public class CostReportDTO {

    private List<CostReportRowDTO> rows;
    private double totalCost;
    private double averageCost;
    private String highestCostContract;

    // Getters and setters
    public List<CostReportRowDTO> getRows() {
        return rows;
    }

    public void setRows(List<CostReportRowDTO> rows) {
        this.rows = rows;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getAverageCost() {
        return averageCost;
    }

    public void setAverageCost(double averageCost) {
        this.averageCost = averageCost;
    }

    public String getHighestCostContract() {
        return highestCostContract;
    }

    public void setHighestCostContract(String highestCostContract) {
        this.highestCostContract = highestCostContract;
    }
}
