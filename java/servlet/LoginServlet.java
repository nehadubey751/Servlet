package servlet;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DbConnection;

public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			DbConnection db = new DbConnection();			
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html");

			String userId = request.getParameter("user");
			String password = request.getParameter("password");

			boolean isUserPresent = db.validateUser(userId, password);

			if (isUserPresent) {
				// go to next servlet
				
				HttpSession session = request.getSession();
				session.setAttribute("user", userId);
				session.setAttribute("password", password);
				
				RequestDispatcher rd = request.getRequestDispatcher("welcome");
				rd.forward(request, response);

			} else {
				pw.append("Invalid userId or Password !");
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
