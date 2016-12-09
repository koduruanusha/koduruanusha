package jdbc.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Reuse {

	public static Connection get() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Connection con= null;
		String url ="jdbc:h2:tcp://localhost/test";
		String dn ="org.h2.Driver"; //this class would not avaiable if you did n ot
		//include hte jar file
		String userid ="sa";
		String password="";
		
		try {
			Class.forName(dn);//??
			
			 con = DriverManager.getConnection(url,userid,password);
				if( con != null)
						System.out.println("connection got"); //first milestone
				//we have established communication with a particualr database
				//on a particualr database server.
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IllegalArgumentException(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new IllegalArgumentException(e);
		}
			
	
		return con;
		
		
		
		
		
		

	}

}
