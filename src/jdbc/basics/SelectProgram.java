package jdbc.basics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import so.what.Account;

public class SelectProgram {

	public static Account getRow(int userAccountNumber,Connection con) {
		// TODO Auto-generated method stub
	
		
		//new category of command, why you get more data from db to the java world
		// in all other cases it was reacting to feedback from db.
		String sqlCmd  ="select pin,balance from Account where accountno  = ?";
		
		Account user=null;
		try{
			PreparedStatement stmt =con.prepareStatement(sqlCmd);
			stmt.setInt(1, userAccountNumber);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
						String pin = rs.getString("pin");
						String bal = rs.getString("balance");
						user =new Account(userAccountNumber,Integer.parseInt(pin),Integer.parseInt(bal));
			}
				 rs.close();
				stmt.close();

				
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println(user.getUserid()  + " is taken choose another");
			
			
		}
		
		return user;
		
			
		
		

	}
}
