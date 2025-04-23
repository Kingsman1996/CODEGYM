package com.thuchanh.controller;


import com.thuchanh.model.Customer;
import com.thuchanh.service.ICustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {

    private final ICustomerDAO customerDAO;

    @Autowired
    public CustomerController(ICustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @GetMapping("/home")
    public String index(Model model) {
        List<Customer> customerList = customerDAO.findAll();
        model.addAttribute("customerList", customerList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/save")
    public String save(Customer customer) {
        customerDAO.save(customer);
        return "redirect:/home";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerDAO.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String update(Customer customer) {
        customerDAO.save(customer);
        return "redirect:/home";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerDAO.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerDAO.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/home";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerDAO.findById(id));
        return "view";
    }
}