package learn.basic.javaclasses;

import java.io.IOException;

public class VisitBank {

	// Homework: try to remove location argument and set customer correctly
	// return correct account number
	public static void main(String[] args) throws IOException {

		BankInterface bk = new BankVersion1();
		// int choice = 0;
		// switch (choice) {
		// case 1:// create account
//		String AccountNo = bk.createAccountInBank("omk", "14-9-1984", "abc pune", "PUKT1234", "12345678", 500); // "SNGURB-1"
//		System.out.println("Account number is:" + AccountNo);
//		String AccountNo1 = bk.createAccountInBank("abc", "4-10-1985", "shanivar pune", "PUKT2134", "98765432", 500);
//		System.out.println("Account number is:" + AccountNo1);
//		String AccountNo2 = bk.createAccountInBank("bbc", "5-10-1986", "somvar pune", "PUKT3333", "99876543", 500);
//		System.out.println("Account number is:" + AccountNo2);
//		String AccountNo3 = bk.createAccountInBank("xyz", "6-10-1986", " pune", "PUKT3344", "1234567889", 500);
//		System.out.println("Account number is:" + AccountNo3);

		// case 2:
		// }
		// Customer firstCustomer = bk.getAccountFromAccountNumber("SNGURB-1");

		Customer[] allCustomers = bk.getAllCustomersInBank();

		// Print all customers in Bank
		bk.printAll();

		// deposit money in account
		// bk.depositMoney(1000, "SNGURB-2");
		// bk.depositMoney(1000, "SNGURB-2");
		// bk.depositMoney(1000, "SNGURB-2");
		// bk.depositMoney(1000, "SNGURB-2");
		// bk.withdrawMoney(3000, "SNGURB-2");
		// bk.printAll();
		// // data tobe write in file
	//	bk.writeFile();
		bk.readFile();
		// Customer customer = bk.getAccountFromAccountNumber("SNGURB-2");

		// bk.printOneAcc("SNGURB-2");
		// bk.printOneAcc("SNGURB-2");
		// bk.printOneAcc("SNGURB-2");
		// bk.printOneAcc("SNGURB-2");
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
		Customer customer2 = bk.updateAccountFromAccountNo("SNGURB-1", "hari", "12-12-1996", "nashik", "PAN1234",
				"ADHAR1234");
		System.out.println(customer2);
		// bk.printOneAcc("SNGURB-3");

		// bk.deleteAccount("SNGURB-1");
		System.out.println("Account deleted");
		// bk.deleteAccount("SNGURB-3");
		System.out.println("Account deleted");
		// bk.deleteAccount("SNGURB-2");

		bk.printAll();
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
