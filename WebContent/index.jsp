<%@page import="com.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Details</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery.min.js"></script>
<script src="Components/doctor.js"></script>
<script src="Components/jquery.min.js"></script>
<link rel="stylesheet" href="assets">
<link rel="stylesheet" href="Views/bootstrap.min.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

	<div class="row">
		<div class="col-lg-12">
			<div class="card m-b-32">
				<div class="card-body">

					<form id="formDoctor" name="formDoctor" method="post"
						action="index.jsp">

						<label>Doctor Name</label> <input id="doctorName"
							name="doctorName" type="text"
							class="form-control form-control-sm">
							<br> 
							<label>Specialization</label> 
							<select id="specialization" name="specialization" class="form-control form-control-sm">
							<option value="Surgeon">Surgeon</option>
							<option value="Psychiatrist">Psychiatrist</option>
							<option value="Cardiologist">Cardiologist</option>
							<option value="Dermatologist">Dermatologist</option>
							<option value="Pediatrician">Pediatrician</option>
							</select>
						
							<br><label>Phone No</label> <input id="phone" name="phone"
							type="text" class="form-control form-control-sm"> 
							
							<br><label>Email</label> <input id="email" name="email"
							type="text" class="form-control form-control-sm"> <br>

							<label> Hospital Name</label> 
							<select id="hospitalName" name="hospitalName" class="form-control form-control-sm">
							<option value="Asiri Hospital">Asiri Hospital</option>
							<option value="Lanka Hospitals">Lanka Hospitals</option>
							<option value="Nawaloka Hospitals Limited">Nawaloka Hospitals Limited</option>
							<option value="Hemas Hospital, Wattala">Hemas Hospital,Wattala</option>
							<option value="Ceymed Health care">Ceymed Health care</option>
							<option value="Golden Key Eye and ENT Hospital">Golden Key Eye and ENT Hospital</option>
							</select>

							<br><label> Available Day</label> 
							<select id="availableDay" name="availableDay" class="form-control form-control-sm">
							<option value="Monday">Monday</option>
							<option value="Tuesday">Tuesday</option>
							<option value="Wednesday">Wednesday</option>
							<option value="Thursday">Thursday</option>
							<option value="Friday">Friday</option>
							<option value="Saturday">Saturday</option>
							<option value="Sunday">Sunday</option>
							</select>
							
							 <br><label>Available Time</label>
							 <input id="availableTime" name="availableTime" type="time"
							class="form-control form-control-sm"> <br>
							
							 <label>Doctor Charge</label>
							 <input id="doctorCharge" name="doctorCharge" type="text"
							class="form-control form-control-sm">
							 <br>
							 <input id="btnSave" name="btnSave" type="button" value="Save"
							class="btn btn-primary"> <input type="hidden"
							id="hiddoctorIdSave" name="hiddoctorIdSave" value="">
					</form>
					<br>
					<div id="alertSuccess" class="alert alert-success"></div>
					<div id="alertError" class="alert alert-danger"></div>
					<br> <br>
					
					<div id="divDoctorGrid">
						<%
							Doctor docObj = new Doctor();
							out.print(docObj.readDoctors());
						%>
					</div>
				</div>
</div>
</div>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>