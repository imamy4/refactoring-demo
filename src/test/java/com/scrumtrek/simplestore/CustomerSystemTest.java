package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by imamy on 10.07.2017.
 */
@Ignore
public class CustomerSystemTest {
    @Test
    public void itShouldBLABLAWhenBLALA(){
        //region Fixture | Arrange | Given
        Movie movCinderella = new Movie("Cinderella", PriceCodes.Childrens);
        Movie movStarWars = new Movie("Star Wars", PriceCodes.Regular);
        Movie movGladiator = new Movie("Gladiator", PriceCodes.NewRelease);

        Customer sut = new Customer("Mickey Mouse");

        // Create rentals
        Rental rental1 = new Rental(movCinderella, 1);
        Rental rental2 = new Rental(movStarWars, 1);
        Rental rental3 = new Rental(movGladiator, 1);
        Rental rental4 = new Rental(movCinderella, 5);
        Rental rental5 = new Rental(movStarWars, 5);
        Rental rental6 = new Rental(movGladiator, 5);

        sut.addRental(rental1);
        sut.addRental(rental2);
        sut.addRental(rental3);
        sut.addRental(rental4);
        sut.addRental(rental5);
        sut.addRental(rental6);
        //endregion

        //region Act | When

        String stat1 = sut.Statement();

        //endregion

        //region Assert | Then

        Assert.assertTrue(stat1.contains(movCinderella.getTitle()) &&
                stat1.contains(movStarWars.getTitle()) &&
                stat1.contains(movGladiator.getTitle()));

        //endregion
    }

    @Test
    public void itShouldCorrectAmountWhenAddRental(){
        //region Fixture | Arrange | Given
        Movie movCinderella = new Movie("Cinderella", PriceCodes.Childrens);

        Customer sut = new Customer("Mickey Mouse");

        // Create rentals
        Rental rental = new Rental(movCinderella, 1);

        //endregion

        //region Act | When

        sut.addRental(rental);
        String stat = sut.Statement();

        //endregion

        //region Assert | Then
       // String row = movCinderella.getTitle() + "\t" + "1.5" + "\n";
        String row = "Amount owed is 1.5" + "\n";;
        Assert.assertTrue(stat.contains(row));

        //endregion
    }
}
