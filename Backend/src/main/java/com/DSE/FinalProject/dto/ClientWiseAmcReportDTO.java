
    package com.DSE.FinalProject.dto;

    public class ClientWiseAmcReportDTO {
        private String clientName;
        private String companyName;
        private String companyEmail;
        private String companyPhone;
        private String companyAddress;
        private String contractName;

        // Constructor
        public ClientWiseAmcReportDTO(String clientName, String companyName, String companyEmail, String companyPhone, String companyAddress, String contractName) {
            this.clientName = clientName;
            this.companyName = companyName;
            this.companyEmail = companyEmail;
            this.companyPhone = companyPhone;
            this.companyAddress = companyAddress;
            this.contractName = contractName;
        }

        // Getters and setters
        public String getClientName() {
            return clientName;
        }

        public void setClientName(String clientName) {
            this.clientName = clientName;
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

        public String getContractName() {
            return contractName;
        }

        public void setContractName(String contractName) {
            this.contractName = contractName;
        }
    }

