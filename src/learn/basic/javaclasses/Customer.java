package learn.basic.javaclasses;

public class Customer {
	String customerName;
	String customerAccno;
	String customerDOB;
	String customerAddress;
	String customerPAN;
	String customerAdhar;
	int money;
	

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAccno() {
		return customerAccno;
	}

	public void setCustomerAccno(String customerAccno) {
		this.customerAccno = customerAccno;
	}

	public String getCustomerDOB() {
		return customerDOB;
	}

	public void setCustomerDOB(String customerDOB) {
		this.customerDOB = customerDOB;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPAN() {
		return customerPAN;
	}

	public void setCustomerPAN(String customerPAN) {
		this.customerPAN = customerPAN;
	}

	public String getCustomerAdhar() {
		return customerAdhar;
	}

	public void setCustomerAdhar(String customerAdhar) {
		this.customerAdhar = customerAdhar;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Customer [customer Name=" + customerName + ", customer AccountNumber =" + customerAccno + ", customer DOB="
				+ customerDOB + ", customer Address=" + customerAddress + ", customer PAN=" + customerPAN
				+ ", customer Adhar=" + customerAdhar + ", Money=" + money + "]";
	}

}
