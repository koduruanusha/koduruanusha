package ATM.New;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BT {

	public String validateUser(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String bls="wnis";
		HttpSession ses = request.getSession();
		Object o = ses.getAttribute("k1");
		if(o!=null)
		{
			bls="ok";
		}
		return bls;
	}

}
