package com.example.crmwebapprestclientdemo.service;

import com.example.crmwebapprestclientdemo.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomerById(Long id);
    List<Customer> getCustomers();
    void saveOrUpdateCustomer(Customer customer);
    void deleteById(Long id);
}
