package com.controller;

import com.model.UsageSession;
import com.service.UsageSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usage")
public class UsageSessionController {

    private final UsageSessionService usageSessionService;

    @Autowired
    public UsageSessionController(UsageSessionService usageSessionService) {
        this.usageSessionService = usageSessionService;
    }

    @GetMapping
    public String listUsageSessions(Model model) {
        List<UsageSession> usageSessions = usageSessionService.findAll();
        model.addAttribute("usageSessions", usageSessions);
        return "usage/list";
    }

    @PostMapping("/create")
    public String createUsageSession(@ModelAttribute UsageSession usageSession) {
        usageSessionService.save(usageSession);
        return "redirect:/usage";
    }

    @GetMapping("/view/{id}")
    public String viewUsageSessionDetail(@PathVariable Long id, Model model) {
        Optional<UsageSession> usageSession = usageSessionService.findById(id);
        usageSession.ifPresent(session -> model.addAttribute("usageSession", session));
        return "usage/view";
    }
}
