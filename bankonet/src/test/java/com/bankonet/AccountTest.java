package com.bankonet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AccountTest {

	private static Account account01;
	private static Account account02;
	private static Account account03;

	@BeforeAll
	static void initiialize() {
		account01 = new Account("01", "Main account", 0, 300);
		account02 = new Account("02", "Second account", 100, 100);
		account03 = new Account("03", "Third account", 1000, 0);
	}

	@Test
	public void totalAccounts_mustBeEqualToThree() {
		assertEquals(3, Account.getTotalAccounts(), "Total number of accounts must be equal to three");
	}

	@Test
	public void credit_ok() {
		// Given
		account01.setBalance(150);
		// When
		account01.credit(50);
		// Then
		assertEquals(200, account01.getBalance(), "Main account's balance must be equal to 200");
	}

	@Test
	public void credit_exception_negativeValue() {
		// Given
		account01.setBalance(0);
		// When
		ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> account01.credit(-1));
		// Then
		assertEquals("Amount must be positive", thrown.getMessage());
	}

	@Test
	public void debit_ok() {
		// Given
		account02.setBalance(1000);
		// When
		account02.debit(100);
		// Then
		assertEquals(900, account02.getBalance(), "Second account's balance must be equal to 900");
	}

	@Test
	public void debit_exception_negativeValue() {
		// Given
		account03.setBalance(0);
		// When
		ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> account03.debit(-1));
		// Then
		assertEquals("Amount must be positive", thrown.getMessage());
	}

	@Test
	public void debit_exception_balanceNotHighEnough() {
		// Given
		account03.setBalance(0);
		// When
		ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> account03.debit(10000));
		// Then
		assertEquals("New balance cannot get under max overdraft", thrown.getMessage());
	}

	@Test
	public void toString_ok() {
		// Given
		account01.setBalance(150);
		// When
		String toStringValue = account01.toString();
		// Then
		assertEquals("[01] Main account : 150.0€", toStringValue);
	}

}