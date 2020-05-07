package com.bankonet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

	private static SavingAccount savingAccount01;

	@BeforeAll
	static void initialize() {
		savingAccount01 = new SavingAccount("S01", "PEL", 0, 1);
	}

	@Test
	public void setBalance_ok() {
		// When
		savingAccount01.setBalance(12345);
		// Then
		assertEquals(12345, savingAccount01.getBalance(), "PEL's balance must be equal to 12345");
	}

	@Test
	public void setBalance_exception_negativeValue() {
		// When
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> savingAccount01.setBalance(-301));
		// Then
		assertEquals("Balance must be positive", thrown.getMessage());
	}

	@Test
	public void credit_ok() {
		// Given
		savingAccount01.setBalance(150);
		// When
		savingAccount01.credit(50);
		// Then
		assertEquals(200, savingAccount01.getBalance(), "PEL's balance must be equal to 200");
	}

	@Test
	public void credit_exception_negativeValue() {
		// Given
		savingAccount01.setBalance(0);
		// When
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> savingAccount01.credit(-1));
		// Then
		assertEquals("Amount must be positive", thrown.getMessage());
	}

	@Test
	public void debit_ok() {
		// Given
		savingAccount01.setBalance(1000);
		// When
		savingAccount01.debit(100);
		// Then
		assertEquals(900, savingAccount01.getBalance(), "Second account's balance must be equal to 900");
	}

	@Test
	public void debit_exception_negativeValue() {
		// Given
		savingAccount01.setBalance(0);
		// When
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> savingAccount01.debit(-1));
		// Then
		assertEquals("Amount must be positive", thrown.getMessage());
	}

	@Test
	public void debit_exception_balanceNotHighEnough() {
		// Given
		savingAccount01.setBalance(0);
		// When
		ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> savingAccount01.debit(10000));
		// Then
		assertEquals("Balance after transaction must be positive", thrown.getMessage());
	}

	@Test
	public void toString_ok() {
		// Given
		savingAccount01.setBalance(150);
		// When
		String toStringValue = savingAccount01.toString();
		// Then
		assertEquals("[S01] PEL : 150,00€", toStringValue);
	}

}