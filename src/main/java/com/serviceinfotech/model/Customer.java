package com.serviceinfotech.model;

import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Component
public class Customer {
    @NotNull(groups = FirstName.class, message = "The First Name cannot be null")
    @Size(min = 1, groups = FirstName.class)
    private String firstName;

    @NotNull(groups = LastName.class)
    @Size(min = 1, groups = LastName.class)
    private String lastName;

    @NotNull
    @Size
    private String title;

    @Valid
    @NotNull
    @Size(max = 20, message = "The company name can only have {max} characters")
    private String company;


    @Valid
    @NotNull(groups = FirstName.class)
    private Book book;



    @Valid
    @NotNull
    private Book anotherBook;

    public Customer() {
    }

    public Customer(String firstName) {
        this.firstName = firstName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Book getAnotherBook() {
        return anotherBook;
    }

    public void setAnotherBook(Book anotherBook) {
        this.anotherBook = anotherBook;
    }

    public interface FirstName{}

    public interface LastName{}

    @Override
    public String toString() {
        return "Customer(" + firstName + ")";
    }
}
