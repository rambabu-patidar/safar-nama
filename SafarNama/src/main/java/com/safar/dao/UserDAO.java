package com.safar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.safar.config.DBConnection;
import com.safar.model.User;
import com.safar.utils.GenerateRandomId;

public class UserDAO {
	
	public static ArrayList<User> getAllUser() {
		
		ArrayList<User> users = new ArrayList<>();
		String query = "select * from users";
		
		try {
			Connection conn = DBConnection.getConnection();
			
			Statement pst = conn.createStatement();
			
			ResultSet usersSet = pst.executeQuery(query);
			
			while (usersSet.next()) {
				System.out.println(usersSet.getString(2));
				
				
//				users.add(usersSet);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	public static User addUser(User user) {
		
		User createdUser = null;
		String query = "insert into users values(?, ?, ?, ?, ?, ?);";
		
		try {
			Connection conn = DBConnection.getConnection();
			
			PreparedStatement pst = conn.prepareStatement(query);
			
			pst.setString(1, GenerateRandomId.generateRandomString());
			pst.setString(2, user.getName());
			pst.setString(3, user.getEmail());
			pst.setDate(4, user.getDob());
			pst.setString(5, user.getAddress());
			pst.setString(6,  user.getDrivingLicense());
			
			if(pst.executeUpdate()>0) {
				System.out.println("Details Entered Successfully........!");
			}
			else {
				System.out.println("Something Went Wrong...........!");
			}
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return createdUser;
	}
}
