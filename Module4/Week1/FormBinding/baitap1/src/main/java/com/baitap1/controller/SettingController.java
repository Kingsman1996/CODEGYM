package com.baitap1.controller;

import com.baitap1.model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SettingController {

    @GetMapping("")
    public String showForm(Model model) {
        Setting setting = new Setting();
        model.addAttribute("setting", setting);
        return "home";
    }

    @PostMapping("")
    public String save(@ModelAttribute Setting setting, Model model) {
        model.addAttribute("setting", setting);
        return "setting";
    }
}
