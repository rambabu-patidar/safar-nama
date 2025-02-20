package com.safar.servlet;

import java.io.File;
import java.io.IOException;

import com.safar.dao.CarDAO;
import com.safar.model.Car;
import com.safar.utils.GetDirectory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteCar")
public class DeleteCarServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String carId = req.getParameter("carId");
		
		// does the car exits with this id.
		Car carToDelete = CarDAO.fetchSingleCar(carId);
		
		if (carToDelete != null) {
			// delete the car 
			// also delete the image related to it.
			File imageFile = new File(GetDirectory.getImageDir() + carToDelete.getPhotoURL());
			
			if (imageFile.exists()) {
	            if (imageFile.delete()) {
	                System.out.println("Image deleted successfully.");
	            } else {
	                System.out.println("Failed to delete the image.");
	            }
	        } else {
	            resp.getWriter().write("Image not found.");
	        }
			
			int result = CarDAO.deleteCar(carId);
			if (result > 0) {
				System.out.println("Car Deleted Successfully!");
				resp.sendRedirect("cars");
			} else {
				System.out.println("Can't be deleted, try again");
			}
		} else {
			System.out.println("car with given id doesn't exist");
		}
	}
}
