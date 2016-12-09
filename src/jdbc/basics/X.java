package jdbc.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class X {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String url ="jdbc:h2:tcp://localhost/test";
		String dn ="org.h2.Driver"; //this class would not avaiable if you did n ot
		//include hte jar file
		String userid ="sa";
		String password="";
		
		Class.forName(dn);
		
		Connection con = DriverManager.getConnection(url,userid,password);
			if( con != null)
					System.out.println("connection got"); //first milestone
			//we have established communication with a particualr database
			//on a particualr database server.
			
	
		
		
		
		
		
		
		

	}

}
