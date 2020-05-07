package com.bankonet;

public class SavingAccount extends Account {

	private double interestRate;

	public SavingAccount(String id, String label, double balance, double interestRate) {
		super(id,label,balance);
		this.interestRate = interestRate >= 0 ? interestRate : 0;
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

}
