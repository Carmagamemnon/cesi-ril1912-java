package com.bankonet;

import java.text.DecimalFormat;

public abstract class Account {

	protected String id;
	protected String label;
	protected double balance;

	public Account(String id, String label, double balance) {
		this.id = id;
		this.label = label;
		this.balance = balance >= 0 ? balance : 0;
		System.out.println("New account created : " + this.toString());
	}

	public double getBalance() {
		return this.balance;
	}

	public void credit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Amount must be positive");
		} else {
			this.balance += amount;
		}
	}

	public void debit(double amount) {
		if (this.isDebitAuthorized(amount)) {
			this.balance -= amount;
		} else {
			throw new IllegalArgumentException("Unauthorized");
		}
	}

	public abstract boolean isDebitAuthorized(double amount);

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		return "[" + this.id + "] " + this.label + " : " + df.format(this.balance) + "€";
	}
}
