//package com.DSE.FinalProject.controller;
//import com.DSE.FinalProject.model.TotalAmcData;
//import com.DSE.FinalProject.repository.TotalAmcDataRepository;
//import com.DSE.FinalProject.service.TotalAmcDataService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/dashboard")
//public class TotalAmcDataController {
//
//
//@Autowired
//private TotalAmcDataService totalAmcDataService;
//
//    // Endpoint to fetch total AMC data for the live chart
//    @GetMapping("/total-amc")
//    public ResponseEntity<List<TotalAmcData>> getTotalAmcData() {
//        List<TotalAmcData> totalAmcData = totalAmcDataService.getAllTotalAmcData();
//        return ResponseEntity.ok(totalAmcData);
//
//    }
//
//    @GetMapping("/test/update-total-amc")
//    public String updateTotalAmcData() {
//        totalAmcDataService.updateTotalAmcData();
//        return "Update method executed";
//    }
//}
