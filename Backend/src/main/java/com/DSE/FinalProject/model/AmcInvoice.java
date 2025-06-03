package com.DSE.FinalProject.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "invoices")
public class AmcInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private Long invoiceId;


    private BigDecimal subtotal;

    private BigDecimal tax;

    private BigDecimal grandTotal;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(columnDefinition = "TEXT")
    private String termsConditions;


    @OneToMany(mappedBy = "amcinvoice", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<InvoiceItem> items= new ArrayList<>();

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTermsConditions() {
        return termsConditions;
    }

    public void setTermsConditions(String termsConditions) {
        this.termsConditions = termsConditions;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }
}

