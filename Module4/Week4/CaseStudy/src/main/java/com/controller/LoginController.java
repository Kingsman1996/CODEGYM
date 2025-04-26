package com.controller;

import com.model.Customer;
import com.model.Computer;
import com.model.UsageSession;
import com.service.CustomerService;
import com.service.ComputerService;
import com.service.UsageSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class LoginController {

    private final CustomerService customerService;
    private final UsageSessionService usageSessionService;
    private final ComputerService computerService;

    @Autowired
    public LoginController(CustomerService customerService, UsageSessionService usageSessionService, ComputerService computerService) {
        this.customerService = customerService;
        this.usageSessionService = usageSessionService;
        this.computerService = computerService;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String name, @RequestParam String password, Model model) {
        Customer customer = customerService.findByNameAndPassword(name, password);
        if (customer != null) {
            Computer computer = computerService.getAvailableComputer();
            if (computer != null) {
                UsageSession usageSession = new UsageSession();
                usageSession.setCustomer(customer);
                usageSession.setComputer(computer);
                usageSession.setStartTime(LocalDateTime.now());
                usageSession.setPrice(computer.getPricePerHour());
                usageSessionService.save(usageSession);
                model.addAttribute("message", "Đăng nhập thành công và phiên sử dụng đã được tạo.");
                return "redirect:/usage/view/" + usageSession.getId();
            } else {
                model.addAttribute("error", "Không có máy tính trống.");
                return "login"; // Quay lại form đăng nhập
            }
        } else {
            model.addAttribute("error", "Thông tin đăng nhập không đúng.");
            return "login"; // Quay lại form đăng nhập
        }
    }
}
