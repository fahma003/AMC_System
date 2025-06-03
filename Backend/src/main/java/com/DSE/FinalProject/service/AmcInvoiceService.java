
package com.DSE.FinalProject.service;

import com.DSE.FinalProject.dto.AmcInvoiceDTO;
import com.DSE.FinalProject.dto.InvoiceItemDTO;
import com.DSE.FinalProject.model.AmcInvoice;
import com.DSE.FinalProject.model.InvoiceItem;
import com.DSE.FinalProject.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AmcInvoiceService {


    private final InvoiceRepository invoiceRepository;

    public AmcInvoiceService(InvoiceRepository invoiceRepository)
    {
        this.invoiceRepository=invoiceRepository;
    }

    public List<AmcInvoiceDTO> getAllInvoices() {
        return invoiceRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public AmcInvoiceDTO getInvoiceById(Long invoiceId) {
        AmcInvoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found with ID: " + invoiceId));
        return mapToDto(invoice);
    }

    public AmcInvoiceDTO createInvoice(AmcInvoiceDTO invoiceDTO) {
        AmcInvoice invoice = mapToEntity(invoiceDTO);
        calculateTotals(invoice);
        AmcInvoice savedInvoice = invoiceRepository.save(invoice);
        return mapToDto(savedInvoice);
    }

    public AmcInvoiceDTO updateInvoice(Long invoiceId, AmcInvoiceDTO updatedInvoiceDTO) {
        AmcInvoice existingInvoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found with ID: " + invoiceId));

        existingInvoice.setTax(updatedInvoiceDTO.getTax());
        existingInvoice.setNotes(updatedInvoiceDTO.getNotes());
        existingInvoice.setTermsConditions(updatedInvoiceDTO.getTermsAndConditions());

        List<InvoiceItem> updatedItems = updatedInvoiceDTO.getItems().stream()
                .map(item -> {
                    InvoiceItem invoiceItem = new InvoiceItem();
                    invoiceItem.setDescription(item.getDescription());
                    invoiceItem.setAmount(item.getAmount());
                    invoiceItem.setAmcInvoice(existingInvoice);
                    return invoiceItem;
                })
                .collect(Collectors.toList());
        existingInvoice.setItems(updatedItems);

        calculateTotals(existingInvoice);

        AmcInvoice savedInvoice = invoiceRepository.save(existingInvoice);
        return mapToDto(savedInvoice);
    }

    private void calculateTotals(AmcInvoice invoice) {
        BigDecimal subtotal = invoice.getItems().stream()
                .filter(item -> item.getAmount() != null)
                .map(InvoiceItem::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal tax = invoice.getTax() != null
                ? subtotal.multiply(invoice.getTax().divide(BigDecimal.valueOf(100)))
                : BigDecimal.ZERO;

        BigDecimal grandTotal = subtotal.add(tax);

        invoice.setSubtotal(subtotal);
        invoice.setGrandTotal(grandTotal);
    }

    private AmcInvoice mapToEntity(AmcInvoiceDTO dto) {
        AmcInvoice invoice = new AmcInvoice();
        invoice.setTax(dto.getTax());
        invoice.setNotes(dto.getNotes());
        invoice.setTermsConditions(dto.getTermsAndConditions());
        invoice.setItems(dto.getItems().stream()
                .map(itemDTO -> {
                    InvoiceItem item = new InvoiceItem();
                    item.setDescription(itemDTO.getDescription());
                    item.setAmount(itemDTO.getAmount());
                    item.setAmcInvoice(invoice);
                    return item;
                })
                .collect(Collectors.toList()));
        return invoice;
    }

    private AmcInvoiceDTO mapToDto(AmcInvoice invoice) {
        AmcInvoiceDTO dto = new AmcInvoiceDTO();
        dto.setInvoiceId(invoice.getInvoiceId());
        dto.setTax(invoice.getTax());
        dto.setSubTotal(invoice.getSubtotal());
        dto.setGrandTotal(invoice.getGrandTotal());
        dto.setNotes(invoice.getNotes());
        dto.setTermsAndConditions(invoice.getTermsConditions());
        dto.setItems(invoice.getItems().stream()
                .map(item -> {
                    InvoiceItemDTO itemDTO = new InvoiceItemDTO();
                    itemDTO.setDescription(item.getDescription());
                    itemDTO.setAmount(item.getAmount());
                    return itemDTO;
                })
                .collect(Collectors.toList()));
        return dto;
    }
}

