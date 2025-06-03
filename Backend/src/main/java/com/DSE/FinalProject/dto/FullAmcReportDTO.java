//package com.DSE.FinalProject.dto;
//
//public class FullAmcReportDTO {
//
//}
package com.DSE.FinalProject.dto;

import java.util.List;

public class FullAmcReportDTO {

    private String contractName;
    private String category;
    private String description;
    private String startDate;
    private String endDate;
    private double cost;
    private String companyName;
    private String companyEmail;

    // Summary field
//    private SummaryDTO summary; // The summary DTO that contains total contracts and total cost
//
//    // List of rows (individual reports)
//    private List<FullAmcReportDTO> rows;

    // Getters and Setters
    public String getContractName() { return contractName; }
    public void setContractName(String contractName) { this.contractName = contractName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getCompanyEmail() { return companyEmail; }
    public void setCompanyEmail(String companyEmail) { this.companyEmail = companyEmail; }

//    public SummaryDTO getSummary() { return summary; }
//    public void setSummary(SummaryDTO summary) { this.summary = summary; }
//
//    public List<FullAmcReportDTO> getRows() { return rows; }
//    public void setRows(List<FullAmcReportDTO> rows) { this.rows = rows; }
}