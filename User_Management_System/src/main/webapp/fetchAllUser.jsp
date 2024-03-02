<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="com.org.dao.UserDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="components/allcss.jsp" %>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@ include file="components/userNavbar.jsp" %>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 fw-bold text-center text-primary">User List</p>
						<table class="table">
							<thead>
								<tr>
									<th>Id</th>
									<th>Name</th>
									<th>Age</th>
									<th>Mobile</th>
									<th>Email</th>
									<th>Password</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								
									UserDao dao = new UserDao();
								List<User> list = dao.fetchAllUsers();
								for(User users : list){%>
								<tr>
									<td><%= users.getId() %></td>
									<td><%= users.getName() %></td>
									<td><%= users.getAge() %></td>
									<td><%= users.getMobile() %></td>
									<td><%= users.getEmail() %></td>
									<td><%= users.getPassword() %></td>
									<td> <a href="update_user.jsp?id=<%= users.getId() %>" class="btn btn-sm btn-primary">update</a> 
									     <a href="delete_user?id=<%= users.getId() %>"  class="btn btn-sm btn-danger">delete</a>
									</td>
									</tr>
								<% 
					
								}
								
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>