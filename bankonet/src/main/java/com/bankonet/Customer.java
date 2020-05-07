package com.bankonet;

public class Customer {

	private String id;
	private String lastname;
	private String firstname;
	private Account account;
	private SavingAccount savingAccount;

	public Customer(String id, String lastname, String firstname, Account account, SavingAccount savingAccount) {
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.account = account;
		this.savingAccount = savingAccount;
		System.out.println("New customer created : " + this.toString());
	}

	public double getTotalBalance() {
		return this.account.getBalance() + this.savingAccount.getBalance();
	}

	@Override
	public String toString() {
		return "[" + this.id + "]" + this.lastname + " " + this.firstname;
	}
}
