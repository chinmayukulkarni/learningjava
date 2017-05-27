package learn.basic.javaclasses;

import java.io.IOException;
import java.util.Scanner;

public class VisitBank {

	// Homework: try to remove location argument and set customer correctly
	// return correct account number
	public static void main(String[] args) throws IOException {
		BankInterface1 bk = new BankVersion2();
		// bk.readFile_Version1();
		Scanner sc = new Scanner(System.in);

		int choice = 0;
		boolean isContinue = true;
		System.out.println("************ Welcome To Chinmay Urban Bank *************");
	try{
		do {

			System.out.println("--------------------------------------------------");
			System.out.println("Please select the operation that you would like to perform: ");
			System.out.println("Select 1 to create an account");
			System.out.println("Select 2 to update an existing account");
			System.out.println("Select 3 to delete an existing account");
			System.out.println("Select 4 to read/print single account");
			System.out.println("Select 5 to prinat all accounts in the Bank");
			System.out.println("Select 6 to deposit money in your account");
			System.out.println("Select 7 to withdraw money from your account");
			System.out.println("Select 8 to exit the program");
			System.out.println("--------------------------------------------------");

			choice = sc.nextInt();
			switch (choice) {

			case 1:// create account
				bk.createHaandle();
				break;

			case 2:// update account
				bk.updateHandle();
				break;

			case 3:// Deleting account
					// System.out.print("Enter Account Number to be Deleted in
					// Format->SNGURB-1:");
					// String accountNumber = bk.getAcccountNumber(sc);
				bk.deleteHandle();
				break;

			case 4:// Print one account
				bk.printOneHandle();
				break;

			case 5:// Print all accounts
					// Customer[] allCustomers = bk.getAllCustomersInBank();
				bk.printAll();
				break;

			case 6:// Deposit Money
				bk.depositHandle();
				break;

			case 7:// Withdraw money
				bk.withdrawHandle();
				break;
			case 9:// Withdraw money
				System.out.println("Print Me");

				break;
			case 8:// exit case
				bk.writeFile();
				isContinue = false;
				break;

			default:
				System.out.println("Enter correct option from menu");
			}

			// System.out.print("Do you want to continue?(0/1)(yes/no)");
			// ch = sc.nextInt();
			System.out.println("Continue...");
		} while (isContinue);
	}catch(Exception e){
		System.out.println("Enter Correct input:");
	}
		sc.close();
	
	}

}
	// Customer firstCustomer = bk.getAccountFromAccountNumber("SNGURB-1");

			// Customer customer = bk.getAccountFromAccountNumber("SNGURB-2");

			// System.out.println(customer.getCustomerName());

			// After executing this method, I should receive the customer object
			// which contains updated information
			// If I execute 'getAccountFromAccountNumber' method then I should
			// receive the correct data
			// update Account

			// 1 Inheritance
			// 2 Encapsulation
			// 3 Polymorphism - overloading / overriding (tostring)
			// 4 Abstraction

			// Once the account delete method is executed, the account should be
			// deleted from the bank
			// Read account method based on account number should return null object
			// (for deleted account)
			// getAllCustomersInBank method should return only active accounts in
			// bank

			// Delete account
			// boolean isAccountDeleted = bk.deleteAccountFromAccountNo("SNGURB-1");

			// CRUD - Create Read Updated Delete

			// Form fill up : Name, address, Adhar card etc.
			// Open the account (create user account in bank) [Bank gives :
			// Passbook, ATM card, Checkbook, netbacking -- AccountNumber]
			// Edit the user profile (update user profile in bank)
			// Deposit some money in account
			// withdraw some money from account

			// Open another account
			// read account details

			// Update first account's Adhar card
