package com.bankonet;

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
		this.id = id;
		System.out.println("New account created : " + this.toString());
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		if (balance < this.maxOverdraft) {
			throw new IllegalArgumentException("Balance must be higher or equal to max overdraft");
		} else {
			this.balance = balance;
		}
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
			if (newBalance < this.maxOverdraft) {
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
		return "[" + this.id + "] " + this.label + " : " + this.balance + "€";
	}
}
