package com;

import java.math.BigInteger;
import java.util.Scanner;

import com.constants.BankConstant;
import com.dao.BankDao;
import com.service.BankOperationService;

/**
 * BankApp.java - Operations pertaining to Banking .
 * 
 * @author Sai
 * @version 1.0
 */
public class BankApp {
	public static void main(String[] args) {
		BankOperationService bs = new BankOperationService();
		AccountDetails accountDetails = null;

		System.out.println("******MOCK BANK APPLICATION******");
		Scanner sc = new Scanner(System.in);
		for (;;) {
			System.out.println("Please select the option:");

			System.out.println("Y: For creating a new Account");
			System.out.println("E: Update the details for an Existing account");
			System.out.println("V: View the Account details");
			System.out.println("D: Delete an account");
			System.out.println("N: Close this Screen");
			String option = sc.nextLine();
			System.out.println("option Choosen: " + option);

			if (option.equalsIgnoreCase(BankConstant.Y)) {

				accountDetails = getAccountDetails(sc);
				bs.createNewAccount(accountDetails);
			} else if (option.equals(BankConstant.E)) {
				accountDetails = getAccountUpadateDetails(sc);
				System.out.println("Enter 16-digit account number: ");
				double accountNumber = Double.parseDouble(sc.nextLine());
				bs.updateAccount(accountDetails, accountNumber);
			} else if (option.equals(BankConstant.V)) {
				System.out.println("Enter 16-digit account number: ");
				double accountNumber = Double.parseDouble(sc.nextLine());
				bs.viewAccount(accountNumber);
			} else if (option.equals(BankConstant.D)) {
				System.out.println("Enter 16-digit account number: ");
				double accountNumber = Double.parseDouble(sc.nextLine());
				bs.deleteAccount(accountNumber);
			} else if (option.equals(BankConstant.N)) {
				System.out.println("Closing:");
				System.exit(0);
			} else {
				System.err.println("Please choose Valid Option:");
			}
		}
	}

	private static AccountDetails getAccountUpadateDetails(Scanner sc) {
		System.out.println("Enter the updated  of account details:  ");
		System.out.println("1.Savings");
		System.out.println("2.Current");

		String type = sc.nextLine();

		System.out.println("Enter the Account Holder Full Name");
		String name = sc.nextLine();

		System.out.println("Enter the Amount: ");

		double amount = Double.parseDouble(sc.nextLine());

		System.out.println("Enter the Currency: ");
		String currency = sc.nextLine();

		System.out.println("Enter the MobileNumber: ");
		String mobile = sc.nextLine();

		return new AccountDetails(type, name, 0, amount, currency, mobile);

	}

	private static AccountDetails getAccountDetails(Scanner sc) {
		System.out.println("Enter the type of account:  ");
		System.out.println("1.Savings");
		System.out.println("2.Current");

		String type = sc.nextLine();

		System.out.println("Enter the Account Holder Full Name");
		String name = sc.nextLine();

		System.out.println("Enter 16-digit account number: ");
		String accountNumber = sc.nextLine();

		if (accountNumber.length() < 16) {
			System.err.println("account number Less than 16 please Renter 16 digit account number:");
			accountNumber = sc.nextLine();
		}

		double accountNumberdoub = Double.parseDouble(accountNumber);
		System.out.println("Enter the Amount: ");

		double amount = Double.parseDouble(sc.nextLine());

		System.out.println("Enter the Currency: ");
		String currency = sc.nextLine();

		System.out.println("Enter the MobileNumber: ");
		String mobile = sc.nextLine();

		return new AccountDetails(type, name, accountNumberdoub, amount, currency, mobile);

	}

}

//Table
//CREATE TABLE `bms`.`bank_account` (
//		  `accountNumber` DOUBLE NOT NULL,
//		  `name` VARCHAR(145) NULL,
//		  `type` VARCHAR(45) NULL,
//		  `amount` DOUBLE NULL,
//		  `currency` VARCHAR(45) NULL,
//		  `mobile` VARCHAR(45) NULL,
//		  PRIMARY KEY (`accountNumber`));
