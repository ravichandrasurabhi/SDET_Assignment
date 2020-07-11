package com.training.db;

import java.util.List;

import com.training.beans.User;

public class DBClient {
	public static void main(String[] args) {
		UserDAO userDao = new UserDAO(); 
		
		// cmd/ctrl + 2 + l 
		List<User> users = userDao.getUsers(); 
		
		for(User temp : users) {
			System.out.println(temp);
		}
	}
}
