package com.DSE.FinalProject.model;
import jakarta.persistence.*;

    @Entity
    public class Feedback {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String companyName;
        private String feedback;

        // Getters and setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getFeedback() {
            return feedback;
        }

        public void setFeedback(String feedback) {
            this.feedback = feedback;
        }
    }

