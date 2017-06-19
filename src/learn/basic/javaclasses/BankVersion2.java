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
import java.util.regex.Pattern;

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
	String name1 = null;
	boolean ready;
	int b2;

	int money2 = 0;

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
				cust.setCustomerAdhar(st.nextToken().trim());
				cust.setMoney(st.nextToken().trim());
				cust.setMobNo(st.nextToken().trim());
			}
			myCustomerArrayList.add(cust);

			// myCustomerArraylist.add(customerCounter) = cust;
			customerCounter++;

		}

		in.close();
		// System.out.println(customerCounter);
	}

	public String createAccountInBank(String name, String dob, String addes, String pan, String adhar, String money,
			String mobNo) throws IOException {

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
		/**
		 * public void displayStudents (){ System.out.println
		 * ("\n-----------------------------"); System.out.println (
		 * "Email System - Display Students"); System.out.println
		 * ("-----------------------------");
		 * System.out.format("%10s%15d%15s%15s%20s", "Grade", "Last Name",
		 * "First Name", "Student Number", "Parent Email");
		 * 
		 * StudentNode current = top; while (current != null){ Student read =
		 * current.getStudentNode(); System.out.format ("%10s%15d%15s%15s%20s",
		 * ""+read.getClass(), read.getLastName(), read.getFirstName(),
		 * ""+read.getStudentNum(), read.getParentEmail()); //This will output
		 * with a set number of character spaces per field, giving the list a
		 * table-like quality } }//End of displayStudents
		 */

		System.out.format("%-15s%-15s%-15s%-25s%-17s%-17s%-15s", "Name", "Account no", "DOB", "Address", "Pan", "Adhar",
				"Mob no");
		System.out.println(" ");

		for (int i = 0; i < myCustomerArrayList.size(); i++) {
			boolean isValid = myCustomerArrayList.get(i).isFlag();
			if (isValid) {

				System.out.format("%-15s%-15s%-15s%-25s%-17s%-17s%-15s", myCustomerArrayList.get(i).getCustomerName(),
						myCustomerArrayList.get(i).getCustomerAccno(), myCustomerArrayList.get(i).getCustomerDOB(),
						myCustomerArrayList.get(i).getCustomerAddress(), myCustomerArrayList.get(i).getCustomerPAN(),
						myCustomerArrayList.get(i).getCustomerAdhar(), myCustomerArrayList.get(i).getMobNo());
				System.out.println(
						"\n--------------------------------------------------------------------------------------------------------------------");
			}
		}
	}

	@Override
	public Customer[] getAllCustomersInBank() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateAccountFromAccountNo(String acno, String name, String dob, String addes, String pan,
			String adhar, String mobNo) {
		try {
			for (int i = 0; i < myCustomerArrayList.size(); i++) {

				Customer cust = myCustomerArrayList.get(i);

				if (cust.getCustomerAccno().equals(acno)) {
					cust.setCustomerAccno(acno);
					cust.setCustomerName(name);
					cust.setCustomerDOB(dob);
					cust.setCustomerAddress(addes);
					cust.setCustomerPAN(pan);
					cust.setCustomerAdhar(adhar);
					cust.setMobNo(mobNo);
					return cust;

				}

			}
		} catch (Exception e) {

			System.out.println("Error" + e);
		}

		return null;
	}

	@Override
	public Customer depositMoney(int amount, String accountNumber) {
		for (int i = 0; i < myCustomerArrayList.size(); i++) {
			Customer cust = myCustomerArrayList.get(i);
			if (cust.getCustomerAccno().equals(accountNumber)) {
				int totalMoney = Integer.parseInt(cust.getMoney()) + amount;
				String totalMoney1 = Integer.toString(totalMoney);
				cust.setMoney(totalMoney1);
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
				int totalMoney = Integer.parseInt(cust.getMoney()) - amount;
				String totalMoney1 = Integer.toString(totalMoney);
				cust.setMoney(totalMoney1);
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
		String file = "temp3.txt";
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
				System.out.println("Single Account Printed Successfully");
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

				cust.setCustomerName(st.nextToken().trim());
				cust.setCustomerAccno(st.nextToken().trim());
				cust.setCustomerDOB(st.nextToken().trim());
				cust.setCustomerAddress(st.nextToken().trim());
				cust.setCustomerPAN(st.nextToken().trim());
				cust.setCustomerAdhar(st.nextToken().trim());
				cust.setMoney(st.nextToken().trim());

				if (st.nextToken().trim().equals("true")) {
					cust.setFlag(true);
				} else {
					cust.setFlag(false);
				}

				cust.setMobNo(st.nextToken().trim());
			}
			myCustomerArrayList.add(cust);

			// myCustomerArraylist.add(customerCounter) = cust;
			customerCounter++;

		}

		in.close();
		// System.out.println(customerCounter);

	}

	@Override
	public void createHandle() throws IOException {

		// System.out.print("Enter Name of AccountHolder:");
		String name = getName();
		if (name.equals("exit")) {
			return;
		}

		// System.out.print("Enter Date of Birth (yyyy-MM-dd):");
		String dob = getDate();

		System.out.print("Enter Address of Account Holder:");
		String rightTrimedAddress = sc1.nextLine().trim();
		String address = rightTrimedAddress.replaceAll("^\\s+", "");
		if (name.equals("exit")) {
			return;
		}
		System.out.print("Enter PAN of Account Holder:");
		String rightTrimedPan = sc1.nextLine().trim();
		String pan = rightTrimedPan.replaceAll("^\\s+", "");
		if (name.equals("exit")) {
			return;
		}
		System.out.print("Enter AdharNumber of AccountHolder:");
		String adhar = getAdhar();
		if (name.equals("exit")) {
			return;
		}
		System.out.print("Enter Mobile Number:");
		String mobNo = getMobNo();

		System.out.print("Enter Money for opening account:");

		String money = Integer.toString(getCash());

		String AccountNo = createAccountInBank(name, dob, address, pan, adhar, money, mobNo); // "SNGURB-1"
		System.out.println("Account has been successfully created with account number :" + AccountNo);

	}

	/*
	 * 
	 * boolean isContinue = findIfUserWantsToContinue();
	 * 
	 * while(isContinue){ Here you write the code to update the account }
	 * 
	 * ------------------------------- Method to get birthday, return String
	 * boolean isValid = true; String bday = null; while(isValid){ bday =
	 * isValidBdayString(); if (bday != null) isValid = false; } return bday;
	 * --------------------
	 * 
	 * isValidBdayString(){
	 *
	 * Get the input string from scanner User Regex and validate string if
	 * correct then return String otherwise return null
	 * 
	 * if user enters to exit then return "exit"
	 *
	 * }
	 * 
	 * What is the value of 'bday'? any number...12312312312
	 * System.out.println(Pattern.matches(".s", "as"));//true (2nd char is s)
	 * 
	 * System.out.println(Pattern.matches("[a-z]*+@gmail.com",
	 * "chinmay@gmail.com"));
	 * 
	 * System.out.println(Pattern.matches("[a-z A-Z]*", "Chinmay Kulkanrni"));
	 */

	@Override
	public void updateHandle() {
		boolean exit1 = true;
		String name = null;

		try {
			// if (exit2) {
			String acno = getAccountNumber();
			if (acno.equals("exit")) {
				return;
			}
			// System.out.print("Enter Account Number in
			// Format->SNGURB-1:");
			// String acno = sc1.nextLine();
			for (int i = 0; i < myCustomerArrayList.size(); i++) {

				// Check if the account number is valid and matches with the
				// customer Number
				if ((myCustomerArrayList.get(i).isFlag())
						&& (acno.equals(myCustomerArrayList.get(i).getCustomerAccno()))) {

					name = getName();
					System.out.println("Valid String is: " + name);

					if (name.equals("exit")) {
						break;
					}

					System.out.print("Enter Date of Birth (yyyy-MM-dd):");
					String dob = getDate();

					System.out.print("Enter Address of Account Holder:");
					String rightTrimedAddress = sc1.nextLine().trim();
					String address = rightTrimedAddress.replaceAll("^\\s+", "");
					if (address.equals("exit")) {
						exit1 = false;
						break;
					}
					System.out.print("Enter PAN of Account Holder:");
					String rightTrimedPan = sc1.nextLine().trim();
					String pan = rightTrimedPan.replaceAll("^\\s+", "");

					System.out.print("Enter AdharNumber f AccountHolder:");
					String adhar = getAdhar();
					if (adhar.equals("exit")) {
						exit1 = false;
						break;
					}
					System.out.print("Enter 10 Digit Mobile Number:");
					String mobNo = getMobNo();
					if (mobNo.equals("exit")) {
						exit1 = false;
						break;
					}
					// System.out.println("Enter Money for opening
					// account:");
					// money = (Integer.parseInt(sc.nextLine().trim()));
					Customer customer2 = updateAccountFromAccountNo(acno, name, dob, address, pan, adhar, mobNo);
					System.out.println(customer2);
					System.out.println("Account Update Successfully");
					exit1 = false;
				}
			}
			if (exit1) {
				System.out.println("Account Not Present in Database");
			}
			// System.out.println("Do you want to continue Update
			// Acount?(1/0)");
			// bl = Integer.parseInt(sc1.nextLine().trim());
			// while (bl == 1) {
			// updateHandle();
			// bl = 0;
			// }
			// }
		} catch (Exception e) {

			e.printStackTrace();
			// System.out.println("Enter In Correct Format");
			// System.out.println("Do you want to continue Update
			// Acount?(1/0)");
			// bl = Integer.parseInt(sc1.nextLine().trim());
			//
			// while (bl == 1) {
			// updateHandle();
			// bl = 0;
			// }
		}

	}

	@Override
	public void deleteHandle() {

		try {
			String accountNumber = getAccountNumber();
			if (accountNumber.equals("exit")) {
				return;
			} else
				deleteAccount(accountNumber);

		} catch (Exception e) {
			System.out.println("Enter String In Correct Format" + e);

		}

	}

	@Override
	public void printOneHandle() {

		boolean exit2 = true;
		int b1;
		try {

			String acno = getAccountNumber();
			if (acno.equals("exit")) {
				return;
			}
			for (int i = 0; i < myCustomerArrayList.size(); i++) {

				// Check if the account number is valid and matches with the
				// customer Number
				if ((myCustomerArrayList.get(i).isFlag())
						&& (acno.equals(myCustomerArrayList.get(i).getCustomerAccno()))) {

					printOneAcc(acno);

					exit2 = false;
				}
			}
			if (exit2) {
				System.out.println("Account Not Present in Database");
			}
			System.out.println("Do you want to continue?(1/0)");
			b1 = Integer.parseInt(sc1.nextLine().trim());
			while (b1 == 1) {
				printOneHandle();
				b1 = 0;
			}
		} catch (Exception e) {
			System.out.println("Enter In Correct Format" + e);

		}

	}

	public int isValidDeposit(String acno) {

		int money = getCash();
		depositMoney(money, acno);
		System.out.println("Amount Deposited Successfully");
		return money;
	}

	@Override
	public int depositHandle() {
		String acno = getAccountNumber();
		boolean noacno = true;
		int money = 0;
		for (int i = 0; i < myCustomerArrayList.size(); i++) {
			if (myCustomerArrayList.get(i).getCustomerAccno().equals(acno)) {
				noacno = false;
				money = isValidDeposit(acno);
				while (money == 0) {
					// System.out.println("Enter amount to Deposit:");
					money = isValidDeposit(acno);
				}
			}
		}
		if (noacno) {
			System.out.println("Account not present in Database");
		}
		return money;
	}

	public int isValidWithdrawl(String acno) {

		int money = getCash();
		withdrawMoney(money, acno);
		System.out.println("Amount Withdrawl Successfully");
		return money;
	}

	@Override
	public int withdrawHandle() {
		String acno = getAccountNumber();
		boolean noacno = true;
		int money = 0;
		for (int i = 0; i < myCustomerArrayList.size(); i++) {
			if (myCustomerArrayList.get(i).getCustomerAccno().equals(acno)) {
				noacno = false;
				money = isValidWithdrawl(acno);
				while (money == 0) {
					// System.out.println("Enter amount to Deposit:");
					money = isValidWithdrawl(acno);
				}
			}
		}
		if (noacno) {
			System.out.println("Account not present in Database");
		}
		return money;
	}
	// int money = 0;
	// System.out.println("Enter Account Number In Which Amount To be
	// Withdrawl:");
	// String acno = sc1.nextLine().trim();
	// for (int i = 0; i < myCustomerArrayList.size(); i++) {
	// if (myCustomerArrayList.get(i).getCustomerAccno().equals(acno)) {
	// System.out.println("Enter Amount to be withdraw from Account");
	//
	// try {
	// money = sc1.nextLine().trim();
	// withdrawMoney(money, acno);
	// System.out.println("Money Withdraw Successfully!");
	// } catch (Exception e) {
	// System.out.println("Enter Numbers only");
	// withdrawHandle();
	// }
	// } else {
	// System.out.println("Enter Correct Account Number only");
	// withdrawHandle();
	// }
	// }

	@Override
	public String getValidAcccountNumber() {

		System.out.println("Enter account Number to be Printed in Format->SNGURB-1");
		String rightTrimedacno = sc1.nextLine().trim();
		String acno = rightTrimedacno.replaceAll("^\\s+", "");
		if (acno.startsWith("SNGURB")) {
			// return sc1;
			return acno;
		} else if (acno.equals("exit")) {
			return "exit";
		} else {
			return null;
		}
	}

	public String getAccountNumber() {
		String acno = getValidAcccountNumber();
		while (acno == null) {
			acno = getValidAcccountNumber();
		}
		return acno;
	}

	@Override
	public ArrayList<Customer> deleteAccount(String delcust) {
		try {
			for (int i = 0; i < myCustomerArrayList.size(); i++) {
				if (myCustomerArrayList.get(i).isFlag()) {
					while (delcust.equals(myCustomerArrayList.get(i).getCustomerAccno())) {

						if (myCustomerArrayList.get(i).getCustomerAccno().equals(delcust)) {

							myCustomerArrayList.get(i).setFlag(false);
							System.out.println("Account Deleted Successfully");
							return myCustomerArrayList;
						}
					}
				}
			}
			System.out.println("Account Not Present in Database");
			deleteHandle();
		} catch (Exception e) {
			System.out.println("Enter Correct Account number");
			deleteHandle();
		}
		return null;
	}

	public String getNameHandle() {
		// !name1.equals("exit")

		String name = name1;
		// ready = false;
		// b2 = 0;
		return name;

	}

	/**
	 * This method will either return a valid name or null
	 * 
	 * @return
	 */
	public String getValidName() {

		System.out.print("Enter Name of AccountHolder:(or exit)");
		String rightTrimed = sc1.nextLine().trim();
		String name = rightTrimed.replaceAll("^\\s+", "");
		boolean ready = Pattern.matches("[a-z A-Z]*", name);

		if (ready) {
			return name;
		} else {
			return null;
		}
	}

	public String getName() {

		String returnedString = getValidName();
		while (returnedString == null) {
			System.out.println("Given Input Is Invalid");
			System.out.println("Name should not contain any numbers And Special Characters");
			returnedString = getValidName();
		}
		return returnedString;
	}

	/*
	 * public String getName() { boolean ready5 = true; if (ready5) { String
	 * name4 = null; System.out.print("Enter Name of AccountHolder:(or exit)");
	 * name1 = sc1.nextLine().trim(); ready = Pattern.matches("[a-z A-Z]*",
	 * name1); if (ready) { if (name1.equals("exit")) { ready = false; b2 = 0;
	 * return null; } else { name4 = getNameHandle(); } } else {
	 * System.out.println("Do you want to continue(1/0)?"); b2 = sc1.nextInt();
	 * while (b2 == 1) { getName(); b2 = 0; } } } return name4; }
	 */
	/**
	 * This method returns a mobile number if user input is a valid string,
	 * otherwise it returns null.
	 * 
	 * @return
	 */
	public String getValidMobileNo() {

		String rightTrimedMobileNumber = sc1.nextLine().trim();
		String mobileNumber = rightTrimedMobileNumber.replaceAll("^\\s+", "");
		boolean isValidMobNo = Pattern.matches("^[1-9][0-9]{9}", mobileNumber);
		if (isValidMobNo) {
			return mobileNumber;
		} else if (mobileNumber.equals("exit")) {
			return "exit";
		} else
			return null;
	}

	public String getMobNo() {
		String phoneNo = getValidMobileNo();
		while (phoneNo == null) {
			System.out.println("Enter correct Mobile no or exit to return:");
			phoneNo = getValidMobileNo();
		}
		return phoneNo;
	}

	public String getValidAdhar() {
		String rightTrimedAdhar = sc1.nextLine().trim();
		String adhar = rightTrimedAdhar.replaceAll("^\\s+", "");
		boolean ready2 = Pattern.matches("^[1-9][0-9]{15}", adhar);
		if (ready2) {
			return adhar;
		} else if (adhar.equals("exit")) {
			return "exit";
		} else
			return null;
	}

	public String getAdhar() {
		String adhar = getValidAdhar();
		while (adhar == null) {
			System.out.println("Adhar Number Must Contain Digits Only");
			System.out.println("Special Characters And Symbols Are Not Allowed");
			System.out.println("Enter 16 digit Adhar number or Enter 'exit' to return:");
			adhar = getValidAdhar();
		}
		return adhar;
	}

	public String getValidDate() {
		System.out.println("Enter Date in yyyy-MM-dd Format");
		String rightTrimedDate = sc1.nextLine().trim();
		String date = rightTrimedDate.replaceAll("^\\s+", "");
		boolean isVslidDate = Pattern.matches("\\d{4}-[01]\\d-[0-3]\\d", date);
		if (isVslidDate) {
			return date;
		} else if (date.equals("exit")) {
			return "exit";
		}
		return null;
	}

	public String getDate() {
		String date = getValidDate();
		while (date == null) {
			System.out.println("Given Input is not Valid");
			System.out.println("Alphabets and Digits are not allowed");
			System.out.println("Enter Valid Date in yyyy-MM-dd Format");
			date = getValidDate();
		}
		return date;
	}

	public int getValidMoney() {
		int money1 = 0;
		System.out.println("Enter Amount:");
		String rightTrimedMoney = sc1.nextLine().trim();
		String money = rightTrimedMoney.replaceAll("^\\s+", "");
		boolean validMoney = Pattern.matches("^[1-9][0-9]*", money);
		if (validMoney) {
			money1 = Integer.parseInt(money);

			return money1;
		} else {
			return 0;
		}
	}

	public int getCash() {
		int money1 = 0;// Integer.toString()
		money1 = getValidMoney();

		while (money1 == 0) {
			System.out.println("Given Input is not Valid");
			System.out.println("Alphabets are not allowed");
			money1 = getValidMoney();
		}

		return money1;

	}
}
