package com.serviceinfotech.model;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {


    public void addCustomer(Customer customer)
    {
        System.out.println(customer.getFirstName() + "Customer Added.");
    }
}
