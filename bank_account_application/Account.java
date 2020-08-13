package bank_account_application;

public abstract class Account implements IBaseRate  {
	// List common properties for savings and checking accounts
	private String name;
	private String ssn;
	private double balance;
	static int index = 10000;
	protected String accountNumber;
	protected double rate;
	
	// Constructor to set base properties and initialize account
	public Account(String name, String ssn, double initDeposit) {
		this.name = name;
		this.ssn = ssn;
		this.balance = initDeposit;
		
		// Set account number
		index++;
		this.accountNumber = setAccountNumber();
		
		setRate();
	}
	
	public abstract void setRate();
	
	private String setAccountNumber() {
		String lastTwoOfSSN = ssn.substring(ssn.length() - 2, ssn.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN + uniqueID + randomNumber;
	}
	
	public void compound() {
		double accuredInterest = balance * (rate/100);
		balance = balance + accuredInterest;
		System.out.println("Accrued Interest: $" + accuredInterest);
		printBalance();
	}
	
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Depositing: " + balance);
		printBalance();
	}
	
	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("Withdrawling " + balance);
		printBalance();
	}
	
	public void transfer(String toWhere, double amount) {
		balance = balance - amount;
		System.out.println("Transfer to: " + toWhere);
		printBalance();
	}
	
	public void printBalance() {
		System.out.println("Your balance is now: $" + balance);
	}
	
	// List common methods
	public void showInfo() {
		System.out.println(
				"NAME: " + name + 
				"\nACCOUNT NUMBER: " + accountNumber +
				"\nBALANCE: " + balance +
				"\nRATE: " + rate + "%"
				);
	}
	
	
}
