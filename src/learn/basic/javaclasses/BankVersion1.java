package learn.basic.javaclasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.StringTokenizer;

public class BankVersion1 implements BankInterface {
	Customer[] customersArray = new Customer[15];
	int customerNumber = 0;

	// This is default constructor
	public BankVersion1() {
		// This is the place from where you will execute read file method
		// This read file method should populate customersArray

		super();
	}

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

		customerNumber++; // total number of customer in bank represented by
							// customerNumber

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

	public void printOneAcc(String oneCustomer) {

		for (int j = 0; j < customerNumber; j++) {
			Customer cust = customersArray[j];
			if (cust.getCustomerAccno().equals(oneCustomer)) {
				System.out.println(" ");
				System.out.println("One Customer Detail: ");
				System.out.println(cust.getCustomerAccno());
				System.out.println(cust.getCustomerName());
				System.out.println(cust.getCustomerDOB());
				System.out.println(cust.getCustomerAddress());
				System.out.println(cust.getCustomerPAN());
				System.out.println(cust.getCustomerAdhar());
				System.out.println(cust.getMoney());
			}
		}
	}

	public Customer[] deleteAccount(String delCust) {
		System.out.println("Customer Number: " + customerNumber);
		Customer[] newArray = new Customer[customerNumber - 1];
		int counter = 0;
		for (int i = 0; i < customerNumber; i++) {

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
	public void writeFile() throws IOException {
		String file = "temp2.txt";
		File FileRefrance = new File(file);
		if (FileRefrance.exists()) {
			System.out.println("File exists");

		} else {
			System.out.println("File does not exist new one created");
		}

		OutputStream outstream = new FileOutputStream(file);
		for (int i = 0; i < customerNumber; i++) {
			Customer customer = customersArray[i];

			String customerInStringFormat = customer.toString();
			outstream.write(customerInStringFormat.getBytes());
			outstream.write("\n".getBytes());

		}

		outstream.close();

	}

	public void readFile() throws IOException {
		int i = 0;
		int counter = 0;

		FileReader myReader = new FileReader("temp2.txt");
		BufferedReader in = new BufferedReader(myReader);
		// String fileContent1 = in.readLine();
		// "String tokenizer" create customersArray

		String line;
		while ((line = in.readLine()) != null) {
			String[] temp = new String[10];
			System.out.println(line);
			// In this method you are trying to read Customer information and
			// load it into customersArray.
			// So Customers array is empty. You even dont know how many
			// customers are there.
			// So you cannot use following line. It will give you null 'cst'
			// object.
			Customer cst = customersArray[counter];
			StringTokenizer st = new StringTokenizer(line, "|");
			while (st.hasMoreTokens()) {

				temp[i] = st.nextToken();
				i++;
			}
			// You need to create new customer object for every loop and add the
			// data in it directly. you do not need to have 'temp' variable
			cst.setCustomerName(temp[0]);
			cst.setCustomerAccno(temp[1]);
			cst.setCustomerDOB(temp[2]);
			cst.setCustomerAddress(temp[3]);
			cst.setCustomerPAN(temp[4]);
			cst.setCustomerAdhar(temp[5]);
			counter++;
		}

		// temp.setMoney(st.nextToken());
		in.close();
	}

	/**
	 * This is another method I am writing for you. Please cross check what
	 * changes I have done
	 */
	public void readFile_Version1() throws IOException {
		int customerCounter = 0;
		FileReader myReader = new FileReader("temp2.txt");
		BufferedReader in = new BufferedReader(myReader);

		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(line);

			Customer cust = new Customer();
			StringTokenizer st = new StringTokenizer(line, "|");
			while (st.hasMoreTokens()) {

				cust.setCustomerName(st.nextToken());
				cust.setCustomerAccno(st.nextToken());
				cust.setCustomerDOB(st.nextToken());
				cust.setCustomerAddress(st.nextToken());
				cust.setCustomerPAN(st.nextToken());
				cust.setCustomerAdhar(st.nextToken());
				cust.setMoney(Integer.parseInt(st.nextToken().trim()));
			}
			customersArray[customerCounter] = cust;
			customerCounter++;
		}

		in.close();
	}
}