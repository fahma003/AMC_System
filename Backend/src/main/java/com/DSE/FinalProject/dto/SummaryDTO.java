//package com.DSE.FinalProject.dto;
//
//import java.util.List;
//
//public class SummaryDTO {
    package com.DSE.FinalProject.dto;

import java.util.List;

    public class SummaryDTO {

        private int totalContracts;
        private double totalCost;



        //    ------------------------
        private List<FullAmcReportDTO> fullAmcDetails;

        public List<FullAmcReportDTO> getFullAmcReportDTO() {
            return fullAmcDetails;
        }

        public void setFullAmcReportDTO(List<FullAmcReportDTO> fullAmcDetails) {
            this.fullAmcDetails = fullAmcDetails;
        }
        //    --------------------
        // Getters and Setters
        public int getTotalContracts() {
            return totalContracts;
        }
        public void setTotalContracts(int totalContracts) {
            this.totalContracts = totalContracts;
        }

        public double getTotalCost() {
            return totalCost;
        }

        public void setTotalCost(double totalCost) {
            this.totalCost = totalCost;
        }
    }

