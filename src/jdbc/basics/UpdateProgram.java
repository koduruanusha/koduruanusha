package jdbc.basics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UpdateProgram {


	public static void credit(int userAccountNumber, int amount,Connection con) {
		// TODO Auto-generated method stub
		String sqlCmd  ="update account set balance=balance+? where accountno  = ?";
		try {
			PreparedStatement stmt =con.prepareStatement(sqlCmd);
			stmt.setInt(1, amount);
			stmt.setInt(2, userAccountNumber);
			
			int ra  = stmt.executeUpdate(); // it returns an int, but currrenetly we dont 
			//need to hold it becuase we are dealing with insert.
			stmt.close();
			if( ra > 0)
				System.out.println("Deposit Successful");
			else
					System.out.println(" Deposit not working ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println(user.getUserid()  + " is taken choose another");
			
			
		}
	}
	
	public static void debit(int userAccountNumber, int amount,Connection con) {
		// TODO Auto-generated method stub
		String sqlCmd  ="update account set balance=balance-? where accountno  = ?";
		try {
			PreparedStatement stmt =con.prepareStatement(sqlCmd);
			stmt.setInt(1, amount);
			stmt.setInt(2, userAccountNumber);
			
			int ra  = stmt.executeUpdate(); // it returns an int, but currrenetly we dont 
			//need to hold it becuase we are dealing with insert.
			stmt.close();
			if( ra > 0)
				System.out.println("Withdraw Successful");
			else
					System.out.println(" Withdraw not working ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println(user.getUserid()  + " is taken choose another");
			
			
		}
	}

	public static void pinchange(int userAccountNumber, int oldpin, int newpin,
			Connection con) {
		// TODO Auto-generated method stub
		String sqlCmd  ="update account set pin=? where accountno  = ? and pin=?";
		try {
			PreparedStatement stmt =con.prepareStatement(sqlCmd);
			stmt.setInt(1, newpin);
			stmt.setInt(2, userAccountNumber);
			stmt.setInt(3, oldpin);
			
			int ra  = stmt.executeUpdate(); // it returns an int, but currrenetly we dont 
			//need to hold it becuase we are dealing with insert.
			stmt.close();
			if( ra > 0)
				System.out.println("PIN changed");
			else
					System.out.println("Could not change pin ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println(user.getUserid()  + " is taken choose another");
			
			
		}
	}
}
