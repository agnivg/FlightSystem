package com.adminAT.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.adminAT.bean.Login;
import com.adminAT.bean.Flight;


public class FlightDao {
	private static final String INSERT_FLIGHT_SQL = "INSERT INTO flight" + "  (departure_city, arrival_city, cost, start_time, end_time, departure_time, arrival_time, stops) VALUES "
			+ " (?,?,?,?,?,?,?,?);";

	private static final String SELECT_FLIGHT_BY_ID = "select departure_city, arrival_city, cost, start_time, end_time, departure_time, arrival_time, stops from flight where id =?";
	private static final String SELECT_ALL_FLIGHT = "select * from flight";
	private static final String SELECT_SORT_FLIGHT = "select * from flight order by stops";
	private static final String DELETE_FLIGHT_SQL = "delete from flight where id = ?;";
	private static final String UPDATE_FLIGHT_SQL = "update flight set departure_city = ?,arrival_city= ?, cost =?, start_time=?, end_time=?, departure_time=?, arrival_time=?, stops=? where id = ?;";
	private static final String CHECK_MANAGER_SQL = "select * from manager where username = ? and password = ?";
	private static final String SELECT_TIME_FILTER = "select id,departure_city, arrival_city, cost, start_time, end_time,departure_time,arrival_time,stops from flight where (case when start_time<=end_time then start_time<? and end_time>? else start_time<? or end_time>? end)";
	private static final String DEPARTURE_AND_ARRIVAL_AND_TIME = "select id,departure_city, arrival_city, cost,start_time,end_time, departure_time, arrival_time,stops from flight where departure_city=? and arrival_city=? and departure_time>=? and departure_time<=? ;" ;
	public FlightDao() {
	}


	public void insertFlight(Flight flight, Connection connection) throws SQLException {
		System.out.println(INSERT_FLIGHT_SQL);
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FLIGHT_SQL)) {
			preparedStatement.setString(1, flight.getDeparture_city());
			preparedStatement.setString(2, flight.getArrival_city());
			preparedStatement.setInt(3, flight.getCost());
			preparedStatement.setString(4, flight.getStart_time());
			preparedStatement.setString(5, flight.getEnd_time());
			preparedStatement.setString(6, flight.getDeparture_time());
			preparedStatement.setString(7, flight.getArrival_time());
			preparedStatement.setInt(8, flight.getStops());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public boolean validate(Login login, Connection connection) {
		boolean status = false;
		try (	// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(CHECK_MANAGER_SQL);) {
			System.out.println(preparedStatement);
		
			preparedStatement.setString(1, login.getUsername());
			preparedStatement.setString(2, login.getPassword());
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();

			}
		catch (SQLException e) {
			printSQLException(e);
		}
		return status;
	}

	public Flight selectFlight(int id, Connection connection) {
		Flight flight = null;
		// Step 1: Establishing a Connection
		try (   // Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FLIGHT_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String departure_city = rs.getString("departure_city");
				String arrival_city = rs.getString("arrival_city");
				int cost = rs.getInt("cost");
				String start_time = rs.getString("start_time");
				String end_time = rs.getString("end_time");
				String departure_time = rs.getString("departure_time");
				String arrival_time = rs.getString("arrival_time");
				int stops = rs.getInt("stops");
				flight = new Flight(id, departure_city, arrival_city, cost, start_time, end_time, departure_time, arrival_time, stops);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return flight;
	}

	public List<Flight> selectAllFlights(Connection connection) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Flight> flights = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FLIGHT);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String departure_city = rs.getString("departure_city");
				String arrival_city = rs.getString("arrival_city");
				int cost = rs.getInt("cost");
				String start_time = rs.getString("start_time");
				String end_time = rs.getString("end_time");
				String departure_time = rs.getString("departure_time");
				String arrival_time = rs.getString("arrival_time");
				int stops = rs.getInt("stops");
				flights.add(new Flight(id, departure_city, arrival_city, cost, start_time, end_time, departure_time,arrival_time,stops));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return flights;
	}
	
	public List<Flight> sortLegs(Connection connection) {
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Flight> flights = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SORT_FLIGHT);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String departure_city = rs.getString("departure_city");
				String arrival_city = rs.getString("arrival_city");
				int cost = rs.getInt("cost");
				String start_time = rs.getString("start_time");
				String end_time = rs.getString("end_time");
				String departure_time = rs.getString("departure_time");
				String arrival_time = rs.getString("arrival_time");
				int stops = rs.getInt("stops");
				flights.add(new Flight(id, departure_city, arrival_city, cost, start_time, end_time, departure_time,arrival_time,stops));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return flights;
	}

	public static String getTime(LocalTime ldt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return formatter.format(ldt);
    }
	public List<Flight> filterFlight(Connection connection){
		List<Flight> flights = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TIME_FILTER);) {
			LocalTime locT;
			LocalTime time = LocalTime.now();
			locT = LocalTime.parse(getTime(time));
			Time t = Time.valueOf(locT);
			System.out.println(preparedStatement);
			preparedStatement.setTime(1,t);
			preparedStatement.setTime(2,t);
			preparedStatement.setTime(3,t);
			preparedStatement.setTime(4,t);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String departure_city = rs.getString("departure_city");
				String arrival_city = rs.getString("arrival_city");
				int cost = rs.getInt("cost");
				String start_time = rs.getString("start_time");
				String end_time = rs.getString("end_time");
				String departure_time = rs.getString("departure_time");
				String arrival_time = rs.getString("arrival_time");
				int stops = rs.getInt("stops");
				flights.add(new Flight(id, departure_city, arrival_city, cost, start_time, end_time,departure_time,arrival_time,stops));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return flights;
		
	}
	
	public List<Flight> filterFlightCityTime(String departureCity, String arrivalCity,String startTime,String endTime, Connection connection){
		List<Flight> flights = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(DEPARTURE_AND_ARRIVAL_AND_TIME);) {
			preparedStatement.setString(1, departureCity);
			preparedStatement.setString(2, arrivalCity);
			preparedStatement.setTime(3, Time.valueOf(LocalTime.parse(startTime)));
			preparedStatement.setTime(4, Time.valueOf(LocalTime.parse(endTime)));
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String departure_city = rs.getString("departure_city");
				String arrival_city = rs.getString("arrival_city");
				int cost = rs.getInt("cost");
				String start_time = rs.getString("start_time");
				String end_time = rs.getString("end_time");
				String departure_time = rs.getString("departure_time");
				String arrival_time = rs.getString("arrival_time");
				int stops = rs.getInt("stops");
				flights.add(new Flight(id, departure_city, arrival_city, cost, start_time, end_time,departure_time,arrival_time,stops));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return flights;
		
	}
	
	
	public boolean deleteFlight(int id, Connection connection) throws SQLException {
		boolean rowDeleted;
		try (PreparedStatement statement = connection.prepareStatement(DELETE_FLIGHT_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateFlight(Flight flight, Connection connection) throws SQLException {
		boolean rowUpdated;
		try (PreparedStatement statement = connection.prepareStatement(UPDATE_FLIGHT_SQL);) {
			System.out.println("updated USer:"+statement);
			statement.setString(1, flight.getDeparture_city());
			statement.setString(2, flight.getArrival_city());
			statement.setInt(3, flight.getCost());
			statement.setString(4, flight.getStart_time());
			statement.setString(5, flight.getEnd_time());
			statement.setString(6, flight.getDeparture_time());
			statement.setString(7, flight.getArrival_time());
			statement.setInt(8, flight.getStops());
			statement.setInt(9,flight.getId());
			System.out.println(statement);
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}