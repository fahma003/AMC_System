//package com.DSE.FinalProject.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import jakarta.persistence.*;
//
//@Entity
//@IdClass(InvoiceDescriptionId.class) // Composite Key
//public class InvoiceDescription {
//
//    @Id
//    @JsonProperty("amc_id")
//    @ManyToOne
//    @JoinColumn(name = "amc_id", nullable = false)
//    private AmcInvoice amc;
//
//    @Id
//    @JsonProperty("description")
//    @Column(name = "description", nullable = false)
//    private String description; // Description as part of the key
//
//    @JsonProperty("amount")
//    @Column(name = "amount", nullable = false)
//    private Double amount;
//
//    public AmcInvoice getAmc() {
//        return amc;
//    }
//
//    public void setAmc(AmcInvoice amc) {
//        this.amc = amc;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Double getAmount() {
//        return amount;
//    }
//
//    public void setAmount(Double amount) {
//        this.amount = amount;
//    }
//}
package com.DSE.FinalProject.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "invoice_items")
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemId")
    private Long itemId;

    private String description;
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn(name = "amcinvoice_id", nullable = false)
    private AmcInvoice amcinvoice;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public AmcInvoice getAmcInvoice() {
        return amcinvoice;
    }

    public void setAmcInvoice(AmcInvoice amcInvoice) {
        this.amcinvoice = amcInvoice;
    }
}

