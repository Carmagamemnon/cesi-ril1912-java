package com.bankonet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

	private static SavingAccount savingAccount;

	@BeforeEach
	public void initialize() {
		savingAccount = new SavingAccount("SAc01", "PEL", 10000, 1.25);
	}

	@Test
	public void debit_ok() {
		// Given balance = 100000
		// When debiting 500
		savingAccount.debit(500);
		// Then
		assertEquals(9500, savingAccount.getBalance(), "Second account's balance must be equal to 9500");
	}

	@Test
	public void debit_exception_negativeValue() {
		// Given a saving account
		// When trying to debit a negative amount
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> savingAccount.debit(-1));
		// Then
		assertEquals("Amount must be positive", ex.getMessage());
	}

	@Test
	public void debit_exception_balanceNotHighEnough() {
		// Given balance = 10000
		// When trying to debit more than current balance
		ArithmeticException ex = assertThrows(ArithmeticException.class, () -> savingAccount.debit(12500));
		// Then
		assertEquals("Balance after transaction must be positive", ex.getMessage());
	}

	@Test
	public void getInterests_ok() {
		// Given balance = 10000
		// And interest rate = 1.25
		// When calling getInterests method
		double interestsValue = savingAccount.getInterests();
		// Then
		assertEquals(125, interestsValue, "Returned value should be equal to 125");
	}

}