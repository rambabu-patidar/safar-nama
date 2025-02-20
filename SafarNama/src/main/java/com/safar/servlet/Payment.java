package com.safar.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/payment")
public class Payment extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String carId = req.getParameter("carId");
		String location = req.getParameter("location");
		
		System.out.println(carId);
		System.out.println(location);
		
		resp.sendRedirect("showBooking.jsp");
	}
}
