package com.bankonet;

public class SavingAccount extends Account {

	private double interestRate;

	public SavingAccount(String id, String label, double balance, double interestRate) {
		super(id, label, balance);
		this.interestRate = interestRate >= 0 ? interestRate : 0;
	}

	public double getInterests() {
		return this.balance * this.interestRate / 100;
	}

	@Override
	public boolean isDebitAuthorized(double amount) {
		if (amount < 0)
			return false;
		double newBalance = this.balance - amount;
		if (newBalance < 0)
			return false;
		return true;
	}

}
