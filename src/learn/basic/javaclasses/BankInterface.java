package learn.basic.javaclasses;

import java.io.IOException;

public interface BankInterface {
	public String createAccountInBank(String name, String dob, String addes, String pan, String adhar, int money);

	public Customer[] getAllCustomersInBank();

	public Customer updateAccountFromAccountNo(String acno, String name, String addes, String dob, String pan,
			String adhar);

	public Customer[] deleteAccount(String delCust);

	public Customer depositMoney(int amount, String accountNumber);

	public Customer withdrawMoney(int amount, String accountNumber);

	public Customer getAccountFromAccountNumber(String AccountNo1);

	public void printAll();

	public void writeFile() throws IOException;

	public void printOneAcc(String oneCustomer);

	public void readFile() throws IOException;
	
	public void readFile_Version1() throws IOException;
	

}