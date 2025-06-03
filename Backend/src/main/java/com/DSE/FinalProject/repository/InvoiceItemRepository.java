package com.DSE.FinalProject.repository;

import com.DSE.FinalProject.model.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {
}
