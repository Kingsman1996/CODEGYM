package com.baitap3.controller;

import com.baitap3.model.Declaration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class DeclarationController {
    @GetMapping("/home")
    public String showForm(Model model) {
        model.addAttribute("declaration", new Declaration());
        return "home";
    }

    @PostMapping("/declare")
    public String submitForm(@ModelAttribute("declaration") Declaration declaration,
                             RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("declaration", declaration);
        return "redirect:/info";
    }

    @GetMapping("/info")
    public String showInfo(Model model) {
        return "info";
    }
}

