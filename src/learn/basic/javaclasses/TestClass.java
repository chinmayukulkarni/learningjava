package learn.basic.javaclasses;

import java.util.Scanner;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter month (valid values are from 1 to 12): ");

		TestClass c = new TestClass();
		int money = c.getInt();
		System.out.println("Money "+ money);
	}

	public int getInt() {
		Scanner monthScan = new Scanner(System.in);
		int money;
		try {
			money = monthScan.nextInt();
			monthScan.close();
			return money;
		} catch (Exception e) {
			System.out.println("Try again");
			return getInt();
		}

	}

}
