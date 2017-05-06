package learn.basic.javaclasses;

import java.util.ArrayList;

/**
 * This class will implement arraylist instead of Array
 * This class will implement delete, create, update and print methods in different way
 * It will not delete the 'customer object' from the Array, instead it will soft-delete it.
 * Meaning, there will be a boolean flag in each customer object. It will be true if the customer is active,
 * otherwise it will be false.
 * While printing: print only customer for whom the flag is 'true'
 * implement getCustomerCount method such that, it will return the count of customers for whom the flag is true
 * For assigning account number, the size/length of arraylist will be used*/

public class BankVersion2{

	// This is an eaxmple of using Arraylist
	public static void main(String[] args) {
		// Arraylist is of type collection, which can be used to replace array
		// Similar to array it can contain more than one primitive data types as well as Objects
		
		String[] myCustomerArray = new String[100];
		Customer[] myAnothercustomerArray = new Customer [20];
		
		ArrayList<String> myArraylist = new ArrayList<String>();
		ArrayList<Customer> myCustomerArraylist = new ArrayList<Customer>();
		
		myCustomerArray[0] = "myString";
		
		myArraylist.add("String");
		myArraylist.add("MyString");
		myArraylist.add("MyThirdString");
//		myCustomerArraylist.add(new Customer());
//		System.out.println(myArraylist.get(0));
//		System.out.println(myArraylist.get(1));
//		System.out.println(myArraylist.size());
		
		for(int i=0; i< myArraylist.size();i++){
			System.out.println(myArraylist.get(i));
		}
		
	}
}
