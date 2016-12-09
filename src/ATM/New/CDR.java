package ATM.New;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CDR {

	public String credit(HttpServletRequest request) {
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
		int amount = Integer.parseInt(request.getParameter("amount")); 
		bls = s.credit(user,amount);
	

		return bls;
	}
}
