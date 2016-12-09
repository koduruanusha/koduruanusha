package ATM.New;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class Lg {

	public String loginUser(HttpServletRequest request) {
		// TODO Auto-generated method stub	// TODO Auto-generated method stub
		String bls="fp";
		int accno = Integer.parseInt(request.getParameter("accno"));
		int pin = Integer.parseInt(request.getParameter("pin"));
		Account user =new Account(accno,pin);
		System.out.println(user.getAccno() + " " +user.getPin());
		SI s =new SIIR();
		
		 bls = s.loginUser(user);
	
		/*int x = (int) (Math.random()*30);
		if(x>10)
			bls="ok";
		else if (x>5)
			bls="waop";*/
		
			if( bls.equals("ok"))
			{
				
						HttpSession ses = request.getSession();
						ses.setAttribute("k1",accno);
			
						
						
			}
			else if(bls.equals("waop"))
			{
				
						request.setAttribute("k1", "Wrong username or password");
						
		
			}
		return bls;
	}

}
