package jdbc.basics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class InsertProgram {

	public static void insert(String userid,String password,String email) {
		// TODO Auto-generated method stub
		String sqlCmd  ="insert into user(userid,password,email) values (?,?,?)";
		Connection con = Reuse.get();
		try {
			PreparedStatement stmt =con.prepareStatement(sqlCmd);
			stmt.setString(1, userid);
			stmt.setString(2, password);
			stmt.setString(3,email);
			stmt.executeUpdate(); // it returns an int, but currrenetly we dont 
			//need to hold it becuase we are dealing with insert.
			stmt.close();
			
			System.out.println("everything is nearly working");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println(user.getUserid()  + " is taken choose another");
			
			
		}finally
		{
			 if( con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
		
		
		
		
		
		


	}

}
