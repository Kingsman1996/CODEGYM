package com.baitap3.controller;

import com.baitap3.model.Feedback;
import com.baitap3.service.FeedbackDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class FeedbackController {
    private final FeedbackDAO feedbackDAO;

    @Autowired
    public FeedbackController(FeedbackDAO feedbackDAO) {
        this.feedbackDAO = feedbackDAO;
    }

    @GetMapping("/list")
    public String listFeedback(Model model) {
        model.addAttribute("feedbackList", feedbackDAO.findAll());
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
        feedbackDAO.save(feedback);
        return "redirect:/list";
    }
}
