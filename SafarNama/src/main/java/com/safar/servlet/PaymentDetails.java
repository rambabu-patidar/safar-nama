package com.safar.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/paymentDetails")
public class PaymentDetails extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String carId = req.getParameter("carId");
//		
//		String location = req.getParameter("location");
		
		req.getRequestDispatcher("Payment.jsp").forward(req, resp);
	}
}
