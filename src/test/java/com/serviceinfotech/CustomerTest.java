package com.serviceinfotech;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CustomerTest {

    private Customer test_customer;

    @Before
    public void setUp() throws Exception {
        test_customer = new Customer("Test Customer");
    }

    @Test
    public void customerStatementWithOneRental() throws Exception {
        test_customer.set_rentals(Arrays.asList(new Rental(new Movie("Titanic", Movie.REGULAR), 2)));
        String statement = test_customer.statement();
        assertThat(statement, is(equalTo("Rental Record for Test Customer  Titanic 2.0 Amount owed is 2.0 You earned 1 frequent renter points")));
    }

    @Test
    public void customerStatementWithOneRentalAndMoreThanTwoDaysRental() throws Exception {
        test_customer.set_rentals(Arrays.asList(
                new Rental(new Movie("Titanic", Movie.REGULAR), 3)
        ));
        String statement = test_customer.statement();
        assertThat(statement, is(equalTo("Rental Record for Test Customer  Titanic 3.5 Amount owed is 3.5 You earned 1 frequent renter points")));
    }

    @Test
    public void customerStatementWithMoreThanOneRental() throws Exception {
        test_customer.set_rentals(Arrays.asList(
                new Rental(new Movie("Titanic", Movie.REGULAR), 2),
                new Rental(new Movie("The Mummy", Movie.REGULAR), 2)
        ));
        String statement = test_customer.statement();
        assertThat(statement, is(equalTo("Rental Record for Test Customer  Titanic 2.0 The Mummy 2.0 Amount owed is 4.0 You earned 2 frequent renter points")));
    }

    @Test
    public void customerStatementWithMoreThanOneRentalAndMoreThanTwoDaysRental() throws Exception {
        test_customer.set_rentals(Arrays.asList(
                new Rental(new Movie("Titanic", Movie.REGULAR), 3),
                new Rental(new Movie("The Mummy", Movie.REGULAR), 4)
        ));
        String statement = test_customer.statement();
        assertThat(statement, is(equalTo("Rental Record for Test Customer  Titanic 3.5 The Mummy 5.0 Amount owed is 8.5 You earned 2 frequent renter points")));
    }

    @Test
    public void customerStatementWithOneRentalWithChildrenPriceCodeAndTwoDaysRented() throws Exception {
        test_customer.set_rentals(Arrays.asList(new Rental(new Movie("Cars", Movie.CHILDRENS), 2)));
        String statement = test_customer.statement();
        assertThat(statement, is(equalTo("Rental Record for Test Customer  Cars 1.5 Amount owed is 1.5 You earned 1 frequent renter points")));
    }

    @Test
    public void customerStatementWithOneRentalWithChildrenPriceCodeAndFourDaysRented() throws Exception {
        test_customer.set_rentals(Arrays.asList(new Rental(new Movie("Cars", Movie.CHILDRENS), 4)));
        String statement = test_customer.statement();
        assertThat(statement, is(equalTo("Rental Record for Test Customer  Cars 3.0 Amount owed is 3.0 You earned 1 frequent renter points")));
    }


    @Test
    public void customerStatementWithOneRentalWithNewRelaseAndTwoDaysRented() throws Exception {
        test_customer.set_rentals(Arrays.asList(new Rental(new Movie("Hobbits", Movie.NEW_RELEASE), 2)));
        String statement = test_customer.statement();
        assertThat(statement, is(equalTo("Rental Record for Test Customer  Hobbits 6.0 Amount owed is 6.0 You earned 2 frequent renter points")));
    }

    @Test
    public void customerStatementWithOneRentalWithNewRelaseAndFourDaysRented() throws Exception {
        test_customer.set_rentals(Arrays.asList(new Rental(new Movie("Hobbits", Movie.NEW_RELEASE), 4)));
        String statement = test_customer.statement();
        assertThat(statement, is(equalTo("Rental Record for Test Customer  Hobbits 12.0 Amount owed is 12.0 You earned 2 frequent renter points")));
    }

    @Test
    public void customerStatementWithAllKindOfRentalsForOneDay() throws Exception {
        test_customer.set_rentals(Arrays.asList(
                new Rental(new Movie("Hobbits", Movie.NEW_RELEASE), 1),
                new Rental(new Movie("Cars", Movie.CHILDRENS), 1),
                new Rental(new Movie("The Mummy", Movie.REGULAR), 1)
        ));
        String statement = test_customer.statement();
        assertThat(statement, is(equalTo("Rental Record for Test Customer  Hobbits 3.0 Cars 1.5 The Mummy 2.0 Amount owed is 6.5 You earned 3 frequent renter points")));
    }

    @Test
    public void customerStatementWithAllKindOfRentalsForMoreThanFourDays() throws Exception {
        test_customer.set_rentals(Arrays.asList(
                new Rental(new Movie("Hobbits", Movie.NEW_RELEASE), 6),
                new Rental(new Movie("Cars", Movie.CHILDRENS), 6),
                new Rental(new Movie("The Mummy", Movie.REGULAR), 6)
        ));
        String statement = test_customer.statement();
        assertThat(statement, is(equalTo("Rental Record for Test Customer  Hobbits 18.0 Cars 6.0 The Mummy 8.0 Amount owed is 32.0 You earned 4 frequent renter points")));
    }


}