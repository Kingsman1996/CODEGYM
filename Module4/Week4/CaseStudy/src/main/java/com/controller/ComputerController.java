package com.controller;

import com.model.Computer;
import com.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/computers")
public class ComputerController {

    private final ComputerService computerService;

    @Autowired
    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    @GetMapping
    public String listComputers(Model model) {
        model.addAttribute("computers", computerService.findAll());
        return "computer/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("computer", new Computer());
        return "computer/create";
    }

    @PostMapping("/save")
    public String saveComputer(@ModelAttribute("computer") Computer computer) {
        computerService.save(computer);
        return "redirect:/computers";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("computer", computerService.findById(id));
        return "computer/edit";
    }

    @PostMapping("/update")
    public String updateComputer(@ModelAttribute Computer computer) {
        computerService.save(computer);
        return "redirect:/computers";
    }

    @GetMapping("/view/{id}")
    public String showComputerDetail(@PathVariable("id") Long id, Model model) {
        Optional<Computer> computerOpt = computerService.findById(id);
        model.addAttribute("computer", computerOpt.get());
        return "computer/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteComputer(@PathVariable Long id) {
        computerService.deleteById(id);
        return "redirect:/computers";
    }
}
