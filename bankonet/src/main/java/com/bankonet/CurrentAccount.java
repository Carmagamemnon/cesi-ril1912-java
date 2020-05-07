package com.bankonet;

public class CurrentAccount extends Account {

	private double maxOverdraft;

	public CurrentAccount(String id, String label, double balance, double maxOverdraft) {
		super(id, label, balance);
		this.maxOverdraft = maxOverdraft >= 0 ? maxOverdraft : 0;
	}

	@Override
	public void debit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Amount must be positive");
		} else {
			double newBalance = this.balance - amount;
			if (newBalance < (0 - this.maxOverdraft)) {
				throw new ArithmeticException("Balance after transaction cannot get under max overdraft");
			} else {
				this.balance -= amount;
			}
		}
	}

}
