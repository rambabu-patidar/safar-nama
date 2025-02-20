<%@page import="com.safar.utils.GetDirectory"%>
<%@page import="com.safar.model.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Detail Page</title>
</head>
<body>
	
	<% Car car = (Car)request.getAttribute("car");%>
	
	<%= car.getRegNumber() %> <br>
	<%= car.getId() %> <br>
	<%= car.getNameAndModel() %> <br>
	<% out.println(GetDirectory.getImageDir() + car.getPhotoURL()); %>
	<br>
	<img src="<%=GetDirectory.getImageDir()%><%=car.getPhotoURL()%>" alt="This is a car image." width="200px"/>
	<br><br>
	<hr>
	<a href="cars">Show all cars</a>
	
	<form action="paymentDetails" method="post">
		<label for="location">Location</label>
		<input type="text" value="Pune" name="location" />
		<input type="hidden" value="<%=car.getId()%>" name="carId"/>
		<input type="submit" value="Save Booking" />
	</form>
</body>
</html>