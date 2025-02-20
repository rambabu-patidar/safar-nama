package com.safar.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.safar.dao.CarDAO;
import com.safar.model.Car;
import com.safar.utils.GenerateRandomId;
import com.safar.utils.GetDirectory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/updateCar")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class UpdateCarServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String carId = req.getParameter("carId");

		Car car = CarDAO.fetchSingleCar(carId);

		if (car != null) {
			req.setAttribute("car", car);
			req.getRequestDispatcher("UpdateCarForm.jsp").forward(req, resp);
		} else {
			System.out.println("Car can't be found with this ID");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String carId = req.getParameter("carId");
		String regNumber = req.getParameter("regNumber");
		String nameAndModel = req.getParameter("nameAndModel");
		String transType = req.getParameter("transType");
		int yearofManufacture = Integer.parseInt(req.getParameter("yearOfManufacture"));
		double rentalPrice = Double.parseDouble(req.getParameter("rentalPrice"));
		double mileage = Double.parseDouble(req.getParameter("mileage"));
		int sittingCapacity = Integer.parseInt(req.getParameter("sittingCapacity"));

		// check if the user has uploaded the car image or not if yes then change the Id
		// and save it
		// otherwise keep the previous one.
		Part filePart = req.getPart("photoURL");

		// if no image then take the previous id only

		String fileName = null;
		if (filePart.getSubmittedFileName().length() == 0) {
			fileName = req.getParameter("previousPhotoURL");
		} else {
			// you can delete the previous image here if you want.
			String previousPhotoURL = req.getParameter("previousPhotoURL");
			File imageFile = new File(GetDirectory.getImageDir() + previousPhotoURL);

			if (imageFile.exists()) {
				if (imageFile.delete()) {
					System.out.println("Image deleted successfully.");
				} else {
					System.out.println("Failed to delete the image.");
				}
			} else {
				resp.getWriter().write("Image not found.");
			}

			fileName = GenerateRandomId.generateRandomString().substring(0, 7) + ".jpg";

			String uploadPath = GetDirectory.getImageDir() + fileName;

			try {

				FileOutputStream fos = new FileOutputStream(uploadPath);

				InputStream is = filePart.getInputStream();

				byte[] data = new byte[is.available()];

				is.read(data);
				fos.write(data);
				fos.close();
				is.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Car car = new Car(carId, regNumber, nameAndModel, transType, yearofManufacture, rentalPrice, mileage,
				sittingCapacity, fileName);

		int result = CarDAO.updateCar(car);

		if (result > 0) {
			System.out.println("Car Update successfull.");
			resp.sendRedirect("cars");
		} else {
			System.out.println("Car can't be updated, try again!");
		}

	}
}
