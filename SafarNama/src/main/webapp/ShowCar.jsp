<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.safar.model.Car"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Car List</title>
</head>
<body>
	<h1>Car Information</h1>
	
	<% 
    ArrayList<Car> cars = (ArrayList<Car>) request.getAttribute("cars"); 
    if (cars != null) { 
%>
    <% for (Car car : cars) { %>
        <%= car.getRegNumber() %> <br>
        <%= car.getNameAndModel() %> <br>
        <% out.println(car.getPhotoURL()); %>
        <br>
        <img src="<%=car.getPhotoURL()%>" alt="This is a car image." width="50px"/>
        <br><br>
        <hr>
    <% } %>
<% 
    } else { 
%>
    <p>No cars available.</p>
<% 
    } 
%>
	
	
</body>
</html>