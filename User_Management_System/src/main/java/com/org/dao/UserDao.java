package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.org.dto.User;
//User Registration
public class UserDao {
		public void saveUser(User user) {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first_project","root","root");
				PreparedStatement pst = con.prepareStatement("insert into user(name,age,mobile,email,password) values(?,?,?,?,?)");
				
				pst.setString(1, user.getName());
				pst.setString(2, user.getAge());
				pst.setString(3, user.getMobile());
				pst.setString(4, user.getEmail());
				pst.setString(5, user.getPassword());
				
				pst.executeUpdate();
				pst.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
//User Login
		public ResultSet loginUser(User user) {
			ResultSet rst = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first_project","root","root");
				PreparedStatement pst = con.prepareStatement("select * from user where email=?");
				pst.setString(1, user.getEmail());
				
			 rst = pst.executeQuery();
				
			 	
				
				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rst;
			
			
		}
		
//Fetch Users
			
		
		public List<User> fetchAllUsers(){
			List<User> list = new ArrayList<>();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first_project","root","root");
				PreparedStatement pst = con.prepareStatement("select * from user ");
				
				ResultSet rst = pst.executeQuery();
				while(rst.next()) {
					int id = rst.getInt("id");
					String name = rst.getString("name");
					String age = rst.getString("age");
					String mobile = rst.getString("mobile");
					String email = rst.getString("email");
					String password = rst.getString("password");
					
					User user = new User();
					
					user.setName(name);
					user.setAge(age);
					user.setMobile(mobile);
					user.setEmail(email);
					user.setPassword(password);
					user.setId(id);
					list.add(user);
					
					
					
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
		}
		
		
		
//fetch users by id
		
		
		public User fetchUserById(int id) {
			User user = null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first_project","root","root");
				PreparedStatement pst = con.prepareStatement("select * from user where id=?");
				pst.setInt(1, id);
				ResultSet rst = pst.executeQuery();
				if(rst.next()) {
					int id1 = rst.getInt("id");
					String name = rst.getString("name");
					String age = rst.getString("age");
					String mobile = rst.getString("mobile");
					String email = rst.getString("email");
					String password = rst.getString("password");
					
					 user = new User();
					
					user.setName(name);
					user.setAge(age);
					user.setMobile(mobile);
					user.setEmail(email);
					user.setPassword(password);
					user.setId(id1);
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return user;
			
		}
//Update Users By Id
		
		public boolean updateUser(int id,User user) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first_project","root","root");
				PreparedStatement pst = con.prepareStatement("update user set name=?,age=?,mobile=?,email=?,password=? where id=?");
				pst.setString(1, user.getName());
				pst.setString(2, user.getAge());
				pst.setString(3, user.getMobile());
				pst.setString(4, user.getEmail());
				pst.setString(5, user.getPassword());
				pst.setInt(6, id);
				
				int b = pst.executeUpdate();
				if(b==1)
					return true;
				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
//Delete user by id
		
		
		public void deleteUserById(int id) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first_project","root","root");
				PreparedStatement pst = con.prepareStatement("delete from user where id=?");
				
				pst.setInt(1, id);
				pst.executeUpdate();
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		}
		
		
}
