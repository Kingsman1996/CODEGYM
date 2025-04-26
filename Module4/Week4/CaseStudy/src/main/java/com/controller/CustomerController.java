package com.controller;

import com.model.Customer;
import com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customer/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/view/{id}")
    public String showCustomerDetail(@PathVariable("id") Long id, Model model) {
        Optional<Customer> customerOpt = customerService.findById(id);
        customerOpt.ifPresent(customer -> model.addAttribute("customer", customer));
        return "customer/view";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Customer> customerOpt = customerService.findById(id);
        customerOpt.ifPresent(customer -> model.addAttribute("customer", customer));
        return "customer/edit";
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable("id") Long id,
                                 @ModelAttribute("customer") Customer customer) {
        customer.setId(id);
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        customerService.delete(id);
        return "redirect:/customers";
    }
}
