package com.safar.servlet;

import java.io.IOException;

import com.safar.dao.CarDAO;
import com.safar.model.Car;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bookCar")
public class BookCar extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String carId = req.getParameter("carId");
		
		Car car = CarDAO.fetchSingleCar(carId);
		
		if (car != null) {
			req.setAttribute("car",  car);
			req.getRequestDispatcher("BookingDetail.jsp").forward(req, resp);
		} else {
			System.out.println("The car you want to book doesn't exist!");
			resp.sendRedirect("cars");
		}
	}
}
