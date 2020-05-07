package com.bankonet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

	public static SavingAccount savingAccount01;
	public static SavingAccount savingAccount02;
	public static SavingAccount savingAccount03;

	@BeforeAll
	static void initialize() {
		savingAccount01 = new SavingAccount("S01", "PEL", 1000, 1);
		savingAccount02 = new SavingAccount("S02", "Livret A", 2000, 0.5);
		savingAccount03 = new SavingAccount("S03", "LEP", 3000, 0.75);
	}

	@Test
	public void credit_ok() {
		// Given current balance = 1000
		// When
		savingAccount01.credit(50);
		// Then
		assertEquals(1050, savingAccount01.getBalance(), "PEL's balance must be equal to 1050");
	}

	@Test
	public void credit_exception_negativeValue() {
		// When trying to credit a negative amount
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> savingAccount01.credit(-1));
		// Then
		assertEquals("Amount must be positive", thrown.getMessage());
	}

	@Test
	public void debit_ok() {
		// Given current balance = 2000
		// When
		savingAccount02.debit(100);
		// Then
		assertEquals(1900, savingAccount02.getBalance(), "Second account's balance must be equal to 1900");
	}

	@Test
	public void debit_exception_negativeValue() {
		// When trying to debit a negative amount
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> savingAccount02.debit(-1));
		// Then
		assertEquals("Amount must be positive", thrown.getMessage());
	}

	@Test
	public void debit_exception_balanceNotHighEnough() {
		// Given current balance = 2000
		// When trying to debit more than current balance
		ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> savingAccount02.debit(10000));
		// Then
		assertEquals("Balance after transaction must be positive", thrown.getMessage());
	}

	@Test
	public void getInterests_ok() {
		// Given current balance = 3000
		// And interest rate = 0.75
		// When calling getInterests method
		double interestsValue = savingAccount03.getInterests();
		// Then
		assertEquals(22.5, interestsValue, "Interests should be equal to 22.5");
	}

	@Test
	public void toString_ok() {
		// Given an account which id is "S01"
		// And label is "PEL"
		// And balance is 1000
		// When calling toString method
		String toStringValue = savingAccount01.toString();
		// Then
		assertEquals("[S01] PEL : 1000,00€", toStringValue);
	}

}