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
    public void shouldCalculateCorrectPriceWhenAddRental(){
        String filmTitle = "Some film";
        int daysRented = 1;
        double expectedAmount = 1.5;

        check(filmTitle, daysRented, expectedAmount);
    }

    private void check(String filmTitle, int daysRented, double expectedAmount){
        Customer sut = new Customer("Pashka");

        Movie movieStub = mock(Movie.class);
        Rental rentalStub = mock(Rental.class);
        when(movieStub.getPriceCode()).thenReturn(PriceCodes.Childrens);
        when(movieStub.getTitle()).thenReturn(filmTitle);

        when(rentalStub.getMovie()).thenReturn(movieStub);
        when(rentalStub.getDaysRented()).thenReturn(daysRented);

        sut.addRental(rentalStub);

        String result = sut.Statement();

        assertThat(result).contains(filmTitle + "\t" + expectedAmount + "\n");
    }
}
