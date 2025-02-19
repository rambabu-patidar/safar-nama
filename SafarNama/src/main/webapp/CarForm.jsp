<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add your car.</title>
</head>
<body>

<h1> Hello create a car here.</h1>
 
<form action="cars" method="post" enctype="multipart/form-data">
	<label for="regNumber"> Reg Number</label>
	<input type="text" name="regNumber" value="ere123"/>
	<br/>

	<label for="name">Name and model</label>
	<input type="text" name="nameAndModel" value="Rambabu"/>
	<br/>
	
	<label for="transType">Transmission Type</label>
	<input type="text" name="transType" value="ev"/>
	<br/>
	<label for="YearForManufacture">Year of Manufacture</label>
	<input type="number" name="yearOfManufacture" value="2025"/>
	<br/>
	<label for="rentalPrice">Rental Price</label>
	<input type="number" name="rentalPrice" value="232323"/>
	<br/>
	<label for="mileage">mileage</label>
	<input type="number" name="mileage" value="12"/>
	<br/>
	<label for="sittingCapacity">Sitting Capacity</label>
	<input type="number" name="sittingCapacity" value="1"/>
	<br/>
	<label for="photoURL">Image URL</label>
	<input type="file" name="photoURL" accept="image/*" value="Upload Car Image"/>
	<br/>
	<input type="submit" value="Submit"/>
	<br/>
</form>

</body>
</html>