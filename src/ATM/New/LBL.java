package ATM.New;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LBL {

	public String signoff(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String bls ="wnis";
		HttpSession sesssion = request.getSession();
		Object o = sesssion.getAttribute("k1"	);
		if( o != null)
		{
				sesssion.removeAttribute("k1");
				bls="los";
			
		}
		return bls;
	}

}
