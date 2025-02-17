package com.safar.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import com.safar.dao.CarDAO;
import com.safar.model.Car;
import com.safar.utils.GenerateRandomId;
import com.safar.utils.GetDirectory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


@WebServlet("/cars")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class CarServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// find all the cars
		ArrayList<Car> cars = CarDAO.fetchCars();
		System.out.println(cars.size());
		req.setAttribute("cars", cars);
		req.getRequestDispatcher("ShowCar.jsp").forward(req,  resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = GenerateRandomId.generateRandomString();
		String regNumber = req.getParameter("regNumber");
		String nameAndModel = req.getParameter("nameAndModel");
		String transType = req.getParameter("transType");
		int yearofManufacture = Integer.parseInt(req.getParameter("yearOfManufacture"));
		double rentalPrice = Double.parseDouble(req.getParameter("rentalPrice"));
		double mileage = Double.parseDouble(req.getParameter("mileage"));
		int sittingCapacity = Integer.parseInt(req.getParameter("sittingCapacity"));
		
		//Handle image sent by user
		Part filePart = req.getPart("photoURL");
		String fileName = GenerateRandomId.generateRandomString().substring(0, 7) + ".jpg";
		
		String uploadPath = GetDirectory.getImageDir() + fileName;
		
		try {
			
			FileOutputStream fos = new FileOutputStream(uploadPath);
			
			InputStream is = filePart.getInputStream();
			
			byte[] data = new byte[is.available()];
			
			is.read(data);
			fos.write(data);
			fos.close();
			is.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(fileName);
		
		Car car = new Car(id, regNumber, nameAndModel, transType, yearofManufacture,
				rentalPrice, mileage, sittingCapacity, fileName);
		
		int result = CarDAO.addCar(car);
		
		if (result > 0) {
			System.out.println("Car added successfully");
			resp.sendRedirect("cars");
		} else {
			System.out.println("Couldn't add car.");
		}
		
	}
}
