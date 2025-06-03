package com.DSE.FinalProject.repository;

import com.DSE.FinalProject.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
    public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
        List<Feedback> findAllByOrderByIdDesc();


    // Custom method to get the latest 5 feedbacks
    List<Feedback> findTop5ByOrderByIdDesc();
    }

