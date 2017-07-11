package com.scrumtrek.simplestore;

import org.junit.Ignore;
import org.junit.Test;
import com.scrumtrek.simplestore.*;

import static org.junit.Assert.assertEquals;

/**
 * SUT: system under test
 * Test Case: class
 * Test, Test scenario: method
 */
@Ignore
public class MovieSystemTest {
    @Test
    public void itShouldGetCorrectTitleAndPriceCodeWhenCreateMovie() { //BDD: Domain Lang
        //region Fixture | Arrange | Given
        final String title = "Matrix";
        final PriceCodes priceCode = PriceCodes.Regular;

        Movie sut = null;
        //endregion

        //region Act | When
        sut = new Movie(title, priceCode);
        //endregion

        //region Assert | Then
        /**
         * AssertionError | Failure
         */
        assertEquals(title, sut.getTitle());
        assertEquals(priceCode, sut.getPriceCode());
        //endregion
    }

    @Test
    public void itShouldGetCorrectPriceCodeWhenSetPriceCode() { //BDD: Domain Lang
        //region Fixture | Arrange | Given
        final String title = "Matrix";
        final PriceCodes priceCode = PriceCodes.NewRelease;
        final PriceCodes newCode = PriceCodes.Regular;

        Movie sut = new Movie(title, priceCode);
        //endregion

        //region Act | When
        sut.setPriceCode(newCode);
        //endregion

        //region Assert | Then
        /**
         * AssertionError | Failure
         */
        assertEquals(newCode, sut.getPriceCode());
        //endregion
    }
}
