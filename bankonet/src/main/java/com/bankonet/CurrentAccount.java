package com.bankonet;

public class CurrentAccount extends Account {

	private double maxOverdraft;

	public CurrentAccount(String id, String label, double balance, double maxOverdraft) {
		super(id, label, balance);
		this.maxOverdraft = maxOverdraft >= 0 ? maxOverdraft : 0;
	}

	@Override
	public boolean isDebitAuthorized(double amount) {
		if (amount < 0)
			return false;
		double newBalance = this.balance - amount;
		if (newBalance < (0 - this.maxOverdraft))
			return false;
		return true;
	}

}
