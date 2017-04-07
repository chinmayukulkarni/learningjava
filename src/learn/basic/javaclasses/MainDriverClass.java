package learn.basic.javaclasses;

public class MainDriverClass {

	// Homework: try to remove location argument and set customer correctly
	// return correct accountnumber
	public static void main(String[] args) {

		Bank bk = new Bank();
		String AccountNo = bk.createAccountInBank("omk", "14-9-1984", "abc pune", "PUKT1234", "12345678"); // "SNGURB-1"
		System.out.println("Account number is:" + AccountNo);
		String AccountNo1 = bk.createAccountInBank("abc", "4-10-1985", "shanivar pune", "PUKT2134", "98765432");
		System.out.println("Account number is:" + AccountNo1);
		String AccountNo2 = bk.createAccountInBank("bbc", "5-10-1986", "somvar pune", "PUKT3333", "99876543");
		System.out.println("Account number is:" + AccountNo2);
		String AccountNo3 = bk.createAccountInBank("xyz", "6-10-1986", " pune", "PUKT3344", "1234567889");
		System.out.println("Account number is:" + AccountNo3);

		Customer[] customers1 = bk.getAllCustomersInBank();

		// Print all customers in Bank
		bk.printAll(customers1);

		Customer customer = bk.getAccountFromAccountNumber("SNGURB-1");
		System.out.println("One Customer Detail: ");
		System.out.println(customer.getCustomerName());

		// After executing this method, I should receive the customer object
		// which contains updated information
		// If I execute 'getAccountFromAccountNumber' method then I should
		// receive the correct data
		// update Account
		Customer customer2 = bk.updateAccountFromAccountNo("SNGURB-1", "hari", "12-12-1996", "nashik", "PAN1234",
				"ADHAR1234");
		System.out.println(" ");
		System.out.println("Account Updated");
		System.out.println(customer2.getCustomerAccno());
		System.out.println(customer2.getCustomerName());
		System.out.println(customer2.getCustomerDOB());
		System.out.println(customer2.getCustomerAddress());
		System.out.println(customer2.getCustomerPAN());
		System.out.println(customer2.getCustomerAdhar());

		// Once the account delete method is executed, the account should be
		// deleted from the bank
		// Read ccount method based on aacount number should return null object
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
