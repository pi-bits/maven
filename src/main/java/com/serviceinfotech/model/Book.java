package com.serviceinfotech.model;

import javax.validation.constraints.NotNull;

import static com.serviceinfotech.model.Customer.*;

public class Book {

    @NotNull(groups = FirstName.class)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
