<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Travel Thru Air</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body style="background-color:grey;">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<% 
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if(session.getAttribute("username")==null){
			response.sendRedirect("Login.jsp");
		}
	%>
		<header>
		<nav class="navbar navbar-expand-md navbar-dark bg-dark">
			<a class="navbar-brand" href="/">Travel Thru Air</a>
			<ul class="navbar-nav ml-auto">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">View Flights</a></li>
					<li><a href="<%=request.getContextPath()%>/listadmin"
					class="nav-link">Manage</a></li>
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${flight != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${flight == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2 class="text-center">
						<c:if test="${flight != null}">
            			Update Flight Details
            		</c:if>
						<c:if test="${flight == null}">
            			Add New Flight
            		</c:if>
					</h2>
				</caption>

				<c:if test="${flight != null}">
					<input type="hidden" name="id" value="<c:out value='${flight.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Departure City</label> <input type="text"
						value="<c:out value='${flight.departure_city}' />" class="form-control"
						name="departure_city" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Arrival City</label> <input type="text"
						value="<c:out value='${flight.arrival_city}' />" class="form-control"
						name="arrival_city">
				</fieldset>

				<fieldset class="form-group">
					<label>Cost</label> <input type="text"
						value="<c:out value='${flight.cost}' />" class="form-control"
						name="cost">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Start time</label> <input type="time"
						value="<c:out value='${flight.start_time}' />" class="form-control"
						name="start_time">
				</fieldset>
				
				<fieldset class="form-group">
					<label>End Time</label> <input type="time"
						value="<c:out value='${flight.end_time}' />" class="form-control"
						name="end_time">
				</fieldset>
				
					<fieldset class="form-group">
					<label>Departure Time</label> <input type="time"
						value="<c:out value='${flight.departure_time}' />" class="form-control"
						name="departure_time">
				</fieldset>
				
					<fieldset class="form-group">
					<label>Arrival Time</label> <input type="time"
						value="<c:out value='${flight.arrival_time}' />" class="form-control"
						name="arrival_time">
				</fieldset>
				
					<fieldset class="form-group">
					<label>Legs</label> <input type="text"
						value="<c:out value='${flight.stops}' />" class="form-control"
						name="stops">
				</fieldset>

				<button type="submit" class="btn btn-primary" style="margin-left:210px;">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>