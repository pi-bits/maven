package com.serviceinfotech;

import com.serviceinfotech.model.Customer;
import com.serviceinfotech.model.Customer.FirstName;
import com.serviceinfotech.model.Customer.LastName;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

@RunWith(value = Parameterized.class)
public class CustomerValidationParameterizedTest {
    String propertyName;
    Class clazzName;
    int expectedNumberOfValidations;

    public CustomerValidationParameterizedTest(String propertyName,Class clazzName,int expectedNumberOfValidations)

    {
        this.propertyName = propertyName;
        this.clazzName = clazzName;
        this.expectedNumberOfValidations = expectedNumberOfValidations;

    }

    @Parameterized.Parameters(name = "{index}: When validateProperty({0} with group {1} ) = expected number of errors is {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"firstName", FirstName.class, 1},
                {"lastName", LastName.class, 1},
                {"book", FirstName.class, 1},
                {"title", null, 1},
        });
    }

    @Test
    public void validateCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("");
        Assert.assertThat(validate(customer).size(), Is.is(expectedNumberOfValidations));
    }

    private Set<ConstraintViolation<Customer>> validate(Customer customer) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        if(null==clazzName)
        {
             return validator.validateProperty(customer,propertyName);
        }
        else
        {
            return validator.validateProperty(customer,propertyName, clazzName);
        }
    }
}
