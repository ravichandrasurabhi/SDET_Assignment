package com.training.db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.beans.User;

public class UserDAO {

	public List<User> getUsers(){
		String sql ="select username, password from users"; 
		
		GetConnection gc = new GetConnection(); 
		List<User> users = new ArrayList<User>(); 
		
		try {
			gc.ps1 = GetConnection.getMySQLConnection().prepareStatement(sql);
			gc.rs = gc.ps1.executeQuery(); 
			
			while(gc.rs.next()) {
				User user = new User();
				user.setUserName(gc.rs.getString("username")); 
				user.setPassword(gc.rs.getString("password")); 
				
				users.add(user); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users; 
	}
	
	
}
