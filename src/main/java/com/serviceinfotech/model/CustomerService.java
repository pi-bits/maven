package com.serviceinfotech.model;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {


    public void addCustomer(Customer customer)
    {
        System.out.println(customer.getFirstName() + "Customer Added.");
    }

    public List getCustomerList() {
        return Arrays.asList(new Customer("customer1"),new Customer("customer2"));
    }
}
