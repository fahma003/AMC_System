//package com.DSE.FinalProject.service;
//
//public class FullAmcReportService {
//}
package com.DSE.FinalProject.service;

import com.DSE.FinalProject.dto.FullAmcReportDTO;
import com.DSE.FinalProject.dto.SummaryDTO;
import com.DSE.FinalProject.model.AddAmc;
import com.DSE.FinalProject.repository.FullAmcReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FullAmcReportService {

    @Autowired
    private FullAmcReportRepository fullAmcReportRepository;

    public SummaryDTO generateReport(LocalDate startDate, LocalDate endDate) {
        // Fetch AddAmc entities within the date range
        List<AddAmc> amcs = fullAmcReportRepository.findByStartDateBetween(startDate, endDate);

        // Prepare the report data
        List<FullAmcReportDTO> rows = new ArrayList<>();
        double totalCost = 0;
        int totalContracts = amcs.size();

        // Convert AddAmc entities to FullAmcReportDTO
        for (AddAmc amc : amcs) {
            FullAmcReportDTO amcDTO = new FullAmcReportDTO();
            amcDTO.setContractName(amc.getContractName());
            amcDTO.setCategory(amc.getCategory());
            amcDTO.setDescription(amc.getDescription());
            amcDTO.setStartDate(amc.getStartDate().toString());
            amcDTO.setEndDate(amc.getEndDate().toString());
            amcDTO.setCost(amc.getCost());
            amcDTO.setCompanyName(amc.getCompanyName());
            amcDTO.setCompanyEmail(amc.getCompanyEmail());

            rows.add(amcDTO);
            totalCost += amc.getCost();
        }

        // Create the summary object
        SummaryDTO summary = new SummaryDTO();
        summary.setFullAmcReportDTO(rows);
        summary.setTotalContracts(totalContracts);
        summary.setTotalCost(totalCost);


        // Prepare the final report DTO with rows and summary
//        FullAmcReportDTO report = new FullAmcReportDTO();
//        report.setRows(rows); // Add rows with individual AMC data
//        report.setSummary(summary); // Add the summary data

//        return report;
        return summary;
    }
}