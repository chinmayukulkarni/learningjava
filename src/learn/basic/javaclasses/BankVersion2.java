package learn.basic.javaclasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * This class will implement arraylist instead of Array This class will
 * implement delete, create, update and print methods in different way It will
 * not delete the 'customer object' from the Array, instead it will soft-delete
 * it. Meaning, there will be a boolean flag in each customer object. It will be
 * true if the customer is active, otherwise it will be false. While printing:
 * print only customer for whom the flag is 'true' implement getCustomerCount
 * method such that, it will return the count of customers for whom the flag is
 * true For assigning account number, the size/length of arraylist will be used
 */

public class BankVersion2 implements BankInterface1 {
	Scanner sc = new Scanner(System.in);

	public BankVersion2() {

		// This is the place from where you will execute read file method
		// This read file method should populate customersArray

		super();
		try {

			readFile_Version1();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	ArrayList<Customer> myCustomerArrayList = new ArrayList<Customer>();
	int customerCounter = 0;

	public static void main(String[] args) throws IOException {
		BankVersion2 bk = new BankVersion2();
		bk.readFile_version2();
		// bk.printAll();
		bk.createAccountInBank("Shree", "03-09-90", "sangli", "pan1234", "adhar1234", 500);
		bk.printAll();
	}
	// This is an eaxmple of using Arraylist

	// Arraylist is of type collection, which can be used to replace array
	// Similar to array it can contain more than one primitive data types as
	// well as Objects

	// String[] myCustomerArray = new String[100];
	// Customer[] myAnothercustomerArray = new Customer [20];

	// ArrayList<String> myArraylist = new ArrayList<String>();

	// myCustomerArray[0] = "myString";

	// myArraylist.add("String");
	// myArraylist.add("MyString");
	// myArraylist.add("MyThirdString");
	// myCustomerArraylist.add(new Customer());
	// System.out.println(myArraylist.get(0));
	// System.out.println(myArraylist.get(1));
	// System.out.println(myArraylist.size());
	public void readFile_version2() throws IOException {

		FileReader myReader = new FileReader("temp3.txt");
		BufferedReader in = new BufferedReader(myReader);

		String line;

		while ((line = in.readLine()) != null) {
			// System.out.println(line);

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
			myCustomerArrayList.add(cust);

			// myCustomerArraylist.add(customerCounter) = cust;
			customerCounter++;

		}

		in.close();
		// System.out.println(customerCounter);
	}

	public String createAccountInBank(String name, String dob, String addes, String pan, String adhar, int money)
			throws IOException {

		String customerAccountNumber = "SNGURB-" + (customerCounter);

		try {
			Customer cs = new Customer();
			cs.setCustomerName(name);
			cs.setCustomerAccno(customerAccountNumber);
			cs.setCustomerDOB(dob);
			cs.setCustomerAddress(addes);
			cs.setCustomerPAN(pan);
			cs.setCustomerAdhar(adhar);
			cs.setMoney(money);
			cs.setFlag(true);
			myCustomerArrayList.add(cs);

			// customerNumber++; // total number of customer in bank represented
			// by
			// customerNumber
			customerCounter++;
			// System.out.println("First print statement in try block");
			return customerAccountNumber;

		} catch (ArithmeticException e) {
			System.out.println("Warning: ArithmeticException");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Warning: ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			System.out.println("Warning: Some Other exception");
		}
		System.out.println("Out of try-catch block...");
		return customerAccountNumber;
	}

	public void printAll() {

		for (int i = 0; i < myCustomerArrayList.size(); i++) {
			boolean isValid = myCustomerArrayList.get(i).isFlag();
			if (isValid) {
				System.out.println(myCustomerArrayList.get(i));
			}
		}
	}

	@Override
	public Customer[] getAllCustomersInBank() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateAccountFromAccountNo(String acno, String name, String addes, String dob, String pan,
			String adhar) {
		for (int j = 0; j < myCustomerArrayList.size(); j++) {

			Customer cust = myCustomerArrayList.get(j);

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

	@Override
	public ArrayList<Customer> deleteAccount(String delCust) {
		for (int i = 0; i < myCustomerArrayList.size(); i++) {
			if (myCustomerArrayList.get(i).getCustomerAccno().equals(delCust)) {
				myCustomerArrayList.get(i).setFlag(false);
				return myCustomerArrayList;
			}
		}
		return null;
	}

	@Override
	public Customer depositMoney(int amount, String accountNumber) {
		for (int i = 0; i < myCustomerArrayList.size(); i++) {
			Customer cust = myCustomerArrayList.get(i);
			if (cust.getCustomerAccno().equals(accountNumber)) {
				int totalMoney = cust.getMoney() + amount;
				cust.setMoney(totalMoney);
				return cust;
			}
		}
		return null;
	}

	@Override
	public Customer withdrawMoney(int amount, String accountNumber) {
		for (int i = 0; i < myCustomerArrayList.size(); i++) {
			Customer cust = myCustomerArrayList.get(i);
			if (cust.getCustomerAccno().equals(accountNumber)) {
				int totalMoney = cust.getMoney() - amount;
				cust.setMoney(totalMoney);
				return cust;
			}
		}
		return null;
	}

	@Override
	public Customer getAccountFromAccountNumber(String AccountNo1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeFile() throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void printOneAcc(String oneCustomer) {
		for (int j = 0; j < myCustomerArrayList.size(); j++) {
			Customer cust = myCustomerArrayList.get(j);
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

	@Override
	public void readFile() throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void readFile_Version1() throws IOException {

		FileReader myReader = new FileReader("temp3.txt");
		BufferedReader in = new BufferedReader(myReader);

		String line;

		while ((line = in.readLine()) != null) {
			// System.out.println(line);

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
				cust.setFlag(true);
			}
			myCustomerArrayList.add(cust);

			// myCustomerArraylist.add(customerCounter) = cust;
			customerCounter++;

		}

		in.close();
		// System.out.println(customerCounter);

	}

	@Override
	public void createHaandle() throws IOException {
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
		try {
			int money = (Integer.parseInt(sc.nextLine().trim()));
			String AccountNo = createAccountInBank(name, dob, address, pan, adhar, money); // "SNGURB-1"
			System.out.println("Account has been successfully created with account number :" + AccountNo);
		} catch (NumberFormatException ex) {
			// handle your exception
			System.out.println("Number Format Exception");
		}

	}

	@Override
	public void updateHandle() {
		System.out.println("");
		try {
			System.out.print("Enter Account Number in Format->SNGURB-1:");

			String acno = sc.nextLine();
			System.out.print("Enter Name of AccountHolder:");
			String name = sc.nextLine();
			System.out.print("Enter Date of Birth (dd-mm-yyyy):");
			String dob = sc.nextLine();
			System.out.print("Enter Address of Account Holder:");
			String address = sc.nextLine();
			System.out.print("Enter PAN of 1" + "Account Holder:");
			String pan = sc.nextLine();
			System.out.print("Enter AdharNumber of AccountHolder:");
			String adhar = sc.nextLine();
			// System.out.println("Enter Money for opening account:");
			// money = (Integer.parseInt(sc.nextLine().trim()));
			Customer customer2 = updateAccountFromAccountNo(acno, name, dob, address, pan, adhar);
			System.out.print(customer2);
		} catch (Exception e) {
			System.out.println("Enter String In Correct Format");
		}

	}

	@Override
	public void deleteHandle(String accountNumber) {
		try {
			deleteAccount(accountNumber);
			System.out.println("Account deleted");

		} catch (Exception e) {
			System.out.println("Enter String In Correct Format");
		}

	}

	@Override
	public void printOneHandle() {
		System.out.print("Enter Account Number to be Printed in Format->SNGURB-1:");
		String acno = sc.nextLine();
		printOneAcc(acno);

	}

	@Override
	public void depositHandle() {
		System.out.print("Enter Account Number In Which Amount To be Deposited:");
		String acno = sc.nextLine();
		System.out.print("Enter Amount to be Deposited in Account");
		try {
			int money = (Integer.parseInt(sc.nextLine().trim()));
			if (depositMoney(money, acno) == null) {
				System.out.println("String is null");
			}
		} catch (NumberFormatException e) {
			System.out.println("Enter Numbers only");
		}

	}

	@Override
	public void withdrawHandle() {
		System.out.println("Enter Account Number In Which Amount To be Withdrawl:");
		String acno = sc.nextLine();
		System.out.println("Enter Amount to be withdraw from Account");

		try {
			int money = (Integer.parseInt(sc.nextLine().trim()));
			withdrawMoney(money, acno);
		} catch (Exception e) {
			System.out.println("Enter Numbers only");

		}
	}

	@Override
	public String getAcccountNumber(Scanner sc) {
		// TODO Auto-generated method stub
		return null;
	}
}
