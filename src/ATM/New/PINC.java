package ATM.New;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PINC {

	public String change(HttpServletRequest request) {
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
		int oldpin = Integer.parseInt(request.getParameter("oldpin")); 
		int newpin = Integer.parseInt(request.getParameter("newpin")); 
		bls = s.changePin(user,oldpin,newpin);
	

		return bls;
	}

}
