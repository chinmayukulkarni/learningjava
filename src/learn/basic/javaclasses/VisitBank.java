package learn.basic.javaclasses;

import java.io.IOException;
import java.util.Scanner;

public class VisitBank {

	// Homework: try to remove location argument and set customer correctly
	// return correct account number
	public static void main(String[] args) throws IOException {
		BankInterface bk = new BankVersion1();
		bk.readFile_Version1();
		Scanner sc = new Scanner(System.in);

		int ch = 0;
		int choice = 0;
		do {

			System.out.println("Which operation do you want to perform? ");
			System.out.println("Select 1 for creating account");
			System.out.println("Select 2 for updating account");
			System.out.println("Select 3 for deleting account");
			System.out.println("Select 4 for Print one account");
			System.out.println("Select 5 for Print All Accounts");
			System.out.println("Select 6 for Deposit Money");
			System.out.println("Select 7 for WithDraw Money");
			choice = sc.nextInt();
			switch (choice) {

			case 1:// create account
				System.out.println("");
				System.out.print("Enter Name of AccountHolder:");
				String name = sc.nextLine();

				System.out.print("Enter Date of Birth (dd-mm-yyyy):");
				String dob = sc.nextLine();

				System.out.print("Enter Address of Account Holder:");
				String address = sc.nextLine();
				System.out.print("Enter PAN of Account Holder:");
				String pan = sc.nextLine();

				System.out.print("Enter AdharNumber of AccountHolder:");
				String adhar = sc.nextLine();

				System.out.print("Enter Money for opening account:");
				int money = (Integer.parseInt(sc.nextLine().trim()));

				String AccountNo = bk.createAccountInBank(name, dob, address, pan, adhar, money); // "SNGURB-1"
				System.out.println("Account number is:" + AccountNo);
				break;

			case 2:// update account
				System.out.println("");
				System.out.print("Enter Account Number in Format->SNGURB-1:");
				String acno = sc.nextLine();
				System.out.print("Enter Name of AccountHolder:");
				name = sc.nextLine();
				System.out.print("Enter Date of Birth (dd-mm-yyyy):");
				dob = sc.nextLine();
				System.out.print("Enter Address of Account Holder:");
				address = sc.nextLine();
				System.out.print("Enter PAN of 1" + "Account Holder:");
				pan = sc.nextLine();
				System.out.print("Enter AdharNumber of AccountHolder:");
				adhar = sc.nextLine();
				// System.out.println("Enter Money for opening account:");
				// money = (Integer.parseInt(sc.nextLine().trim()));
				Customer customer2 = bk.updateAccountFromAccountNo(acno, name, dob, address, pan, adhar);
				System.out.print(customer2);
				break;

			case 3:// Deleting account
				System.out.print("Enter Account Number to be Deleted in Format->SNGURB-1:");
				acno = sc.nextLine();
				bk.deleteAccount(acno);
				System.out.println("Account deleted");
				break;

			case 4:// Print one account
				System.out.print("Enter Account Number to be Printed in Format->SNGURB-1:");
				acno = sc.nextLine();
				bk.printOneAcc(acno);
				break;

			case 5:// Print all accounts
					// Customer[] allCustomers = bk.getAllCustomersInBank();
				bk.printAll();
				break;

			case 6:// Deposit Money
				System.out.print("Enter Account Number In Which Amount To be Deposited:");
				acno = sc.nextLine();
				System.out.print("Enter Amount to be Deposited in Account");
				money = (Integer.parseInt(sc.nextLine().trim()));
				bk.depositMoney(money, acno);
				break;

			case 7:// Withdraw money
				System.out.println("Enter Account Number In Which Amount To be Withdrawl:");
				acno = sc.nextLine();
				System.out.println("Enter Amount to be Deposited in Account");
				money = (Integer.parseInt(sc.nextLine().trim()));
				bk.withdrawMoney(money, acno);
				break;

			default:
				System.out.println("Enter correct option from menu");
			}
			bk.writeFile();
			System.out.print("Do you want to continue?(0/1)(yes/no)");
			ch = sc.nextInt();
		} while (ch == 0);

		sc.close();
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

	}

}
