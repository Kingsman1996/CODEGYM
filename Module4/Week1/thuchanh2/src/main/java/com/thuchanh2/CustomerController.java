package com.thuchanh2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class CustomerController {

    @GetMapping("/customer")
    public String showCustomers(Model model) {
        List<String> customerList = Arrays.asList("Nguyễn Văn A", "Trần Thị B", "Lê Văn C");
        model.addAttribute("customerList", customerList);
        return "list";
    }
}
