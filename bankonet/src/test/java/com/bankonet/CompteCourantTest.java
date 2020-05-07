package com.bankonet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CompteCourantTest {

	private static CompteCourant compteCourant1;
	private static CompteCourant compteCourant2;
	private static CompteCourant compteCourant3;

	@BeforeAll
	static void initiialize() {
		//
		// Given
		//
		compteCourant1 = new CompteCourant("1", "cc1", 0, 300);
		compteCourant2 = new CompteCourant("2", "cc2", 100, 100);
		compteCourant3 = new CompteCourant("3", "cc3", 1000, 0);
	}

	@Test
	public void leNombreTotalDeComptesCreesDoitEtreEgalATrois() {
		assertEquals(3, CompteCourant.getNbComptesCourants(), "Le nombre de comptes courants doit être égal à 3");
	}

	@Test
	public void testCrediter_ok() {
		// Given
		compteCourant1.setSolde(150);
		// When
		compteCourant1.crediter(50);
		// Then
		assertEquals(200, compteCourant1.getSolde(), "Le solde du compte courant #1 doit être à 200");
	}

	@Test
	public void testCrediter_exception_doitEtrePositif() {
		// Given
		compteCourant1.setSolde(0);
		// When
		ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> compteCourant1.crediter(-1));
		// Then
		assertEquals("Le montant doit être positif.", thrown.getMessage());
	}

	@Test
	public void testDebiter_ok() {
		// Given
		compteCourant2.setSolde(1000);
		// When
		compteCourant2.debiter(100);
		// Then
		assertEquals(900, compteCourant2.getSolde(), "Le solde du compte courant #1 doit être à 900");
	}

	@Test
	public void testDebiter_exception_doitEtrePositif() {
		// Given
		compteCourant3.setSolde(0);
		// When
		ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> compteCourant3.debiter(-1));
		// Then
		assertEquals("Le montant doit être positif.", thrown.getMessage());
	}

	@Test
	public void testDebiter_exception_doitEtreSuperieurADecouvert() {
		// Given
		compteCourant3.setSolde(0);
		// When
		ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> compteCourant3.debiter(10000));
		// Then
		assertEquals("Ce compte ne peut être débité davantage.", thrown.getMessage());
	}

}