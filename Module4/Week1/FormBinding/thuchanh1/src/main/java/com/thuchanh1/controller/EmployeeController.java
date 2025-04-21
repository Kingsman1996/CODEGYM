package com.thuchanh1.controller;

import com.thuchanh1.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
public class EmployeeController {
    @GetMapping("/add")
    public String showForm(ModelMap model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add";
    }

    @PostMapping("/add")
    public String submit(@ModelAttribute("employee") Employee employee, Model model, HttpServletResponse response) {
        response.setContentType("text/html; charset=UTF-8");
        model.addAttribute("employee", employee);
        return "info";
    }

}