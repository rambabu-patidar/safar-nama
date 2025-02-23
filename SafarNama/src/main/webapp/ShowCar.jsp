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

	<a href="CarForm.jsp">Add another Car</a>
	<% 
    ArrayList<Car> cars = (ArrayList<Car>) request.getAttribute("cars"); 
    if (cars.size() != 0) { 
%>
	<% for (Car car : cars) { %>
	<%= car.getRegNumber() %>
	<br>
	<%= car.getNameAndModel() %>
	<br>
	<% out.println(GetDirectory.getImageDir() + car.getPhotoURL()); %>
	<br>
	<img src="<%=GetDirectory.getImageDir()%><%=car.getPhotoURL()%>"
		alt="This is a car image." width="50px" />
	<br>
	<br>
	<form action="car" method="get">
		<input type="hidden" name="carId" value="<%=car.getId()%>" />
		<button type="submit">View Car Details</button>
	</form>
	<form action="deleteCar" method="post">
		<input type="hidden" name="carId" value="<%=car.getId()%>" />
		<button type="submit">Delete Car</button>
	</form>
	<form action="bookCar" method="post">
		<input type="hidden" name="carId" value="<%=car.getId()%>" />
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



	<!-- pagination Logic  -->
	<%int currentPage = (Integer)request.getAttribute("currentPage");
	int previousPage = (Integer) request.getAttribute("previousPage");
	boolean hasPrevPage = (Boolean) request.getAttribute("hasPrevPage");
	boolean hasNextPage = (Boolean) request.getAttribute("hasNextPage");
	int nextPage = (Integer) request.getAttribute("nextPage");
	int lastPage = (Integer) request.getAttribute("lastPage");
	
	%>
	<section class="pagination">
		<% if ((currentPage != 1) && (previousPage != 1)) {%>
		
		<a href="cars?page=1" style="text-decoration:none;border: 1px solid black;margin:2rem;">First(1)</a>
		<% } %>

		<% if(hasPrevPage){ %>
		<a href="cars?page=<%=previousPage%>"  style="text-decoration:none;border: 1px solid black;margin:2rem;">Prev(<%= previousPage%>)
		</a>
		<% }%>

		<a href="cars?page=<%=currentPage%>" class="active"  style="text-decoration:none;border: 1px solid black;margin:2rem;"> <%= currentPage%>
		</a>

		<% if (hasNextPage) {%>
		<a href="cars?page=<%=nextPage%>"  style="text-decoration:none;border: 1px solid black;margin:2rem;">Next(<%= nextPage%>)
		</a>
		<% }%>

		<% if ((lastPage != currentPage) && (nextPage != lastPage)) {%>
		<a href="cars?page=<%=lastPage%>"  style="text-decoration:none;border: 1px solid black;margin:2rem;">Last(<%= lastPage%>)
		</a>
		<% }%>
	</section>


</body>
</html>