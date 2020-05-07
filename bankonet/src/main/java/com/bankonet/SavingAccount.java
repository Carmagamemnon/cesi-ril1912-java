package com.bankonet;

import java.text.DecimalFormat;

public class SavingAccount {

	private String id;
	private String label;
	private double balance;
	private double interestRate;

	public SavingAccount(String id, String label, double balance, double interestRate) {
		this.id = id;
		this.label = label;
		this.balance = balance >= 0 ? balance : 0;
		this.interestRate = interestRate >= 0 ? interestRate : 0;
		System.out.println("New saving account created : " + this.toString());
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
		if (amount < 0) {
			throw new IllegalArgumentException("Amount must be positive");
		} else {
			double newBalance = this.balance - amount;
			if (newBalance < 0) {
				throw new ArithmeticException("Balance after transaction must be positive");
			} else {
				this.balance -= amount;
			}
		}
	}

	public double getInterests() {
		return this.balance * this.interestRate / 100;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		return "[" + this.id + "] " + this.label + " : " + df.format(this.balance) + "€";
	}
}
