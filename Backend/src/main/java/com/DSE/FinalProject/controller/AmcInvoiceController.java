package com.DSE.FinalProject.controller;
import com.DSE.FinalProject.dto.AmcInvoiceDTO;
import com.DSE.FinalProject.service.AmcInvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class AmcInvoiceController {

    private final AmcInvoiceService amcInvoiceService;

    public AmcInvoiceController(AmcInvoiceService amcInvoiceService) {
        this.amcInvoiceService = amcInvoiceService;
    }

    @GetMapping
    public ResponseEntity<List<AmcInvoiceDTO>> getAllInvoices() {
        List<AmcInvoiceDTO> invoices = amcInvoiceService.getAllInvoices();
        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<AmcInvoiceDTO> getInvoiceById(@PathVariable Long id) {
//        AmcInvoiceDTO invoice = amcInvoiceService.getInvoiceById(id);
//        return new ResponseEntity<>(invoice, HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<AmcInvoiceDTO> getInvoiceById(@PathVariable Long id) {
        AmcInvoiceDTO invoice = amcInvoiceService.getInvoiceById(id);
        if (invoice != null) {
            return new ResponseEntity<>(invoice, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Handle not found
        }
    }

    @PostMapping
    public ResponseEntity<AmcInvoiceDTO> createInvoice(@RequestBody AmcInvoiceDTO newInvoiceDTO) {
        AmcInvoiceDTO createdInvoice = amcInvoiceService.createInvoice(newInvoiceDTO);
        return new ResponseEntity<>(createdInvoice, HttpStatus.CREATED);
    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<AmcInvoiceDTO> updateInvoice(
//            @PathVariable Long id,
//            @RequestBody AmcInvoiceDTO updatedInvoiceDTO) {
//        AmcInvoiceDTO updatedInvoice = amcInvoiceService.updateInvoice(id, updatedInvoiceDTO);
//        return new ResponseEntity<>(updatedInvoice, HttpStatus.OK);
//    }

}

