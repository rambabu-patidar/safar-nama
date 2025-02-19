package com.safar.servlet;

import java.io.IOException;

import com.safar.dao.CarDAO;
import com.safar.model.Car;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/car")
public class GetSingleCarServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String carId = req.getParameter("carId");
		
		Car car = CarDAO.fetchSingleCar(carId);
		
		if (car != null) {
			req.setAttribute("car", car);
			req.getRequestDispatcher("showSingleCar.jsp").forward(req, resp);
		} else {
			System.out.println("Couldn't found the car, try again.");
		}
		
	}
}
