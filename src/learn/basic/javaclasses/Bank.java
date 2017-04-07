package learn.basic.javaclasses;

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
	public String createAccountInBank(String name, String dob, String addes, String pan, String adhar) {

		String customerAccountNumber = "SNGURB-" + (customerNumber + 1);

		Customer cs = new Customer();
		cs.setCustomerName(name);
		cs.setCustomerAccno(customerAccountNumber);
		cs.setCustomerDOB(dob);
		cs.setCustomerAddress(addes);
		cs.setCustomerPAN(pan);
		cs.setCustomerAdhar(adhar);
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
			//	Customer cs = new Customer();
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
		Customer[] allcustomers = new Customer[customerNumber];
		for (int i = 0; i < allcustomers.length; i++) {
			if (customersArray[i] != null) {
				allcustomers[i] = customersArray[i];
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

	public void depoditMoney() {
	}

	public void withdrawMoney() {
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

	public void printAll(Customer[] customers1) {
		for (int i = 0; i < customers1.length; i++) {
			System.out.println("Name:" + customers1[i].getCustomerName());
			System.out.println("DOB:" + customers1[i].getCustomerDOB());
			System.out.println("Address:" + customers1[i].getCustomerAddress());
			System.out.println("Pan:" + customers1[i].getCustomerPAN());
			System.out.println("Adhar:" + customers1[i].getCustomerAdhar());
			System.out.println("AccountNo:" + customers1[i].getCustomerAccno());
			System.out.println(" ");
		}

	}

}
