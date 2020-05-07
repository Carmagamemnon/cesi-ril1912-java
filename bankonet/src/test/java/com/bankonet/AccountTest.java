package com.bankonet;

import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.junit.Assert.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AccountTest {

	public static Account account01;
	public static Account account02;
	public static Account account03;

	@BeforeAll
	private static void initialize() {
		account01 = new Account("01", "Main account", 1000, 100);
		account02 = new Account("02", "Second account", 2000, 200);
		account03 = new Account("03", "Third account", 3000, 300);
	}

	@Test
	public void totalAccounts_mustBeEqualToThree() {
		assertEquals(3, Account.getTotalAccounts(), "Total number of accounts must be equal to three");
	}

	/*
	@Test
	public void setBalance_ok() {
		// When
		account01.setBalance(12345);
		// Then
		assertEquals(12345, account01.getBalance(), "Main account's balance must be equal to 12345");
	}

	@Test
	public void setBalance_exception_balanceLowerThanMaxOverdraft() {
		// When
		ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> account03.setBalance(-301));
		// Then
		assertEquals("Balance must be higher or equal to max overdraft", thrown.getMessage());
	}
	*/

	@Test
	public void credit_ok() {
		// Given current balance = 1000
		// When
		account01.credit(50);
		// Then
		assertEquals(1050, account01.getBalance(), "Main account's balance must be equal to 1050");
	}

	@Test
	public void credit_exception_negativeValue() {
		// When trying to credit a negative amount
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> account01.credit(-1));
		// Then
		assertEquals("Amount must be positive", thrown.getMessage());
	}

	@Test
	public void debit_ok() {
		// Given current balance = 2000
		// When
		account02.debit(100);
		// Then
		assertEquals(1900, account02.getBalance(), "Second account's balance must be equal to 1900");
	}

	@Test
	public void debit_exception_negativeValue() {
		// When trying to debit a negative amount
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> account03.debit(-1));
		// Then
		assertEquals("Amount must be positive", thrown.getMessage());
	}

	@Test
	public void debit_exception_balanceNotHighEnough() {
		// Given current balance = 3000
		// And max overdraft = 300
		// When trying to debit a large amount
		ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> account03.debit(5000));
		// Then
		assertEquals("New balance cannot get under max overdraft", thrown.getMessage());
	}

	@Test
	public void toString_ok() {
		// Given an account which id is "01"
		// And label is "Main account"
		// And balance is 1000 
		// When calling toString method
		String toStringValue = account01.toString();
		// Then
		assertEquals("[01] Main account : 1000,00€", toStringValue);
	}

}