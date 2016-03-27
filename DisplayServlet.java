package com.airysoft.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


public class DisplayServlet extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	
	
	
	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airysoft", "root", "password");
			
			PreparedStatement ps = connection.prepareStatement("Select username from users");
			
			
			ResultSet rs = ps.executeQuery();
			
			ArrayList<String> usernames=new ArrayList<>();
			
			while(rs.next()){
							
				usernames.add(rs.getString(1));
				
			}
				
			request.setAttribute("users",usernames); 
			
			connection.close();
			
			getServletContext().getRequestDispatcher("displayusers.jsp").forward(request,response);
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	
		
	
	
		
	}
	
	
		
		
}
