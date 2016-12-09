package ATM.New;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.basics.Reuse;



public class DIIDB implements DI {
	

	
	private Connection con;
	private boolean connectionfailed=true;
	
	
	public DIIDB()
	{
		try {
			con = Reuse.get();
			connectionfailed= false;
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

	

	public Account getDetailsFromDB(int accno) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Account user =null;
		if(!connectionfailed)
		{
		
		
		String sqlCmd  ="select pin,balance from account  where accountno  = ?";
		try {
			PreparedStatement stmt =con.prepareStatement(sqlCmd);
			stmt.setInt(1, accno);
		
			
			ResultSet rs  = stmt.executeQuery(); // it returns an int, but currrenetly we dont 
			//need to hold it because we are dealing with insert.
			if(rs.next())
			{
				user = new Account(accno, rs.getInt("pin"),rs.getInt("balance"));
					
			}
			else
					user =null;
				
				
			rs.close();
			stmt.close();
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
		else
				throw new IllegalArgumentException("freak problem");
		
		return user;
	}


/*	public void updateUserInDB(User user) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
		
		if(!connectionfailed)
		{
			
			String sqlCmd  ="update cuser set password=?,email=? where userid  = ?";
		
			try {
				PreparedStatement stmt =con.prepareStatement(sqlCmd);
				stmt.setString(1, user.getPassword());
				stmt.setString(2, user.getEmail());
				stmt.setString(3, user.getUserid());
				
				int ra  = stmt.executeUpdate(); // it returns an int, but currrenetly we dont 
				//need to hold it becuase we are dealing with insert.
				stmt.close();
				if( ra > 0)
					System.out.println("everything is nearly working");
				else
						throw new IllegalArgumentException("another freak problem");
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
			
			
*/			
			
/*		}
		else
				throw new IllegalArgumentException("freak problem");
		
		
	
		
		
		
		
		
		
	}







/*public User findUserInDB(User user) throws IllegalArgumentException {
		// TODO Auto-generated method stub\
		User temp=getDetailsFromDB(user.getUserid());
		if(temp.getPassword().equals(user.getPassword()))
		{
			return temp;
		}
		return null;
	}


*/



	@Override
	public Account findAccount(Account user) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Account temp=getDetailsFromDB(user.getAccno());
		if(temp!=null && user.getPin()==temp.getPin())
			return temp;
		return null;
	}






	@Override
	public String withdraw(Account user, int amount) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		String bls="fp";
		if(!connectionfailed)
		{
		
		
		String sqlCmd  ="update account set balance=balance-? where accountno  = ?";
		try {
			PreparedStatement stmt =con.prepareStatement(sqlCmd);
			stmt.setInt(1,amount);	
			stmt.setInt(2, user.getAccno());
		
			
			int res = stmt.executeUpdate(); // it returns an int, but currrenetly we dont 
			//need to hold it because we are dealing with insert.
			if(res>0)
			{
				bls="su";	
			}
				
			stmt.close();
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
		else
				throw new IllegalArgumentException("freak problem");
		
		return bls;
	}






	@Override
	public String credit(Account user, int amount) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		String bls="fp";
		if(!connectionfailed)
		{
		
		
		String sqlCmd  ="update account set balance=balance+? where accountno  = ?";
		try {
			PreparedStatement stmt =con.prepareStatement(sqlCmd);
			stmt.setInt(1,amount);	
			stmt.setInt(2, user.getAccno());
		
			
			int res = stmt.executeUpdate(); // it returns an int, but currrenetly we dont 
			//need to hold it because we are dealing with insert.
			if(res>0)
			{
				bls="su";	
			}
				
			stmt.close();
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
		else
				throw new IllegalArgumentException("freak problem");
		
		return bls;
	}






	@Override
	public String changePin(Account user, int oldpin, int newpin) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		String bls="fp";
		if(!connectionfailed)
		{
		
		
		String sqlCmd  ="update account set pin=? where accountno  = ? and pin=?";
		try {
			PreparedStatement stmt =con.prepareStatement(sqlCmd);
			stmt.setInt(1,newpin);	
			stmt.setInt(2, user.getAccno());
			stmt.setInt(3,oldpin);	
			
			
			int res = stmt.executeUpdate(); // it returns an int, but currrenetly we dont 
			//need to hold it because we are dealing with insert.
			if(res>0)
			{
				bls="su";	
			}
			else
			{
				bls="wp";
			}
			stmt.close();
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
		else
				throw new IllegalArgumentException("freak problem");
		
		return bls;
	}






	@Override
	public int getBal(Account user) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Account temp=getDetailsFromDB(user.getAccno());
		
		return temp.getBal();
	}


}
