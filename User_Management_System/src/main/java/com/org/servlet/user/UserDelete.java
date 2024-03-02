package com.org.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.UserDao;
@WebServlet("/delete_user")
public class UserDelete extends HttpServlet{
			
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String strId = req.getParameter("id");
			int id = Integer.parseInt(strId);
			
			UserDao dao = new UserDao();
			dao.deleteUserById(id);
			
			resp.sendRedirect("fetchAllUser.jsp");
		}
}
