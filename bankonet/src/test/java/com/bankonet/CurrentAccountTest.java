package com.bankonet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.Assert.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {

	private static CurrentAccount currentAccount;

	@BeforeEach
	public void initialize() {
		currentAccount = new CurrentAccount("CAc01", "Main account", 1000, 100);
	}

	@Test
	public void debit_ok() {
		// Given balance = 1000
		// When debiting 100
		currentAccount.debit(100);
		// Then
		assertEquals(900, currentAccount.getBalance(), "Second account's balance must be equal to 900");
	}

	@Test
	public void debit_exception_negativeValue() {
		// Given a current account
		// When trying to debit a negative amount
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> currentAccount.debit(-1));
		// Then
		assertEquals("Amount must be positive", thrown.getMessage());
	}

	@Test
	public void debit_exception_notEnoughCash() {
		// Given balance = 1000
		// And max overdraft = 100
		// When trying to debit a large amount
		ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> currentAccount.debit(5000));
		// Then
		assertEquals("Balance after transaction cannot get under max overdraft", thrown.getMessage());
	}

}