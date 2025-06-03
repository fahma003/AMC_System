package com.DSE.FinalProject.repository;

import com.DSE.FinalProject.model.AmcInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AmcInvoiceRepository extends JpaRepository<AmcInvoice, Long> {

    Optional<AmcInvoice> findById(Long amcId);

}
