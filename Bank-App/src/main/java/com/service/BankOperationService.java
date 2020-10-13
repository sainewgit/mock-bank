package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.AccountDetails;
import com.dao.BankDao;

public class BankOperationService {

	BankDao bankDao = new BankDao();

	public void createNewAccount(AccountDetails accountDetails) {
		String insertQuery = "INSERT INTO bank_account (accountNumber, name, type, amount,currency,mobile) VALUES (?, ?, ?, ?,?,?)";
		Connection con = null;
		try {

			double accountNumber = accountDetails.getAccountNumber();
			String name = accountDetails.getName();
			String type = accountDetails.getType();
			double amount = accountDetails.getAmount();
			String currency = accountDetails.getCurrency();
			String mobile = accountDetails.getMobile();
			con = bankDao.getConnection();
			PreparedStatement statement = con.prepareStatement(insertQuery);
			statement.setDouble(1, accountNumber);
			statement.setString(2, name);
			statement.setString(3, type);
			statement.setDouble(4, amount);
			statement.setString(5, currency);
			statement.setString(6, mobile);
			int rowsDeleted = statement.executeUpdate();

			if (rowsDeleted > 0) {
				System.out.println("ACCOUNT ADDED SUCCESSFULLY IN DATABASE ");
				System.out.println("-------------------------------- ");
				System.out.println("Account Type : " + type);
				System.out.println("Account Holder Name  : " + name);
				System.out.println("Account Number :: " + accountNumber);
				System.out.println("Amount in Account  :: " + amount);
				System.out.println("Currency mode :  :: " + currency);
				System.out.println("MobileNumber mode :  :: " + mobile);
				System.out.println("-------------------------------- ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateAccount(AccountDetails accountDetails, double accountNumber) {
		String update = "UPDATE bank_account SET amount=?, type=?, mobile=? WHERE accountNumber=?";
		Connection con = null;
		try {
			con = bankDao.getConnection();
			PreparedStatement statement = con.prepareStatement(update);
			statement.setDouble(1, accountDetails.getAmount());
			statement.setString(2, accountDetails.getType());
			statement.setString(3, accountDetails.getMobile());
			statement.setDouble(4, accountNumber);
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing user was updated successfully!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void viewAccount(double accountNumber) {
		String viewQuery = "select accountNumber,name,type,amount from bank_account where accountNumber =?";

		Connection con = null;
		System.out.println("ACCOUNT Details  for accountNumber " + accountNumber);
		try {
			con = bankDao.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(viewQuery);
			preparedStatement.setDouble(1, accountNumber);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				System.out.println("Account Type : " + rs.getString("type"));
				System.out.println("Account Holder Name  : " + rs.getString("name"));
				System.out.println("Ammount :: " + rs.getDouble("amount"));
				System.out.println("Account Number :: " + rs.getDouble("accountNumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteAccount(double accountNumber) {
		String update = "DELETE FROM  bank_account WHERE accountNumber=?";
		Connection con = null;
		try {
			con = bankDao.getConnection();
			PreparedStatement statement = con.prepareStatement(update);
			statement.setDouble(1, accountNumber);
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing user was Deleted successfully!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
