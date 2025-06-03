//package com.DSE.FinalProject.controller;
//
//import com.DSE.FinalProject.model.Feedback;
//import com.DSE.FinalProject.repository.FeedbackRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//    @RequestMapping("/api/feedback")
//    public class FeedbackController {
//
//        @Autowired
//        private FeedbackRepository feedbackRepository;
//
//        @PostMapping
//        public Feedback submitFeedback(@RequestBody Feedback feedback) {
//            return feedbackRepository.save(feedback);
//        }
//
//        @GetMapping
//        public List<Feedback> getAllFeedbacks() {
//            return feedbackRepository.findAll();
//        }
//    }
//

package com.DSE.FinalProject.controller;

import com.DSE.FinalProject.model.Feedback;
import com.DSE.FinalProject.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "http://localhost:3000")
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @PostMapping
    public Feedback submitFeedback(@RequestBody Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @GetMapping

    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAllByOrderByIdDesc(); // Ensures the latest feedbacks come first
    }


    // New endpoint for Data Overview (Latest 5 feedbacks)
    @GetMapping("/data-overview")
    public List<Feedback> getFeedbackDataOverview() {
        // Fetch the latest 5 feedbacks
        return feedbackRepository.findTop5ByOrderByIdDesc();
    }
}