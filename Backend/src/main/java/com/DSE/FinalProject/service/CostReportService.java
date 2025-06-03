package com.DSE.FinalProject.service;
import com.DSE.FinalProject.dto.CostReportDTO;
import com.DSE.FinalProject.dto.CostReportRowDTO;
import com.DSE.FinalProject.model.AddAmc;
import com.DSE.FinalProject.repository.AddAmcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CostReportService {

    @Autowired
    private AddAmcRepository addAmcRepository;

    public CostReportDTO generateReport(LocalDate startDate, LocalDate endDate) {
        // Fetch AMC data within the date range
        List<AddAmc> amcs = addAmcRepository.findByStartDateBetween(startDate, endDate);

        // Prepare the report data
        List<CostReportRowDTO> rows = new ArrayList<>();
        double totalCost = 0;
        double highestCost = 0;
        String highestCostContract = "";

        for (AddAmc amc : amcs) {
            CostReportRowDTO row = new CostReportRowDTO();
            row.setContractName(amc.getContractName());
            row.setCategory(amc.getCategory());
            row.setCost(amc.getCost());

            rows.add(row);

            totalCost += amc.getCost();

            // Track the highest cost contract
            if (amc.getCost() > highestCost) {
                highestCost = amc.getCost();
                highestCostContract = amc.getContractName();
            }
        }

        // Calculate the average cost
        double averageCost = amcs.isEmpty() ? 0 : totalCost / amcs.size();

        // Prepare the summary data
        CostReportDTO costReportDTO = new CostReportDTO();
        costReportDTO.setRows(rows);
        costReportDTO.setTotalCost(totalCost);
        costReportDTO.setAverageCost(averageCost);
        costReportDTO.setHighestCostContract(highestCostContract);

        return costReportDTO;
    }

}
