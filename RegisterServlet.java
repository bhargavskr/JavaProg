package com.airysoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airysoft.jdbc.RegisterHelper;

public class RegisterServlet extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	
	
		String username = request.getParameter("uname");
		String password = request.getParameter("pwd");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		if(RegisterHelper.isValidRegistration(username, password,fname,lname)){
		out.println("<h2>Sorry you are already registered <h2><br/>");
         out.println("<a href= \"registration.html\" >press to retry</a><br/>");
		
		}
		else
		{
		
		out.println("<h2>  Registration Successful <h2><br/>");
		out.println("<h2> You entered Username as : "+username+" and Password as : "+password+" firstname as : "+fname+" and lastname as : "+lname+"<h2><br/>");
		
		}
		out.println("</body>");
		out.println("</html>");
		
		
	}
	
	
		
		
}

