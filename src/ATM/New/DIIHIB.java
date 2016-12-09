package ATM.New;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class DIIHIB implements DI {

	SessionFactory sessions;
			
	public DIIHIB() {
		// TODO Auto-generated constructor stub
		sessions = new Configuration()
		.configure()
		.buildSessionFactory();
	}
	
	@Override
	public Account findAccount(Account user) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Session ses = sessions.openSession();
		Account temp=null,res=null;
		Transaction t = ses.beginTransaction();
		Object o = ses.get(Account.class, user.getAccno()); 
		if( o != null)
		{
				temp  =(Account) o;  //got a persistent object.
				if(temp.getPin()==user.getPin())
				{
					res=temp;
				}	
		}
		ses.close();
		sessions.close();
		return res;
	
	}

	@Override
	public String withdraw(Account user, int amount) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		String bls="fp";
		Session ses = sessions.openSession();
		System.out.println("ok");
		Account temp=null;
		Transaction t = ses.beginTransaction();
		Object o = ses.get(Account.class, user.getAccno()); 
		if( o != null)
		{
				temp  =(Account) o;  //got a persistent object.
				temp.setBal(temp.getBal()-amount);
				t.commit();
				bls="su";
		}
		ses.close();
		sessions.close();
		return bls;
	}

	@Override
	public String credit(Account user, int amount) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		String bls="fp";
		Session ses = sessions.openSession();
		Account temp=null;
		Transaction t = ses.beginTransaction();
		Object o = ses.get(Account.class, user.getAccno()); 
		if( o != null)
		{
				temp  =(Account) o;  //got a persistent object.
				temp.setBal(temp.getBal()+amount);
				t.commit();
				bls="su";
		}
		ses.close();
		sessions.close();
		return bls;
	}

	@Override
	public String changePin(Account user, int oldpin, int newpin) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		String bls="fp";
		Session ses = sessions.openSession();
		Account temp=null;
		Transaction t = ses.beginTransaction();
		Object o = ses.get(Account.class, user.getAccno());
		if( o != null)
		{
				temp  =(Account) o;  //got a persistent object.
				if(temp.getPin()==oldpin)
				{
					temp.setPin(newpin);
					t.commit();
					bls="su";
				}
				else
				{
					bls="wnis";
				}
		}
		ses.close();
		sessions.close();
		return bls;
	}

	@Override
	public int getBal(Account user) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Session ses = sessions.openSession();
		Account temp=null;
		Transaction t = ses.beginTransaction();
		Object o = ses.get(Account.class, user.getAccno()); 
		if( o != null)
		{
				temp  =(Account) o;  //got a persistent object.
				temp.getBal();
				t.commit();
		}
		ses.close();
		sessions.close();
		
		return 0;
	}

}
