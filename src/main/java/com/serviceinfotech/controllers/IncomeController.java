package com.serviceinfotech.controllers;

import com.serviceinfotech.IncomeFormData;
import org.springframework.stereotype.Component;

@Component
public class IncomeController {

    public void doPost(IncomeFormData incomeFormData)
    {
        System.out.println("Do Post for Income Controller");
    }
}
