package com.bankonet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CompteCourantTest {

	@Test
    public void shouldReturnThree() {
		CompteCourant compteCourant1 = new CompteCourant("1", "cc1", 0, 300);
		CompteCourant compteCourant2 = new CompteCourant("2", "cc2", 100, 100);
		CompteCourant compteCourant3 = new CompteCourant("3", "cc3", 1000, 0);

		System.out.println(compteCourant1.toString());
		System.out.println(compteCourant2.toString());
		System.out.println(compteCourant3.toString());

        // assert statements
        assertEquals(3, CompteCourant.getNbComptesCourants(), "Le nombre de comptes courants doit être égal à 3");
    }

}