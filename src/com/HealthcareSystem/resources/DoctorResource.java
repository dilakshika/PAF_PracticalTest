package com.HealthcareSystem.resources;

import com.HealthcareSystem.service.doctor.doctorService;
import com.HealthcareSystem.model.Doctor;

import java.sql.SQLException;

import javax.annotation.security.RolesAllowed;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;



@Path("/Doctors")
public class DoctorResource {
	Doctor DocObj = new Doctor();

	@RolesAllowed({"patient","admin"})
	@GET
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String readDoctors() {
		doctorService DocObj = new doctorService();

		String output = DocObj.readDoctors();
		return output;

	}
	

	@RolesAllowed({"patient","admin"})
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertDoctors(String doctorData) {
		// Convert the input string to a JSON object
		JsonObject DoctorObj = new JsonParser().parse(doctorData).getAsJsonObject();
		// Read the values from the JSON object

		String doctorId = DoctorObj.get("doctorId").getAsString();
		String doctorName = DoctorObj.get("doctorName").getAsString();
		String specialization = DoctorObj.get("specialization").getAsString();
		Integer phoneNo = DoctorObj.get("phoneNo").getAsInt();
		String email = DoctorObj.get("email").getAsString();
		String hospitalId = DoctorObj.get("hospitalId").getAsString();
		String availableDay = DoctorObj.get("availableDay").getAsString();
		String availableTime = DoctorObj.get("availableTime").getAsString();
		Float doctorCharge = DoctorObj.get("doctorCharge").getAsFloat();
		
		
		doctorService doctorobject1 = new doctorService();
		
		DocObj.setdoctorName(doctorName);
		DocObj.setSpecialization(specialization);
		DocObj.setPhone(phoneNo);
		DocObj.setEmail(email);
		DocObj.setHospitailId(hospitalId);
		DocObj.setAvailableDay(availableDay);
		DocObj.setAvailableTime(availableTime);
		DocObj.setDoctorCharge(doctorCharge);

		String output = doctorobject1.insertDoctors(DocObj);
		return output;
	}
	@RolesAllowed({"patient","admin"})
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateDoctors(String doctorData) throws SQLException {
		// Convert the input string to a JSON object
		JsonObject DoctorObj = new JsonParser().parse(doctorData).getAsJsonObject();
		// Read the values from the JSON object

		String doctorId = DoctorObj.get("doctorId").getAsString();
		String doctorName = DoctorObj.get("doctorName").getAsString();
		String specialization = DoctorObj.get("specialization").getAsString();
		Integer phoneNo = DoctorObj.get("phoneNo").getAsInt();
		String email = DoctorObj.get("email").getAsString();
		String hospitalId = DoctorObj.get("hospitalId").getAsString();
		String availableDay = DoctorObj.get("availableDay").getAsString();
		String availableTime = DoctorObj.get("availableTime").getAsString();
		Float doctorCharge = DoctorObj.get("doctorCharge").getAsFloat();
		

		doctorService doctorobject2 = new doctorService();
		
		
		DocObj.setdoctorName(doctorName);
		DocObj.setSpecialization(specialization);
		DocObj.setPhone(phoneNo);
		DocObj.setEmail(email);
		DocObj.setHospitailId(hospitalId);
		DocObj.setAvailableDay(availableDay);
		DocObj.setAvailableTime(availableTime);
		DocObj.setDoctorCharge(doctorCharge);

		String output = doctorobject2.updateDoctors(DocObj);
		return output;
	}
	@RolesAllowed({"patient","admin"})
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteDoctors(String doctorData) {
		JsonObject docObject = new JsonParser().parse(doctorData).getAsJsonObject();

		// Read the value from the element <doctorID>
		String doctorId = docObject.get("doctorId").getAsString();

		doctorService doctorobject3 = new doctorService();
	
		String output = doctorobject3.deleteDoctors(DocObj);
		return output;
	}
	@RolesAllowed({"patient","admin"})
	@GET
	@Path("/shedual")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String viewDoctorShedual() {
		doctorService DocObj = new doctorService();

		
		
		
		String output = DocObj.viewDoctorShedual();
		return output;
	}
	
	
}