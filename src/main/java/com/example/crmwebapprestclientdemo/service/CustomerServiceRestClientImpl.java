package com.example.crmwebapprestclientdemo.service;

import com.example.crmwebapprestclientdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CustomerServiceRestClientImpl implements CustomerService {
    private RestTemplate restTemplate;
    private String crmRestUrl;
    private Logger logger = Logger.getLogger(getClass().getName());
    @Autowired
    public CustomerServiceRestClientImpl(
            RestTemplate theRestTemplate,
            @Value("${crm.rest.url}") String theUrl) {
        restTemplate = theRestTemplate;
        crmRestUrl = theUrl;
        logger.info("Loaded property: crm.rest.url="
                + crmRestUrl);
    }

    @Override
    public Customer getCustomerById(Long id) {
        logger.info("in getCustomer(): Calling REST API "
                + crmRestUrl);
        Customer customer = restTemplate.getForObject(String.format("%s/%d", crmRestUrl, id), Customer.class);
        return customer;
    }

    @Override
    public List<Customer> getCustomers() {
        logger.info("in getCustomers(): Calling REST API "
                + crmRestUrl);
// make REST call
        ResponseEntity<List<Customer>> responseEntity =
                restTemplate.exchange(crmRestUrl,
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
// get the list of customers from response
        List<Customer> customers = responseEntity.getBody();
        logger.info("in getCustomers(): customers" + customers);
        return customers;
    }

    @Override
    public void saveOrUpdateCustomer(Customer customer) {
        logger.info("in saveCustomer(): Calling REST API "
                + crmRestUrl);
        if (customer.getId() == null) {
            restTemplate.postForObject(crmRestUrl, customer, Customer.class);
        }
        else {
            restTemplate.put(crmRestUrl, customer);
        }
        logger.info("in saveCustomer(): success");
    }

    @Override
    public void deleteById(Long id) {
        restTemplate.delete(String.format("%s/%d", crmRestUrl, id));
    }
}
