package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet3 extends HttpServlet{

	protected void doGet(HttpServletRequest req,HttpServletResponse res) {
		PrintWriter pw;
		try {
			pw = res.getWriter();
		
			
			String userFromRequest=req.getParameter("user");
			String passwordFromRequest=req.getParameter("password");
			
			pw.append("userId and password form request object<br>");
			pw.append("userFromRequest : "+userFromRequest);
			pw.append("passwordFromRequest : "+passwordFromRequest);
			
			
			HttpSession session= req.getSession();
			
			String userFromSession = (String)session.getAttribute("user");
			String passwordFromSession = (String)session.getAttribute("password");
			
			pw.append("userId and password form session object<br>");
			pw.append("  userFromSession : "+userFromSession);
			pw.append("  passwordFromSession : "+passwordFromSession);
			
			//to invalidate session
			session.invalidate();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
