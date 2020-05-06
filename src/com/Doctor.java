package com;

import java.sql.*;

public class Doctor {
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String readDoctors() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			
			output = "<table class='table table-hover'><tr><th>Doctor Name</th><th>Specialization</th><th>Phone No</th>"
					+ "<th>Email</th><th>Hospital Name</th><th>Available Day</th><th>Available Time</th>"
					+ "<th>Doctor Charge</th><th>Update</th><th>Remove</th></tr>";

			String query = "select * from doctor";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String doctorId = Integer.toString(rs.getInt("doctorId"));
				String doctorName = rs.getString("doctorName");
				String specialization = rs.getString("specialization");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String hospitalName = rs.getString("hospitalName");
				String availableDay = rs.getString("availableDay");
				String availableTime = rs.getString("availableTime");
				String doctorCharge = Float.toString(rs.getFloat("doctorCharge"));
				// Add into the html table
				output += "<tr><td><input id='hiddoctorIdUpdate' name='hiddoctorIdUpdate' type='hidden' value='" + doctorId
						+ "'>" + doctorName + "</td>";
				output += "<td>" + specialization + "</td>";
				output += "<td>" + phone + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + hospitalName + "</td>";
				output += "<td>" + availableDay + "</td>";
				output += "<td>" + availableTime + "</td>";
				output += "<td>" + doctorCharge + "</td>";
				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"
						+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-itemid='"
						+ doctorId + "'>" + "</td></tr>";
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the Doctors.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String insertDoctors(String doctorName, String specialization, String phone, String email,
			String hospitalName, String availableDay, String availableTime, String doctorCharge) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into doctor(`doctorId`,`doctorName`,`specialization`,`phone`,`email`,`hospitalName`,`availableDay`,`availableTime`,`doctorcharge`)"
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, doctorName);
			preparedStmt.setString(3, specialization);
			preparedStmt.setString(4, phone);
			preparedStmt.setString(5, email);
			preparedStmt.setString(6, hospitalName);
			preparedStmt.setString(7, availableDay);
			preparedStmt.setString(8, availableTime);
			preparedStmt.setFloat(9, Float.parseFloat(doctorCharge));
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newDoc = readDoctors();
			output = "{\"status\":\"success\", \"data\": \"" +newDoc+ "\"}";
			
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while inserting the Doctors.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateDoctors(String doctorId,String doctorName, String specialization, String phone, String email,
			String hospitalName, String availableDay, String availableTime, String doctorCharge) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE doctor SET doctorName=?,specialization=?,phone=?,email=?,hospitalName=?,availableDay=?,availableTime=?,doctorCharge=? WHERE doctorId=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			
		
			preparedStmt.setString(1, doctorName);
			preparedStmt.setString(2, specialization);
			preparedStmt.setString(3, phone);
			preparedStmt.setString(4, email);
			preparedStmt.setString(5, hospitalName);
			preparedStmt.setString(6, availableDay);
			preparedStmt.setString(7, availableTime);
			preparedStmt.setFloat(8, Float.parseFloat(doctorCharge));
			preparedStmt.setInt(9, Integer.parseInt(doctorId));
	
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newDoc =readDoctors();
			output = "{\"status\":\"success\", \"data\": \"" +newDoc+ "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while updating the doctor.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteDoctors(String doctorId) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from doctor where doctorId=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(doctorId));
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newDoc = readDoctors();
			output = "{\"status\":\"success\", \"data\": \"" +newDoc + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while deleting the doctor.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}
}