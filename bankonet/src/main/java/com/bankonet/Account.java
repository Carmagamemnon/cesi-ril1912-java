package com.bankonet;

import java.text.DecimalFormat;

public class Account {

	private String id;
	private String label;
	private double balance;
	private double maxOverdraft;
	private static int totalAccounts = 0;

	public Account() {
		Account.totalAccounts++;
	}

	public Account(String id, String label, double balance, double maxOverdraft) {
		this();
		this.id = id;
		this.label = label;
		this.balance = balance >= 0 ? balance : 0;
		this.maxOverdraft = maxOverdraft >= 0 ? maxOverdraft : 0;
		System.out.println("New account created : " + this.toString());
	}

	public double getBalance() {
		return this.balance;
	}

	/*
	public void setBalance(double balance) {
		if (balance < (0 - this.maxOverdraft)) {
			throw new ArithmeticException("Balance must be higher or equal to max overdraft");
		} else {
			this.balance = balance;
		}
	}
	*/

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
			if (newBalance < (0 - this.maxOverdraft)) {
				throw new ArithmeticException("New balance cannot get under max overdraft");
			} else {
				this.balance -= amount;
			}
		}
	}

	public static int getTotalAccounts() {
		return Account.totalAccounts;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		return "[" + this.id + "] " + this.label + " : " + df.format(this.balance) + "€";
	}
}
