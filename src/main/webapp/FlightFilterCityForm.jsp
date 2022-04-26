<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Travel Thru Air</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body style="background-color:grey;">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark bg-dark">
			<a class="navbar-brand" href="/">Travel Thru Air</a>
			<ul class="navbar-nav ml-auto">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">View Flights</a></li>
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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
					<form action="filtercitytime" method="post">
						<caption>
					<h2 class="text-center">
            			Filter Flight Search
					</h2>
				</caption>

				<fieldset class="form-group">
					<label>Departure city:</label> <input type="text" class="form-control" name="departure_city">
				</fieldset>
				<fieldset class="form-group">
					<label>Arrival city:</label> <input type="text" class="form-control" name="arrival_city">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Enter Time Range:<br><br>Start time: </label> <input type="time" class="form-control" name="startTime">
				</fieldset>
				<fieldset class="form-group">
					<label>End time: </label> <input type="time" class="form-control" name="endTime">
				</fieldset>
				<button type="submit" class="btn btn-primary" style="margin-left:210px;">Filter</button>
				</form>
			</div>
		</div>
	</div>

</div>
</body>
</html>