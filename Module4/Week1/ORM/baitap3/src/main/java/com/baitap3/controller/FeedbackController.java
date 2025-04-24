package com.baitap3.controller;

import com.baitap3.model.Feedback;
import com.baitap3.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class FeedbackController {
    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/list")
    public String listFeedback(Model model) {
        model.addAttribute("feedbackList", feedbackService.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        Feedback feedback = new Feedback();
        model.addAttribute("feedback", feedback);
        return "home";
    }

    @PostMapping("/save")
    public String saveFeedback(@ModelAttribute("feedback") Feedback feedback) {
        if (feedback.getDate() == null) {
            feedback.setDate(LocalDate.now());
        }
        feedbackService.save(feedback);
        return "redirect:/list";
    }
}
