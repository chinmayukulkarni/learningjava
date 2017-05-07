package learn.basic.javaclasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

public class BankVersion2 {
	ArrayList<Customer> myCustomerArraylist = new ArrayList<Customer>();

	public static void main(String[] args) throws IOException {
		BankVersion2 bk = new BankVersion2();
		bk.readFile_version2();
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
		int customerCounter = 0;
		FileReader myReader = new FileReader("temp2.txt");
		BufferedReader in = new BufferedReader(myReader);

		String line;
		// accountNumber = Integer.parseInt(in.readLine().trim());
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
			myCustomerArraylist.add(cust);

			// myCustomerArraylist.add(customerCounter) = cust;
			customerCounter++;

		}

		in.close();
	}

	public void printAll() {

		for (int i = 0; i < myCustomerArraylist.size(); i++) {
			System.out.println(myCustomerArraylist.get(i));
		}
	}
}
