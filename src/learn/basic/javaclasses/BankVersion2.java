package learn.basic.javaclasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
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
	Scanner sc1 = new Scanner(System.in);

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
	// BankVersion2 bk = new BankVersion2();

	Customer ck = new Customer();
	int customerCounter = 0;

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
				cust.setMobNo(Integer.parseInt(st.nextToken().trim()));
			}
			myCustomerArrayList.add(cust);

			// myCustomerArraylist.add(customerCounter) = cust;
			customerCounter++;

		}

		in.close();
		// System.out.println(customerCounter);
	}

	public String createAccountInBank(String name, String dob, String addes, String pan, String adhar, int money,
			int mobNo) throws IOException {

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
			cs.setMobNo(mobNo);
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
		System.out.format("%8s%10s%15s%15s%17s%17s%15s", "Name", "Account no", "DOB", "Address", "Pan", "Adhar",
				"Mob no");
		System.out.println(" ");

		for (int i = 0; i < myCustomerArrayList.size(); i++) {
			boolean isValid = myCustomerArrayList.get(i).isFlag();
			if (isValid) {

				System.out.format("%8s%10s%15s%15s%17s%17s%15s", "" + myCustomerArrayList.get(i).getCustomerName(),
						myCustomerArrayList.get(i).getCustomerAccno(), myCustomerArrayList.get(i).getCustomerDOB(),
						"" + myCustomerArrayList.get(i).getCustomerAddress(),
						myCustomerArrayList.get(i).getCustomerPAN(), myCustomerArrayList.get(i).getCustomerAdhar(),
						myCustomerArrayList.get(i).getMobNo());
				System.out.println("\n-----------------------------");
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
			String adhar, int mobNo) {
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
		return null;
	}

	@Override
	public void writeFile() throws IOException {
		String file = "temp4.txt";
		File FileRefrance = new File(file);
		if (FileRefrance.exists()) {
			System.out.println("File exists");

		} else {
			System.out.println("File does not exist new one created");
		}

		OutputStream outstream = new FileOutputStream(file);
		// System.out.println("Account Number is: " + accountNumber);
		// outstream.write((accountNumber + "").getBytes());
		// outstream.write("\n".getBytes());
		for (int i = 0; i < customerCounter; i++) {
			Customer customer = myCustomerArrayList.get(i);

			String customerInStringFormat = customer.toString();
			outstream.write(customerInStringFormat.getBytes());
			outstream.write("\n".getBytes());
		}
		outstream.close();
	}

	@Override
	public void printOneAcc(String oneCustomer) {
		for (int j = 0; j < myCustomerArrayList.size(); j++) {
			Customer cust = myCustomerArrayList.get(j);
			if (cust.getCustomerAccno().equals(oneCustomer)) {

				System.out.println("One Customer Detail: ");
				System.out.println("Account Number is:" + cust.getCustomerAccno());
				System.out.println("Customer Name is" + cust.getCustomerName());
				System.out.println("DOB is:" + cust.getCustomerDOB());
				System.out.println("Address:" + cust.getCustomerAddress());
				System.out.println("Pan:" + cust.getCustomerPAN());
				System.out.println("Adhar:" + cust.getCustomerAdhar());
				System.out.println("Balance:" + cust.getMoney());
				System.out.println(cust.isFlag());
			}
		}

	}

	@Override
	public void readFile() throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void readFile_Version1() throws IOException {

		FileReader myReader = new FileReader("temp4.txt");
		BufferedReader in = new BufferedReader(myReader);

		String line;

		while ((line = in.readLine()) != null) {
			// System.out.println(line);

			Customer cust = new Customer();
			StringTokenizer st = new StringTokenizer(line, "|");
			while (st.hasMoreTokens()) {

				cust.setCustomerName(st.nextToken().trim());
				cust.setCustomerAccno(st.nextToken().trim());
				cust.setCustomerDOB(st.nextToken().trim());
				cust.setCustomerAddress(st.nextToken().trim());
				cust.setCustomerPAN(st.nextToken().trim());
				cust.setCustomerAdhar(st.nextToken().trim());
				cust.setMoney(Integer.parseInt(st.nextToken().trim()));

				// if (st.nextToken().trim().equals(true)) {
				cust.setFlag(true);
				// } else {
				// cust.setFlag(false);
				// }
				cust.setMobNo(Integer.parseInt(st.nextToken().trim()));
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

		System.out.print("Enter Name of AccountHolder:");
		String name = sc1.nextLine();

		System.out.print("Enter Date of Birth (dd-mm-yyyy):");
		String dob = sc1.nextLine();

		System.out.print("Enter Address of Account Holder:");
		String address = sc1.nextLine();
		System.out.print("Enter PAN of Account Holder:");
		String pan = sc1.nextLine();

		System.out.print("Enter AdharNumber of AccountHolder:");
		String adhar = sc1.nextLine();

		System.out.print("Enter Mobile Number:");
		int mobNo = Integer.parseInt(sc1.nextLine().trim());

		System.out.print("Enter Money for opening account:");
		try {
			int money = (Integer.parseInt(sc1.nextLine().trim()));
			String AccountNo = createAccountInBank(name, dob, address, pan, adhar, money, mobNo); // "SNGURB-1"
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
			// System.out.print("Enter Account Number in Format->SNGURB-1:");
			// String acno = sc1.nextLine();
			String acno = getAcccountNumber(sc1.nextLine());
			System.out.print("Enter Name of AccountHolder:");
			String name = sc1.nextLine();
			System.out.print("Enter Date of Birth (dd-mm-yyyy):");
			String dob = sc1.nextLine();
			System.out.print("Enter Address of Account Holder:");
			String address = sc1.nextLine();
			System.out.print("Enter PAN of Account Holder:");
			String pan = sc1.nextLine();
			System.out.print("Enter AdharNumber of AccountHolder:");
			String adhar = sc1.nextLine();
			System.out.print("Enter Mobile Number:");
			int mobNo = Integer.parseInt(sc1.nextLine().trim());

			// System.out.println("Enter Money for opening account:");
			// money = (Integer.parseInt(sc.nextLine().trim()));
			Customer customer2 = updateAccountFromAccountNo(acno, name, dob, address, pan, adhar, mobNo);
			System.out.println(customer2);
			System.out.println("Account Update Successfully");
		} catch (Exception e) {
			System.out.println("Enter String In Correct Format" + e);
		}

	}

	@Override
	public void deleteHandle() {

		try {

			String delcust = null;
			// getAcccountNumber(delcust);
			deleteAccount(getAcccountNumber(delcust));
			System.out.println("Account deleted Successfully");

		} catch (Exception e) {
			System.out.println("Enter String In Correct Format" + e);
			deleteHandle();
		}

	}

	@Override
	public void printOneHandle() {
		// System.out.print("Enter Account Number to be Printed in
		// Format->SNGURB-1:");
		// String acno = sc1.nextLine();
		String acno = getAcccountNumber(sc1.nextLine());
		printOneAcc(acno);
		System.out.println("Single Account Printed Successfully");
	}

	@Override
	public void depositHandle() {
		System.out.print("Enter Account Number In Which Amount To be Deposited:");
		String acno = sc1.nextLine();
		System.out.print("Enter Amount to be Deposited in Account");
		try {
			int money = (Integer.parseInt(sc1.nextLine().trim()));
			if (depositMoney(money, acno) == null) {
				System.out.println("String is null");
			}
		} catch (NumberFormatException e) {
			System.out.println("Enter Numbers only" + e);
		}

	}

	@Override
	public void withdrawHandle() {
		System.out.println("Enter Account Number In Which Amount To be Withdrawl:");
		String acno = sc1.nextLine();
		System.out.println("Enter Amount to be withdraw from Account");

		try {
			int money = (Integer.parseInt(sc1.nextLine().trim()));
			withdrawMoney(money, acno);
		} catch (Exception e) {
			System.out.println("Enter Numbers only");

		}
	}

	@Override
	public String getAcccountNumber(String delcust) {
		try {
			System.out.println("Enter account Number to be Printed in Format->SNGURB-1");
			String acno = sc1.nextLine();
			if (acno.startsWith("SNGURB")) {
				// return sc1;
				return acno;
			} else {
				System.out.println("TRY AGAIN:");
				return getAcccountNumber(delcust);
			}
		} catch (Exception e) {
			System.out.println("Try again");
			return getAcccountNumber(delcust);
		}
	}

	@Override
	public ArrayList<Customer> deleteAccount(String delcust) {
		for (int i = 0; i < myCustomerArrayList.size(); i++) {
			if (myCustomerArrayList.get(i).getCustomerAccno().equals(delcust)) {
				myCustomerArrayList.get(i).setFlag(false);

				return myCustomerArrayList;
			}
		}
		return null;
	}
}
