<%@page import="com.safar.utils.GetDirectory"%>
<%@page import="com.safar.model.Car"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car detail</title>
</head>
<body>

	<% Car car = (Car)request.getAttribute("car"); %>
	<%= car.getRegNumber() %> <br>
	<%= car.getNameAndModel() %> <br>
	<% out.println(GetDirectory.getImageDir() + car.getPhotoURL()); %>
	<br>
	<img src="<%=GetDirectory.getImageDir()%><%=car.getPhotoURL()%>" alt="This is a car image." width="200px"/>
	<br><br>
	<hr>
	<a href="cars">Show all cars</a>
	<form action="updateCar" action="get">
		<input type="hidden" value="<%= car.getId()%>" name="carId"/>
		<button type="submit">Update Car</button>
	</form>
	
	<form action="deleteCar" method="post">
        	<input type="hidden" name="carId" value="<%=car.getId()%>"/>
        	<button type="submit">Delete Car</button>
        </form>
</body>
</html>