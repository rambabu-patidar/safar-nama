<%@page import="com.safar.utils.GetDirectory"%>
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
    if (!cars.isEmpty()) { 
%>
    <% for (Car car : cars) { %>
        <%= car.getRegNumber() %> <br>
        <%= car.getNameAndModel() %> <br>
        <% out.println(GetDirectory.getImageDir() + car.getPhotoURL()); %>
        <br>
        <img src="<%=GetDirectory.getImageDir()%><%=car.getPhotoURL()%>" alt="This is a car image." width="50px"/>
        <br><br>
        <form action="car" method="get">
        	<input type="hidden" name="carId" value="<%=car.getId()%>"/>
        	<button type="submit" >View Car Details</button>
        </form>
        <form action="deleteCar" method="post">
        	<input type="hidden" name="carId" value="<%=car.getId()%>"/>
        	<button type="submit">Delete Car</button>
        </form>
        <form action="bookCar" method="post">
        <input type="hidden" name="carId" value="<%=car.getId()%>"/>
        	<button type="submit">Book Car</button>
        </form>
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