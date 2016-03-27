package com.airysoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class RegisterHelper {
	
	
	public static boolean isValidRegistration(String username,String password, String fname,String lname){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airysoft", "root", "password");
			
			PreparedStatement ps = connection.prepareStatement("Select * from users where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
							
				
				return true;
			}
				
			
			Statement st2=connection.createStatement();    
     	
			String str2="insert into users values('"+username+"','"+password+"','"+fname+"','"+lname+"')";
	
			st2.executeUpdate(str2); 
		
			
			
			connection.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		return false;
	}

	
	
	
}