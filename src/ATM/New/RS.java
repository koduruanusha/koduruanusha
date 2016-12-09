package ATM.New;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RS
 */
@WebServlet("/cs")
public class RS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pagename="/WEB-INF/ins.html";
		
		//fp  iat  ok
		
		String purpose = request.getParameter("purpose");
		if(purpose.equals("login"))
		{
			Lg x =new Lg();
			String bls = x.loginUser(request);
			if(bls.equals("fp"))
			{
				pagename="/WEB-INF/sysbusy.html";
				
			}
			else  if(bls.equals("waop"))
			{
				pagename="/login.jsp";
				
			}
			else  if(bls.equals("ok"))
			{
				pagename="/WEB-INF/pl.jsp";
				
			}
			
			
		}
		else if(purpose.equals("signoff"))
		{
			
			System.out.println("we need  to logoff");
			LBL x =new LBL();
			// wnis, los
			String bls  =x.signoff(request);
			if(bls.equals("wnis"))
			{
				pagename="/login.jsp";
				
			}
			else  if(bls.equals("los"))
			{
				pagename="/WEB-INF/so.html";
				
			}
			
		
		}
		else if(purpose.equals("withdraw"))
		{
			
			BT x =new BT();
			// wnis, ok
			String bls  =x.validateUser(request);
			if(bls.equals("wnis"))
			{
				pagename="/login.jsp";
				
			}
			else  if(bls.equals("ok"))
			{
				pagename="/WEB-INF/Withdraw.jsp";
				
			}
			
		
		}
		else if(purpose.equals("credit"))
		{
			BT x= new BT();
			// wnis, ok, fp
			String bls  =x.validateUser(request);
			if(bls.equals("wnis"))
			{
				pagename="/login.jsp";
				
			}
			else  if(bls.equals("ok"))
			{
				pagename="/WEB-INF/credit.jsp";
				
			}
			
		
		}
		else if(purpose.equals("changePin"))
		{
			
			BT x =new BT();
			// wnis, ok, fp
			String bls  =x.validateUser(request);
			if(bls.equals("wnis"))
			{
				pagename="/login.jsp";
				
			}
			else  if(bls.equals("ok"))
			{
				pagename="/WEB-INF/ChangePIN.jsp";
				
			}
		}
		else if(purpose.equals("bal"))
		{
			
			BT x =new BT();
			// wnis, ok, fp
			String bls  =x.validateUser(request);
			if(bls.equals("wnis"))
			{
				pagename="/login.jsp";
				
			}
			else  if(bls.equals("ok"))
			{
				BAL b =new BAL();
				bls=b.getBal(request);
				if(bls.equals("su"))
				{
					pagename="/WEB-INF/balance.jsp";
							
				}
				else  if(bls.equals("fp"))
				{
					pagename="/WEB-INF/sysbusy.html";
					
				}
				
			
			}
		}
		else if(purpose.equals("aw"))
		{
			String bls ="fp";
			WDR x =new WDR();
			bls = x.withdraw(request);
			if(bls.equals("su"))
			{
				pagename="/WEB-INF/pl.jsp";
				
			}
			else  if(bls.equals("fp"))
			{
				pagename="/WEB-INF/sysbusy.html";
				
			}
			else  if(bls.equals("wnis"))
			{
				pagename="/login.jsp";
				
			}
			
		}
		else if(purpose.equals("ac"))
		{
			String bls ="fp";
			CDR x =new CDR();
			bls = x.credit(request);
			if(bls.equals("su"))
			{
				pagename="/WEB-INF/pl.jsp";
				
			}
			else  if(bls.equals("fp"))
			{
				pagename="/WEB-INF/sysbusy.html";
				
			}
			else  if(bls.equals("wnis"))
			{
				pagename="/login.jsp";
				
			}
			
		}
		else if(purpose.equals("acp"))
		{
			String bls ="fp";
			PINC x =new PINC();
			bls = x.change(request);
			if(bls.equals("su"))
			{
				pagename="/WEB-INF/pl.jsp";
				
			}
			else  if(bls.equals("fp"))
			{
				pagename="/WEB-INF/sysbusy.html";
				
			}
			else  if(bls.equals("wnis"))
			{
				pagename="/login.jsp";
				
			}
			else  if(bls.equals("wp"))
			{
				pagename="/WEB-INF/ChangePIN.jsp";
				
			}
		}
		else if(purpose.equals("ab"))
		{
			BT x =new BT();
			String bls  =x.validateUser(request);
			if(bls.equals("wnis"))
			{
				pagename="/login.jsp";
				
			}
			else  if(bls.equals("ok"))
			{
				pagename="/WEB-INF/credit.jsp";
				
			}
		
			
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(pagename);
		rd.forward(request, response);
		
		
	}
}
