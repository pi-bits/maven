package com.serviceinfotech;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String _name;
    private List<Rental> _rentals = new ArrayList<Rental>();

    public Customer(String name) {
        _name = name;
    }


    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public List<Rental> get_rentals() {
        return _rentals;
    }

    public void set_rentals(List<Rental> _rentals) {
        this._rentals = _rentals;
    }


    public String statement() {

        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + get_name() + " ";
        for (Rental rental : _rentals) {
            frequentRenterPoints = rental.getFrequentRenterPoints(frequentRenterPoints);
            result += " " + rental.getMovie().get_title() + " " +
                    String.valueOf(rental.getCharge());
            totalAmount += rental.getCharge();
        }
        result += " Amount owed is " + String.valueOf(totalAmount);
        result += " You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";


        return result;

    }


}
