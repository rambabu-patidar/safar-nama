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

		try (Connection conn = DBConnection.getConnection()) {
			System.out.println(conn);

			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, car.getId());
			stmt.setString(2, car.getRegNumber());
			stmt.setString(3, car.getNameAndModel());
			stmt.setString(4, car.getTransType());
			stmt.setInt(5, car.getYearofManufacture());
			stmt.setDouble(6, car.getRentalPrice());
			stmt.setDouble(7, car.getMileage());
			stmt.setInt(8, car.getSittingCapacity());
			stmt.setString(9, car.getPhotoURL());

			if (stmt.executeUpdate() > 0) {
				System.out.println("Car added successfully.");
				conn.close();
				return 1;
			}
		} catch (SQLException e) {
			if (e.getErrorCode() == 30000) {
				System.out.println("Car with this registration exists.");
			}
//			e.printStackTrace();
		}

		return 0;

	}

	// method to fetch all the cars from the database.
	// we need to only fetch N number of cars so that pagination can be provided.
	// anyone can fetch car details.
	public static ArrayList<Car> fetchCars() {
		String query = "select * from car";
		ArrayList<Car> cars = new ArrayList<>();
		try (Connection conn = DBConnection.getConnection()) {
			Statement stmt = conn.createStatement();

			ResultSet resultSet = stmt.executeQuery(query);

			while (resultSet.next()) {
				cars.add(new Car(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getInt(5), resultSet.getDouble(6), resultSet.getDouble(7),
						resultSet.getInt(8), resultSet.getString(9)));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cars;
	}
	
	
	public static ArrayList<Car> fetchCars(int page, int ITEMS_PER_PAGE) {
		ArrayList<Car> cars = new ArrayList<>();
		int offset = (page - 1) * ITEMS_PER_PAGE;
		String query = "select * from car offset ? rows fetch first ? rows only";
		
		try (Connection conn = DBConnection.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(query);

			
			// Get paginated products
			stmt.setInt(1, offset);
			stmt.setInt(2, ITEMS_PER_PAGE);
            ResultSet resultSet = stmt.executeQuery();
            
			while (resultSet.next()) {
				cars.add(new Car(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getInt(5), resultSet.getDouble(6), resultSet.getDouble(7),
						resultSet.getInt(8), resultSet.getString(9)));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cars;
	}
	
	public static int getCarsCount() {
		String countQuery = "SELECT COUNT(*) FROM car";;
		int count = 0;
		try (Connection conn = DBConnection.getConnection()) {
			Statement stmt = conn.createStatement();
			
			ResultSet resultSet = stmt.executeQuery(countQuery);
			
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	// anyone can fetch the cars details here also.
	public static Car fetchSingleCar(String carId) {
		// only fetch the single car by its ID
		String query = "select * from car where id=?";
		Car car = null;
		try (Connection conn = DBConnection.getConnection()) {
			System.out.println(conn);

			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, carId);

			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				car = new Car(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getInt(5), resultSet.getDouble(6), resultSet.getDouble(7),
						resultSet.getInt(8), resultSet.getString(9));
			}
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return car;
	}

	// only admin an update a car details.
	public static int updateCar(Car updatedCar) {
		String query = "update car set regNumber=?, nameAndModel=?, transType=?, yearofManufacture=?, rentalPrice=?, mileage=?, sittingCapacity=?, photoURL=? where id=?";
		
		try (Connection conn = DBConnection.getConnection()) {
			System.out.println(conn);

			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, updatedCar.getRegNumber());
			stmt.setString(2, updatedCar.getNameAndModel());
			stmt.setString(3, updatedCar.getTransType());
			stmt.setInt(4, updatedCar.getYearofManufacture());
			stmt.setDouble(5, updatedCar.getRentalPrice());
			stmt.setDouble(6, updatedCar.getMileage());
			stmt.setInt(7, updatedCar.getSittingCapacity());
			stmt.setString(8, updatedCar.getPhotoURL());
			
			stmt.setString(9, updatedCar.getId());

			if (stmt.executeUpdate() > 0) {
				System.out.println("Car Updated successfully.");
				conn.close();
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
		
	}

	// only admin can
	public static int deleteCar(String carId) {
String query = "delete from car where id=?";
		
		try (Connection conn = DBConnection.getConnection()) {
			System.out.println(conn);

			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, carId);
			

			if (stmt.executeUpdate() > 0) {
				System.out.println("Car Deleted successfully.");
				conn.close();
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
		
	}

}
