<%@page import="com.org.dto.User"%>
<%@page import="com.org.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>  
<%@ include file="components/allcss.jsp" %>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>	
</head>
<body>
	<!-- Update User By Id -->
	<%String strId = request.getParameter("id");
		int id =  Integer.parseInt(strId);
		UserDao dao = new UserDao();
		User user2 =  dao.fetchUserById(id);
	
	%>
	<%@ include file="components/userNavbar.jsp"%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="car paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Update User Details</p>
						<form action="userUpdate" method="post">
							<div class="mb-3">
								<label class="form-label">Name</label> <input name="name"
									type="text" value="<%=user2.getName() %>" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Age</label> <input name="age"
									type="text" value="<%= user2.getAge() %>" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">mobile</label> <input name="mobile"
									type="text" value="<%=user2.getMobile() %>" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" value="<%= user2.getEmail()%>"class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" type="text" value="<%= user2.getPassword() %>" class="form-control" required>
							</div>
							<input type="hidden" name="id" value="<%=user2.getId()%>" >	
							<button type="submit" class="btn bg-success text-white col-md-12">Update Details</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>