//package com.DSE.FinalProject.controller;
//
//public class FullAmcReportController {
//
//}
package com.DSE.FinalProject.controller;

import com.DSE.FinalProject.dto.FullAmcReportDTO;
import com.DSE.FinalProject.dto.SummaryDTO;
import com.DSE.FinalProject.service.FullAmcReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class FullAmcReportController {

    @Autowired
    private FullAmcReportService fullAmcReportService;

    // Endpoint to generate the report based on date range
    @GetMapping("/generate-amc-report")
    public SummaryDTO generateAmcReport(@RequestParam("startDate") String startDate,
                                        @RequestParam("endDate") String endDate) {
        // Parse the date strings into LocalDate objects
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        // Generate the report using the service
        return fullAmcReportService.generateReport(start, end);
    }
}
