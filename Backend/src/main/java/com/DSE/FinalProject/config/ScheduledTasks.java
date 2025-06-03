//package com.DSE.FinalProject.config;
//import com.DSE.FinalProject.service.TotalAmcDataService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ScheduledTasks {
//
//    @Autowired
//    private TotalAmcDataService totalAmcDataService;
//
//    // Schedule to run every day at midnight
//    @Scheduled(cron = "0 0 0 * * ?")
//    public void updateTotalAmcData() {
//        totalAmcDataService.updateTotalAmcData();
//    }
//}
