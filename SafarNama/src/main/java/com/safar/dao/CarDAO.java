package com.safar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.safar.config.DBConnection;
import com.safar.model.Car;
import com.safar.utils.GetDirectory;

public class CarDAO {

	// method to add a car
	// check if it is only Admin who is trying to add car.
	public static int addCar(Car car) {

		String query = "insert into car values(?,?,?,?,?,?,?,?,?)";
		
		String imageDir = GetDirectory.getImageDir();
		try (Connection conn = DBConnection.getConnection()) {
			System.out.println(conn);
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, car.getId());
			stmt.setString(2, car.getRegNumber());
			stmt.setString(3, car.getNameAndModel());
			stmt.setString(4, car.getTransType());
			stmt.setInt(5, car.getYearofManufacture());
			stmt.setDouble(6,  car.getRentalPrice());
			stmt.setDouble(7, car.getMileage());
			stmt.setInt(8, car.getSittingCapacity());
			stmt.setString(9, car.getPhotoURL());
			

			if (stmt.executeUpdate() > 0) {
				System.out.println("Car added successfully.");
				conn.close();
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;

	}

	// method to fetch all the cars from the database.
	// we need to only fetch N number of cars so that pagination can be provided.
	// anyone can fetch car details.
	public static ArrayList<Car> fetchCars() {
		String imageDir = GetDirectory.getImageDir();
		String query = "select * from car";
		ArrayList<Car> cars = new ArrayList<>();
		try (Connection conn = DBConnection.getConnection()) {
			Statement stmt = conn.createStatement();

			ResultSet resultSet = stmt.executeQuery(query);

			while (resultSet.next()) {
				cars.add(new Car(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getInt(5), resultSet.getDouble(6), resultSet.getDouble(7),
						resultSet.getInt(8), imageDir + resultSet.getString(9)));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cars;
	}

	// anyone can fetch the cars details here also.
	public static Car fetchSingleCar(String carId) {
		// only fetch the single car by its ID
		
		

		return null;
	}

	// only admin an update a car details.
	public static Car updateCar(Car updatedCar) {
		// update a car by getting new car details.
		return null;
	}

	// only admin can
	public static Car deleteCar(String carId) {
		// delete the car from the database.
		// return either boolean or Car itself.
		return null;
	}

}
