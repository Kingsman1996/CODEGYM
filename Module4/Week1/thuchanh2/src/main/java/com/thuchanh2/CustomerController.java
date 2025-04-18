package com.thuchanh2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @GetMapping()
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Customer> customerList = customerDAO.getAll();
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showInfo(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("info");
        Customer customer = customerDAO.findById(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/{id}")
    public String updateCustomer(@PathVariable int id, @RequestParam String name) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customerDAO.update(customer);
        return "redirect:/customer";
    }
}