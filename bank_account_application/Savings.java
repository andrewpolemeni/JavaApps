package bank_account_application;

public class Savings extends Account {
	// List properties specific to a checking account
	int safteyDepositBoxID;
	int safteyDepositKey;
	
	public Savings(String name, String ssn, double initDeposit) {
		super(name, ssn, initDeposit);
		accountNumber = "2" + accountNumber;
		setSafteyDepositBox();
	}
	
	@Override
	public void setRate() {
		rate = getBaseRate() - 0.25;
	}
	
	private void setSafteyDepositBox() {
		safteyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
		safteyDepositKey = (int) (Math.random() * Math.pow(10, 4));
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println("\nYour savings Account Features"
				+ "\nSaftey Deposit Box ID: " + safteyDepositBoxID + 
				"\nSaftey Deposit Box Key: " + safteyDepositKey);
	}
}
