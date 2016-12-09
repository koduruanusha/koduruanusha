package ATM.New;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.portable.UnknownException;

public class BAL {

	public String getBal(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String bls="fp";
		HttpSession ses = request.getSession();
		Object o = ses.getAttribute("k1");
		if(o==null)
		{
			bls="wnis";
			return bls;
		}
		int accno = (int) o;
		Account user =new Account(accno);
		SI s =new SIIR();
		
		int x;
		try {
			x = s.getBal(user);
			ses.setAttribute("k2", x);
			bls="su";
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bls;
	}

}
