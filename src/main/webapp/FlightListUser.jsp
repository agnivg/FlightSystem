<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Travel Thru Air</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body class="bg-light">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark bg-dark">
			<a class="navbar-brand" href="/">Travel Thru Air</a>
			<ul class="navbar-nav ml-auto">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">View Flights</a></li>
				<li><a href="<%=request.getContextPath()%>/filtertime"
					class="nav-link">MindBlowing Deals</a></li>
				<li><a href="<%=request.getContextPath()%>/filtercitypage"
					class="nav-link">Filter</a></li>
				<%if(session.getAttribute("username")!=null){ %>
				<li><a href="<%=request.getContextPath()%>/listadmin"
					class="nav-link">Manage</a></li>
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Logout</a></li>
				<% }else{ %>
				<li><a href="<%=request.getContextPath()%>/login"
					class="nav-link">Login</a></li>
				<%} %>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<div class="container">
			<h3 class="text-center">Flights Available For Today</h3>
			<br/>
			<table class="table">
				<tbody>
				<tr style="display: flex; flex-wrap: wrap; justify-content: space-around;">				
					<c:forEach var="listFlight" items="${listFlight}">
						<td>
						<div class="card text-center bg-primary" style="width: 21rem; ">
						  <div class="card-body" style="background-color:cornsilk;">
						    <h5 class="card-title"><c:out value="${listFlight.departure_city}" /> ---> <c:out value="${listFlight.arrival_city}" /></h5>
						    <h6 class="card-subtitle mb-2 text-muted">Price: Rs. <c:out value="${listFlight.cost}" /></h6>
						    <p class="card-text">Departure : <c:out value="${listFlight.departure_time}" /><br/>Arrival : <c:out value="${listFlight.arrival_time}" /><br/></p>
						    <h6 class="card-subtitle mb-2 text-muted">Legs: <c:out value="${listFlight.stops}" /></h6>
						  </div>
						</div>						
						</td>						
					</c:forEach>
					</tr>		
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>