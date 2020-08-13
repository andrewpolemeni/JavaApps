package bank_account_application;

public class Checking extends Account {
	// List properties specific to a checking account
	int debitCardNumber;
	int debitCardPin;
	
	// Constructor to initialize checking amount properties.
	public Checking(String name, String ssn, double initDeposit) {
		super(name, ssn, initDeposit);
		accountNumber = "1" + accountNumber;
		setDebitCard();
	}
	
	@Override
	public void setRate() {
		rate = getBaseRate() * 0.15;
	}
	
	private void setDebitCard() {
		debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
		debitCardPin = (int) (Math.random() * Math.pow(10, 6));
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println("\nYour Checking Account Features: " + 
					"\nDebit Card Number: " + debitCardNumber +
					"\nDebit Card Pin: " + debitCardPin
				);
	}
}
