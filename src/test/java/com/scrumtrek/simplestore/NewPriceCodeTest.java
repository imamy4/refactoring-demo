package com.scrumtrek.simplestore;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by imamy on 12.07.2017.
 */
public class NewPriceCodeTest {
    @Test
    public void shouldGiveDiscountWhenRentXXXMovieForShortTime(){
        Customer sutCustomer = new Customer("Some name");
        double expectedAmount = 2 * 0.85;

        int daysRented = 1;
        Movie movie = new Movie(" Some film", PriceCodes.XXX);
        Rental rental = new Rental(movie, daysRented);
        sutCustomer.addRental(rental);

        String statement = sutCustomer.Statement();

        assertThat(statement).contains(String.valueOf(expectedAmount));
    }

    @Test
    public void shouldGiveDiscountWhenRentXXXMovieForLongTime(){
        Customer sutCustomer = new Customer("Some name");
        double expectedAmount = 6.5 * 0.85;

        int daysRented = 5;
        Movie movie = new Movie(" Some film", PriceCodes.XXX);
        Rental rental = new Rental(movie, daysRented);
        sutCustomer.addRental(rental);

        String statement = sutCustomer.Statement();

        assertThat(statement).contains(String.valueOf(expectedAmount));
    }
}
