package ATM.New;

import org.omg.CORBA.portable.UnknownException;

public class SIIR implements SI {

	@Override
	public String loginUser(Account user) {
		// TODO Auto-generated method stub
		String bls="fp";
		DI x = new DIIDB();
		try {
			Account temp=x.findAccount(user);
			if(temp==null)
			{
				bls="waop";
			}
			else
				bls="ok";
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
		
			//	e.printStackTrace();
		
		}
		return bls;
	}

	@Override
	public String withdraw(Account user, int amount) {
		// TODO Auto-generated method stub
		String bls="fp";
		DI x = new DIIHIB();
		try {
			bls=x.withdraw(user,amount);
			} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
		
				e.printStackTrace();
		
		}
		return bls;
	}

	@Override
	public String credit(Account user, int amount) {
		// TODO Auto-generated method stub
		String bls="fp";
		DI x = new DIIHIB();
		try {
			bls=x.credit(user,amount);
			} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
		
				e.printStackTrace();
		
		}
		return bls;
	}

	@Override
	public String changePin(Account user, int oldpin, int newpin) {
		// TODO Auto-generated method stub
		String bls="fp";
		DI x = new DIIHIB();
		try {
			bls=x.changePin(user,oldpin,newpin);
			} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
		
				e.printStackTrace();
		
		}
		return bls;
	}

	@Override
	public int getBal(Account user) throws IllegalArgumentException {
		// TODO Auto-generated method stubString bls="fp";
		int temp;
		DI x = new DIIHIB();
		temp=x.getBal(user);
		return temp;
	}

}
