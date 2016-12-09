package so.what;
// Deposit.java
// Represents a deposit ATM transaction

public class Deposit extends Transaction
{
   private int amount; // amount to deposit
   private Keypad keypad; // reference to keypad
   private DepositSlot depositSlot; // reference to deposit slot
   private final static int CANCELED = 0; // constant for cancel option

   // Deposit constructor
   public Deposit( int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase, Keypad atmKeypad, 
      DepositSlot atmDepositSlot )
   {
      // initialize superclass variables
      super( userAccountNumber,  atmBankDatabase );

      // initialize references to keypad and deposit slot
      keypad = atmKeypad;
      depositSlot = atmDepositSlot;
   } // end Deposit constructor

   // perform transaction
   @Override
   public void execute()
   {
      //Screen screen = getScreen(); // get reference

      amount = promptForDepositAmount(); // get deposit amount from user

      // check whether user entered a deposit amount or canceled
      if ( amount != CANCELED )
      {
         // request deposit envelope containing specified amount
         Screen.displayMessage( 
            "\nPlease insert a deposit envelope containing " );
         Screen.displayDollarAmount( amount );
         Screen.displayMessageLine( "." );

         // receive deposit envelope
         boolean envelopeReceived = depositSlot.isEnvelopeReceived();

         // check whether deposit envelope was received
         if ( envelopeReceived )
         {  
            Screen.displayMessageLine( "\nYour envelope has been " + 
               "received.\nNOTE: The money just deposited will not " + 
               "be available until we verify the amount of any " +
               "enclosed cash and your checks clear." );
            
            // credit account to reflect the deposit
            getBankDatabase().credit( getAccountNumber(), amount ); 
         } // end if
         else // deposit envelope not received
         {
            Screen.displayMessageLine( "\nYou did not insert an " +
               "envelope, so the ATM has canceled your transaction." );
         } // end else
      } // end if 
      else // user canceled instead of entering amount
      {
         Screen.displayMessageLine( "\nCanceling transaction..." );
      } // end else
   } // end method execute

   // prompt user to enter a deposit amount in cents 
   private int promptForDepositAmount()
   {
      //Screen screen = getScreen(); // get reference to screen

      // display the prompt
      Screen.displayMessage( "\nPlease enter a deposit amount in " + 
         "CENTS (or 0 to cancel): " );
      int input = keypad.getInput(); // receive input of deposit amount
      
      // check whether the user canceled or entered a valid amount
      if ( input == CANCELED ) 
         return CANCELED;
      else
      {
         return  input; // return dollar amount 
      } // end else
   } // end method promptForDepositAmount
} // end class Deposit



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