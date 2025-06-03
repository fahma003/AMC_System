package com.DSE.FinalProject.controller;

import com.DSE.FinalProject.dto.CostReportDTO;
import com.DSE.FinalProject.service.CostReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class CostReportController {


    @Autowired
    private CostReportService costReportService;

    @GetMapping("/generate-report")
    public CostReportDTO generateReport(@RequestParam("startDate") String startDate,
                                        @RequestParam("endDate") String endDate) {
        // Parse the date strings into LocalDate objects
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        // Generate the report using the service
        return costReportService.generateReport(start, end);
    }
}
