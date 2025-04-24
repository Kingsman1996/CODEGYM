package com.baitap3.service;

import com.baitap3.model.Feedback;
import com.baitap3.repo.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public void save(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

}
