<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Page</title>
</head>
<body>
	<h1> Payment page will be here</h1>
	
	<form action="payment" method="post">
	<h5> The Information here is not meant to save.</h5>
		<input type="hidden" value="<%=request.getParameter("carId")%>" name="carId"/>
		<input type="hidden" value="<%=request.getParameter("location")%>" name="location"/>
		<button type="submit">Pay</button>
	</form>
</body>
</html>