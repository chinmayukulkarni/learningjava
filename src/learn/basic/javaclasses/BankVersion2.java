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

public class BankVersion2  implements BankInterface{
	
	
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
			System.out.println(myCustomerArrayList.get(i));
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer[] deleteAccount(String delCust) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer depositMoney(int amount, String accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer withdrawMoney(int amount, String accountNumber) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateHandle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteHandle(String accountNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printOneHandle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositHandle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdrawHandle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAcccountNumber(Scanner sc) {
		// TODO Auto-generated method stub
		return null;
	}
}
