package com.serviceinfotech;

import com.serviceinfotech.config.ApplicationConfiguration;
import com.serviceinfotech.model.Book;
import com.serviceinfotech.model.Customer;
import com.serviceinfotech.model.Customer.FirstName;
import com.serviceinfotech.model.Customer.LastName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class , loader=AnnotationConfigContextLoader.class)

public class CustomerValidationSpringTest {

    @Autowired
    private Validator validator;


    @Test
    public void shouldHaveOneConstraintVoilation() throws Exception {
        Customer customer = new Customer();
        customer.setLastName("");
        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer, LastName.class);
        Assert.assertEquals(constraintViolations.size(),1);
    }

    @Test
    public void shouldHaveTwoConstraintVoilation() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("");
        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer, FirstName.class);
        Assert.assertEquals(constraintViolations.size(),2);
    }

    @Test
    public void shouldHaveThreeConstraintVoilation() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("");
        customer.setLastName("");
        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer, FirstName.class,LastName.class);
        Assert.assertEquals(constraintViolations.size(),3);
    }

    @Test
    public void shouldHaveThreeConstraintVoilationWhenHasABook() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("");
        customer.setLastName("");
        Book book = new Book();
        book.setName(null);
        customer.setBook(book);
        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer, FirstName.class,LastName.class);
        Assert.assertEquals(constraintViolations.size(),3);
    }


    @Test
    public void validateProperty() throws Exception {
        Customer customer = new Customer();
        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);
        Assert.assertEquals(constraintViolations.size(),3);
        customer.setFirstName("");
        customer.setLastName("");

      constraintViolations = validator.validateProperty(customer, "book",FirstName.class);
        Assert.assertEquals(constraintViolations.size(),1);

        constraintViolations = validator.validateProperty(customer, "firstName",FirstName.class);
        Assert.assertEquals(constraintViolations.size(),1);

        constraintViolations = validator.validateProperty(customer, "lastName",LastName.class);
        Assert.assertEquals(constraintViolations.size(),1);

        constraintViolations = validator.validateProperty(customer, "title");
        Assert.assertEquals(constraintViolations.size(),1);


        customer.setFirstName(null);
        customer.setLastName(null);

        //should not validate first and last name
        //should validate company,title and anotherbook
        constraintViolations = validator.validate(customer);
        Assert.assertEquals(constraintViolations.size(),3);
    }



}
