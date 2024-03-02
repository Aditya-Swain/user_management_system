package com.org.servlet.user;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.User;
@WebServlet("/userlogin")
public class LoginUser extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			
			UserDao dao = new UserDao();
			ResultSet rst = dao.loginUser(user);
			HttpSession session = req.getSession();
			try {
				if(rst.next()) {
					String dbpwd = rst.getString("password");
					if(dbpwd.equals(user.getPassword())) {
						String name = rst.getString("name");
						session.setAttribute("name", name);
						resp.sendRedirect("Home.jsp");
					}
					else {
						session.setAttribute("invalid", "Invalid Password");
						resp.sendRedirect("userLogin.jsp");
					}
						
				}
				else {
					session.setAttribute("invalid", "Invalid Email Id");
					resp.sendRedirect("userLogin.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
}	
