//package com.DSE.FinalProject.service;
//import com.DSE.FinalProject.model.AddAmc;
//import com.DSE.FinalProject.model.TotalAmcData;
//import com.DSE.FinalProject.repository.AddAmcRepository;
//import com.DSE.FinalProject.repository.TotalAmcDataRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//
//@Service
//public class TotalAmcDataService {
//
//    @Autowired
//    private AddAmcRepository addAmcRepository;
//    @Autowired
//    private TotalAmcDataRepository totalAmcDataRepository;
//
//    public void updateTotalAmcData() {
//        // Get all AMC records
//        List<AddAmc> amcs = addAmcRepository.findAll();
//
//        for (AddAmc amc : amcs) {
//            // Get the month from the startDate (you can adjust this based on your needs)
//            String month = amc.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM"));
//
//            // Check if the data already exists for that month
//            TotalAmcData existingData = totalAmcDataRepository.findByMonth(month);
//
//            if (existingData == null) {
//                // If no data exists for that month, create a new record
//                TotalAmcData newTotalAmcData = new TotalAmcData();
//                newTotalAmcData.setMonth(month);
//                newTotalAmcData.setCount(1); // Initialize count to 1 for the first contract of the month
//                totalAmcDataRepository.save(newTotalAmcData);
//            } else {
//                // If data exists, update the count
//                existingData.setCount(existingData.getCount() + 1);
//                totalAmcDataRepository.save(existingData);
//            }
//        }
//    }
//    // Method to get the data for live chart
//    public List<TotalAmcData> getAllTotalAmcData() {
//        return totalAmcDataRepository.findAll();
//    }
//}
//package com.DSE.FinalProject.service;
//
//import com.DSE.FinalProject.model.AddAmc;
//import com.DSE.FinalProject.model.TotalAmcData;
//import com.DSE.FinalProject.repository.AddAmcRepository;
//import com.DSE.FinalProject.repository.TotalAmcDataRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//@Service
//@Transactional
//public class TotalAmcDataService {
//
//    private static final Logger logger = LoggerFactory.getLogger(TotalAmcDataService.class);
//
//    @Autowired
//    private AddAmcRepository addAmcRepository;
//    @Autowired
//    private TotalAmcDataRepository totalAmcDataRepository;
//
//    public void updateTotalAmcData() {
//        // Get all AMC records
//        List<AddAmc> amcs = addAmcRepository.findAll();
//
//        logger.info("Fetched {} AMC records", amcs.size());  // Log the number of records fetched
//
//        for (AddAmc amc : amcs) {
//            // Get the month from the startDate (you can adjust this based on your needs)
//            String month = amc.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM"));
//            logger.info("Processing AMC with startDate: {} -> Extracted Month: {}", amc.getStartDate(), month);
//
//            // Check if the data already exists for that month
//            TotalAmcData existingData = totalAmcDataRepository.findByMonth(month);
//
//            if (existingData == null) {
//                // If no data exists for that month, create a new record
//                TotalAmcData newTotalAmcData = new TotalAmcData();
//                newTotalAmcData.setMonth(month);
//                newTotalAmcData.setCount(1); // Initialize count to 1 for the first contract of the month
//                totalAmcDataRepository.save(newTotalAmcData);
//
//                logger.info("New entry created for month {} with count 1", month);  // Log the creation of a new entry
//            } else {
//                // If data exists, update the count
//                existingData.setCount(existingData.getCount() + 1);
//                totalAmcDataRepository.save(existingData);
//
//                logger.info("Existing entry for month {} updated with count {}", month, existingData.getCount());  // Log the update
//            }
//        }
//    }
//
//    // Method to get the data for live chart
//    public List<TotalAmcData> getAllTotalAmcData() {
//        return totalAmcDataRepository.findAll();
//    }
//}
//
//
