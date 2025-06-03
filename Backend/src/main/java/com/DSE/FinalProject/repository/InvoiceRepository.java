package com.DSE.FinalProject.repository;

import com.DSE.FinalProject.model.AmcInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<AmcInvoice, Long> {
}
