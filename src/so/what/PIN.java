package so.what;



public class PIN extends Transaction {

	PIN(int currentAccountNumber, Screen screen, BankDatabase bankDatabase){
		super(currentAccountNumber,bankDatabase);
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		BankDatabase bankdata=getBankDatabase();
		Screen.displayMessageLine("Enter current PIN");
		int oldPIN=new Keypad().getInput();
		Screen.displayMessageLine("Enter new PIN");
		int newPIN=new Keypad().getInput();
		
		bankdata.changePIN(getAccountNumber(), oldPIN,newPIN);

	}

}
