package com.bankonet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CustomerTest {

	private static Account account01;
	private static SavingAccount savingAccount01;
	private static Customer customer01;

	@BeforeAll
	static void initialize() {
		account01 = new Account("01", "Main account", 1000, 500);
		savingAccount01 = new SavingAccount("S01", "PEL", 2000, 0.5);
		customer01 = new Customer("C01", "John", "Doe", account01, savingAccount01);
	}

	@Test
	public void getTotalBalance_ok() {
		// When
		double totalBalance = customer01.getTotalBalance();
		// Then
		assertEquals(3000, totalBalance, "Total balance must be equal to 3000");
	}

	@Test
	public void toString_ok() {
		// When
		String toStringValue = customer01.toString();
		// Then
		assertEquals("[C01] Doe John", toStringValue);
	}

}