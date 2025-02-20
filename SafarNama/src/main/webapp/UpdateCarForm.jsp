<%@page import="com.safar.model.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update your car.</title>
</head>
<body>

<h1> Hello Update your car here.</h1>

<% Car car = (Car)request.getAttribute("car"); %>
 
<form action="updateCar" method="post" enctype="multipart/form-data">
	<input type="hidden" name="carId" value="<%=car.getId()%>"/>
	<label for="regNumber"> Reg Number</label>
	<input type="text" name="regNumber" value="<%=car.getRegNumber()%>"/>
	<br/>

	<label for="name">Name and model</label>
	<input type="text" name="nameAndModel" value="<%=car.getNameAndModel()%>"/>
	<br/>
	
	<label for="transType">Transmission Type</label>
	<input type="text" name="transType" value="<%=car.getTransType()%>"/>
	<br/>
	<label for="YearForManufacture">Year of Manufacture</label>
	<input type="number" name="yearOfManufacture" value="<%=car.getYearofManufacture()%>"/>
	<br/>
	<label for="rentalPrice">Rental Price</label>
	<input type="number" name="rentalPrice" value="<%=car.getRentalPrice()%>"/>
	<br/>
	<label for="mileage">mileage</label>
	<input type="number" name="mileage" value="<%=car.getMileage()%>"/>
	<br/>
	<label for="sittingCapacity">Sitting Capacity</label>
	<input type="number" name="sittingCapacity" value="<%=car.getSittingCapacity()%>"/>
	<br/>
	<label for="photoURL">Image URL</label>
	<input type="file" name="photoURL" accept="image/*" value="Upload Car Image" />
	<input type="hidden" name="previousPhotoURL" value="<%=car.getPhotoURL()%>"/>
	<br/>
	<input type="submit" value="Submit"/>
	<br/>
</form>

</body>
</html>