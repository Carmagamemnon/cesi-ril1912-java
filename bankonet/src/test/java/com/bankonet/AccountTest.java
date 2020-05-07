package com.bankonet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.Assert.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {

	public class ConcreteAccount extends Account {

		public ConcreteAccount(String id, String label, double balance) {
			super(id, label, balance);
		}

		@Override
		public boolean isDebitAuthorized(double amount) {
			return true;
		}

	}

	private static ConcreteAccount account;

	@BeforeEach
	public void initialize() {
		account = new ConcreteAccount("Acc01", "Main account", 1000);
	}

	@Test
	public void credit_ok() {
		// Given current balance = 1000
		// When crediting 50
		account.credit(50);
		// Then
		assertEquals(1050, account.getBalance(), "Main account's balance must be equal to 1050");
	}

	@Test
	public void credit_exception_negativeValue() {
		// Given an account
		// When trying to credit a negative amount
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> account.credit(-1));
		// Then
		assertEquals("Amount must be positive", ex.getMessage());
	}

	@Test
	public void toString_ok() {
		// Given an account which id is "Acc01"
		// And label is "Main account"
		// And balance is 1000 
		// When calling toString method
		String toStringValue = account.toString();
		// Then
		assertEquals("[Acc01] Main account : 1000,00€", toStringValue);
	}

}