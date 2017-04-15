package learn.basic.javaclasses;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Bank {
	Customer[] customersArray = new Customer[15];
	int customerNumber = 0;

	/**
	 * This method accepts the details of the user and creates the account for
	 * the user and returns the account number
	 * 
	 * @param name
	 *            : Name of user
	 * @param dob:
	 *            Date of birth of user
	 * @param addes:
	 *            Adress of the user
	 * @param pan:
	 *            User's PAN number
	 * @param adhar:
	 *            User's Adhar card number
	 * @return
	 */
	// -----[0,..........]--------------[.1.........]-------------[..2.............]
	public String createAccountInBank(String name, String dob, String addes, String pan, String adhar, int money) {

		String customerAccountNumber = "SNGURB-" + (customerNumber + 1);

		Customer cs = new Customer();
		cs.setCustomerName(name);
		cs.setCustomerAccno(customerAccountNumber);
		cs.setCustomerDOB(dob);
		cs.setCustomerAddress(addes);
		cs.setCustomerPAN(pan);
		cs.setCustomerAdhar(adhar);
		cs.setMoney(money);
		customersArray[customerNumber] = cs;

		/*
		 * for (Customer c : customer) {
		 * System.out.println(c.getCustomerName());
		 * System.out.println(c.getCustomerAccno());
		 * System.out.println(c.getCustomerDOB());
		 * System.out.println(c.getCustomerAddress());
		 * System.out.println(c.getCustomerPAN());
		 * System.out.println(c.getCustomerAdhar()); }
		 */
		// Right now you are hardcoding the account number.
		// Ideally, you should implement a logic such that
		// your code will generate next account number.
		// "SNGUB-{id}" for e.g. "SNGUB-10"

		customerNumber++;

		return customerAccountNumber;
	}

	public Customer updateAccountFromAccountNo(String acno, String name, String addes, String dob, String pan,
			String adhar) {
		for (int j = 0; j < customersArray.length; j++) {
			Customer cust = customersArray[j];
			if (cust.getCustomerAccno().equals(acno)) {

				cust.setCustomerAccno(acno);
				cust.setCustomerName(name);
				cust.setCustomerDOB(dob);
				cust.setCustomerAddress(addes);
				cust.setCustomerPAN(pan);
				cust.setCustomerAdhar(adhar);
				return cust;

			}
		}
		return null;
	}

	// This method should return an array of customers whos accounts has been
	// created
	public Customer[] getAllCustomersInBank() {
		Customer temp = new Customer();
		Customer[] allcustomers = new Customer[customerNumber];
		for (int i = 0; i < allcustomers.length; i++) {
			if (customersArray[i] != null) {
				allcustomers[i] = customersArray[i]; // data must be handeled
				// via object not
				// allcustomers[i]=temp; // directly by array
				// copy or clone
			}
		}
		return allcustomers;
	}

	public void transferMoneyFromBank() {
	}

	public void createFixDepositInBank() {
	}

	public void loanFromBank() {
	}

	public void insuranceInBank() {
	}

	/**
	 * This method deposits specific account to the given Account
	 * 
	 * @param amount
	 * @param accountNumber
	 */

	public Customer depositMoney(int amount, String accountNumber) {

		for (int i = 0; i < customersArray.length; i++) {
			Customer cust = customersArray[i];
			if (cust.getCustomerAccno().equals(accountNumber)) {
				int totalMoney = cust.getMoney() + amount;
				cust.setMoney(totalMoney);
				return cust;
			}
		}

		return null;
	}

	public Customer withdrawMoney(int amount, String accountNumber) {
		for (int i = 0; i < customersArray.length; i++) {
			Customer cust = customersArray[i];
			if (cust.getCustomerAccno().equals(accountNumber)) {
				int totalMoney = cust.getMoney() - amount;
				cust.setMoney(totalMoney);
				return cust;
			}
		}
		return null;
	}

	public Customer getAccountFromAccountNumber(String AccountNo1) {
		for (int j = 0; j < customersArray.length; j++) {
			Customer cust = customersArray[j];
			if (cust.getCustomerAccno().equals(AccountNo1)) {
				return cust;

			}
		}
		return null;
	}

	public Customer[] getCustomersArray() {

		return customersArray;
	}

	public void printAll() {
		for (int i = 0; i < customersArray.length; i++) {
			Customer customer = customersArray[i];
			if (customer != null) {
				System.out.println("Name:" + customersArray[i].getCustomerName());
				System.out.println("DOB:" + customersArray[i].getCustomerDOB());
				System.out.println("Address:" + customersArray[i].getCustomerAddress());
				System.out.println("Pan:" + customersArray[i].getCustomerPAN());
				System.out.println("Adhar:" + customersArray[i].getCustomerAdhar());
				System.out.println("AccountNo:" + customersArray[i].getCustomerAccno());
				System.out.println("Amount in Account: " + customersArray[i].getMoney());
				System.out.println(" ");
			}
		}

	}

	public Customer printOneAcc(String oneCustomer) {// in argument it must be
														// string
		for (int j = 0; j < customersArray.length; j++) {
			Customer cust = customersArray[j];
			if (cust.getCustomerAccno().equals(oneCustomer)) {
				System.out.println(" ");
				System.out.println("One Customer Detail: ");
				System.out.println(cust.getCustomerAccno());
				System.out.println(cust.getCustomerName());
				System.out.println(cust.getCustomerDOB()); // create method in
															// bank
															// to print updated
															// customer
				System.out.println(cust.getCustomerAddress());
				System.out.println(cust.getCustomerPAN());
				System.out.println(cust.getCustomerAdhar());
				System.out.println(cust.getMoney());
				return cust;

			}
		}

		return null;

	}

	public Customer[] deleteAccount(String delCust) {
		System.out.println("Customer Number: " + customerNumber);
		Customer[] newArray = new Customer[customerNumber - 1];
		int counter = 0;
		for (int i = 0; i < customerNumber; i++) {
			// System.out.println("Customer Number: "+ i);
			// System.out.println("Customer Number: "+ i+" Account number: "+
			// customersArray[i].getCustomerAccno());
			Customer customer = customersArray[i];

			if (customer != null && !customersArray[i].getCustomerAccno().equals(delCust)) {
				newArray[counter] = customersArray[i];
				counter++;
			}
		}
		customerNumber = customerNumber - 1;
		this.customersArray = newArray;
		return newArray;

	}

	// we are going to write customer data into file with this method
	public Customer writeFile(String file) throws IOException {
		File FileRefrance = new File(file);
		if (FileRefrance.exists()) {
			System.out.println("File exists");

		} else {
			System.out.println("File does not exist new one created");
		}

		OutputStream outstream = new FileOutputStream(file);
		for (int i = 0; i < customersArray.length; i++) {
			Customer customer = customersArray[i];

			if (customer != null) {

				byte[] data = customer.getCustomerName().getBytes();
				// byte[] data = customer.getCustomerAccno().getBytes();

				outstream.write(data);

			}
			outstream.close();
		}

		return null;
	}
}