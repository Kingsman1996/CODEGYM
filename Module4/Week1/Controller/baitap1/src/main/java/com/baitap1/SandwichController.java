package com.baitap1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class SandwichController {
    @GetMapping
    public String home() {
        return "index";
    }

    @PostMapping("order")
    public String order(@RequestParam(required = false, name = "condiment") String[] condimentList, Model model) {
        model.addAttribute("condimentList", condimentList);
        return "order";
    }
}