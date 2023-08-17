package servlet;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WelcomeServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		try {
			PrintWriter pw =res.getWriter();
			HttpSession ses = req.getSession();
			
			
			String userId = ses.getAttribute("user").toString();
			String password = (String)ses.getAttribute("password");
			res.setContentType("text/html");
			pw.append("Welcome : "+ userId);
			pw.append("<br>Password = "+ password);
			
			
			
			pw.append("<br><br>");
			
			pw.append("<form action ='confirm' method='GET'>");
			pw.append("<input type='submit' value='Go to confirm servlet'>");
				
			pw.append("</form>");
			
			
			
			
			
		}catch(Exception  e) {
			e.printStackTrace();
		}
	}

}
