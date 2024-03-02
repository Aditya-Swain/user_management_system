<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="components/allcss.jsp" %>
</head>

<body>
<%@ include file="components/navbar.jsp" %>
<div id="carouselExampleInterval" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active" data-bs-interval="3000">
				<img src="img/management1.jpg" class="d-block w-100" alt="..." height="550px">
			</div>
			<div class="carousel-item" data-bs-interval="2000">
				<img src="img/management2.jpg" class="d-block w-100" alt="..." height="550px">
			</div>
			<div class="carousel-item">
				<img src="img/management3.jpg" class="d-block w-100" alt="..." height="550px">
			</div>
		</div>
		
	</div>
</body>
</html>