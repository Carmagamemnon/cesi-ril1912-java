package com.bankonet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CompteCourantTest {

	private static CompteCourant compteCourant1;
	private static CompteCourant compteCourant2;
	private static CompteCourant compteCourant3;
	
	@BeforeAll
    static void initAll() {
		compteCourant1 = new CompteCourant("1", "cc1", 0, 300);
		compteCourant2 = new CompteCourant("2", "cc2", 100, 100);
		compteCourant3 = new CompteCourant("3", "cc3", 1000, 0);
    }

	@Test
    public void leNombreTotalDeComptesCreesDoitEtreCorrect() {
        assertEquals(3, CompteCourant.getNbComptesCourants(), "Le nombre de comptes courants doit être égal à 3");
	}
	
	@Test
    public void lesMisesAJourDuSoldeDoiventEtreCorrectes() {
		compteCourant1.crediter(50);
		compteCourant1.debiter(25);
        assertEquals(25, compteCourant1.getSolde(), "Le solde du compte courant #1 doit être à 25");
		compteCourant2.debiter(200);
        assertEquals(-100, compteCourant2.getSolde(), "Le solde du compte courant #2 doit être à -100");
		compteCourant3.crediter(9001);
        assertEquals(10001, compteCourant3.getSolde(), "Le solde du compte courant #3 doit être à 10001");
    }

}