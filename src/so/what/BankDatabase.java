package so.what;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.basics.Reuse;
import jdbc.basics.SelectProgram;
import jdbc.basics.UpdateProgram;

// BankDatabase.java
// Represents the bank account information database 

public class BankDatabase
{ 
	Connection con=null;
   // no-argument BankDatabase constructor initializes accounts
   public BankDatabase()
   {
      con= Reuse.get();
	   
   } // end no-argument BankDatabase constructor
   
   // retrieve Account object containing specified account number
   
   // determine whether user-specified account number and PIN match
   // those of an account in the database
   public boolean authenticateUser( int userAccountNumber, int userPIN )
   {
      // attempt to retrieve the account with the account number
      Account userAccount = SelectProgram.getRow( userAccountNumber,con );

      // if account exists, return result of Account method validatePIN
      if ( userAccount != null )
         return userAccount.validatePIN( userPIN );
      else
         return false; // account number not found, so return false
   } // end method authenticateUser

   // return available balance of Account with specified account number
   public double getAvailableBalance( int userAccountNumber )
   {
      return SelectProgram.getRow(userAccountNumber,con).getAvailableBalance();
   } // end method getAvailableBalance

   // return total balance of Account with specified account number

   // credit an amount to Account with specified account number
   public void credit( int userAccountNumber, int amount )
   {
	   UpdateProgram.credit(userAccountNumber,amount,con);
   } // end method credit

   // debit an amount from Account with specified account number
   public void debit( int userAccountNumber, int amount )
   {
	   UpdateProgram.debit(userAccountNumber,amount,con);
 } // end method debit
   public void changePIN(int userAccountNumber, int oldpin,int newpin) {
	// TODO Auto-generated method stub
	   UpdateProgram.pinchange(userAccountNumber,oldpin,newpin,con);
		//   getAccount(userAccountNumber).changePIN();
	   }

public void closeconnection() {
	// TODO Auto-generated method stub
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
 // end class BankDatabase



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