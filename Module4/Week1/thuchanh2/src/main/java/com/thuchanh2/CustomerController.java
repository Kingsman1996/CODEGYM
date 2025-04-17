package com.thuchanh2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class CustomerController {

    private final CustomerDAO customerDAO = new CustomerDAO();

    @GetMapping("/customer")
    public String showCustomers(Model model) {
        List<Customer> customerList = customerDAO.getAll();
        model.addAttribute("customerList", customerList);
        return "list";
    }
}