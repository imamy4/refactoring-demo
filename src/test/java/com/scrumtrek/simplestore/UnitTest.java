package com.scrumtrek.simplestore;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by imamy on 11.07.2017.
 */
public class UnitTest {
    @Test
    public void shouldCalculateCorrectPriceWhenAddChildMovieForOneDay(){
        int daysRented = 1;
        double expectedAmount = 1.5;
        PriceCodes priceCode = PriceCodes.Childrens;

        checkAmount(priceCode, daysRented, expectedAmount);
    }

    @Test
    public void shouldCalculateCorrectPriceWhenAddChildMovieForFiveDay(){
        int daysRented = 5;
        double expectedAmount = 3;
        PriceCodes priceCode = PriceCodes.Childrens;

        checkAmount(priceCode, daysRented, expectedAmount);
    }

    @Test
    public void shouldCalculateCorrectPriceWhenAddRegularMovieForOneDay(){
        int daysRented = 1;
        double expectedAmount = 2;
        PriceCodes priceCode = PriceCodes.Regular;

        checkAmount(priceCode, daysRented, expectedAmount);
    }

    @Test
    public void shouldCalculateCorrectPriceWhenAddRegularMovieForFiveDay(){
        int daysRented = 5;
        double expectedAmount = 6.5;
        PriceCodes priceCode = PriceCodes.Regular;

        checkAmount(priceCode, daysRented, expectedAmount);
    }

    @Test
    public void shouldCalculateCorrectPriceWhenAddNewMovieForOneDay(){
        int daysRented = 1;
        double expectedAmount = 3;
        PriceCodes priceCode = PriceCodes.NewRelease;

        checkAmount(priceCode, daysRented, expectedAmount);
    }

    @Test
    public void shouldCalculateCorrectPriceWhenAddNewMovieForFiveDay(){
        int daysRented = 5;
        double expectedAmount = 15;
        PriceCodes priceCode = PriceCodes.NewRelease;

        checkAmount(priceCode, daysRented, expectedAmount);
    }

    private void checkAmount(PriceCodes priceCode, int daysRented, double expectedAmount){
        final String filmTitle = "Some title";
        String statement = getStatement(filmTitle, priceCode, daysRented);

        assertThat(statement).contains(filmTitle + "\t" + expectedAmount + "\n");
    }

    private String getStatement(String filmTitle, PriceCodes priceCode, int daysRented) {
        final String name = "Pashka";

        Customer sut = new Customer(name);

        Movie movieStub = mock(Movie.class);
        Rental rentalStub = mock(Rental.class);
        when(movieStub.getPriceCode()).thenReturn(priceCode);
        when(movieStub.getTitle()).thenReturn(filmTitle);

        when(rentalStub.getMovie()).thenReturn(movieStub);
        when(rentalStub.getDaysRented()).thenReturn(daysRented);

        sut.addRental(rentalStub);

        return sut.Statement();
    }
}
