package so.what;
// Account.java
// Represents a bank account

public class Account 
{
   private int accountNumber; // account number
   private int pin; // PIN for authentication
   private int availableBalance; // funds available for withdrawal
  
   
   // Account constructor initializes attributes
   public Account( int theAccountNumber, int i, 
      int theAvailableBalance)
   {
      accountNumber = theAccountNumber;
      pin = i;
      availableBalance = theAvailableBalance;
    } // end Account constructor
   
   public boolean validatePIN( int userPIN )
   {
      if ( userPIN == pin )
         return true;
      else
         return false;
   } // determines whether a user-specified PIN matches PIN in Account
   
   
   public double getAvailableBalance()
   {
      return availableBalance;
   } // end getAvailableBalance

   
   /*
   // end method validatePIN
   
   // returns available balance
 
   // returns the total balance
   public double getTotalBalance()
   {
      return totalBalance;
   } // end method getTotalBalance

   // credits an amount to the account
   public void credit( double amount )
   {
      totalBalance += amount; // add to total balance
   } // end method credit

   // debits an amount from the account
   public void debit( double amount )
   {
      availableBalance -= amount; // subtract from available balance
      totalBalance -= amount; // subtract from total balance
   } // end method debit

   // returns account number
   public int getAccountNumber()
   {
      return accountNumber;  
   } // end method getAccountNumber

public boolean verifyPIN(int oldPIN) {
	// TODO Auto-generated method stub
	if(oldPIN == pin)
	{
		
		return true;
	}
	return false;
	
	
}

public void changePIN() {
	// TODO Auto-generated method stub
	Screen.displayMessageLine("Enter new PIN");
	int newPIN=new Keypad().getInput();
	pin=newPIN;
	
	
}
*/

@Override
public String toString() {
	// TODO Auto-generated method stub
	 String str="Acc no: " + accountNumber + " Pin: " + pin + " Balance: " + availableBalance;
	 return str;
}
   
} // end class Account


/**************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/