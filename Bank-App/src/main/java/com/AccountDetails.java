package com;

import java.math.BigInteger;

public class AccountDetails {

	private String type;
	private String name;
	private double accountNumber;
	private double amount;
	private String currency;
	private String mobile;

	public AccountDetails(String type, String name, double accountNumber, double amount, String currency,
			String mobile) {
		super();
		this.type = type;
		this.name = name;
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.currency = currency;
		this.mobile = mobile;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
