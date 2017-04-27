package learn.basic.javaclasses;

import java.util.Scanner;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.print("Enter month (valid values are from 1 to 12): ");

		TestClass c = new TestClass();
		// int money = c.getInt();
		// System.out.println("Money " + money);

		System.out.print("Enter month (Enter Account Number: ");
		String acno = c.getAcno();
		System.out.println("Account Number" + acno);
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
			monthScan.close();
			return getInt();
		}
	}

	public String getAcno() {
		Scanner accountScan = new Scanner(System.in);
		String acno;
		try {
			acno = accountScan.nextLine();
			if (acno.equals(acno.startsWith("SNGURB-"))) {
				accountScan.close();
				return acno;
			} else {
				System.out.println("TRY AGAIN");
				return getAcno();
			}

		} catch (Exception e) {
			System.out.println("Try again");
			return getAcno();
		}

	}

}
