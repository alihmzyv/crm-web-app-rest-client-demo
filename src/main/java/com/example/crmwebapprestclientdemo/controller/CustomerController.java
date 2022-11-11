package com.example.crmwebapprestclientdemo.controller;


import com.example.crmwebapprestclientdemo.entity.Customer;
import com.example.crmwebapprestclientdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String showAllCustomers(Model model){
        model.addAttribute("allCustomers", customerService.getCustomers());
        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute @Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer-form";
        }
        customerService.saveOrUpdateCustomer(customer);
        return "redirect:/customers/list";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateCustomer(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer-form";
    }

    @GetMapping("/delete/{id}") //not good to use get method for deleting
    public String deleteCustomer(@PathVariable(name = "id") Long id) {
        customerService.deleteById(id);
        return "redirect:/customers/list";
    }
}
