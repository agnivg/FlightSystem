<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Travel Thru Air</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
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
	<div class="bd-example">
  <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel" data-interval="2000">
    <ol class="carousel-indicators">
      <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
      <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
      <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img src="https://images.pexels.com/photos/3769532/pexels-photo-3769532.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=100&w=1000" class="d-block w-100 img-fluid" style="height:91%;">
        <div class="carousel-caption d-none d-md-block">
          <h5 class="display-4 animated zoomIn">Welcome To <strong>Travel Thru Air</strong></h5>
          <p class="animated zoomIn">We are ready to make you fly higher this time!</p>
        </div>
      </div>
      <div class="carousel-item">
        <img src="https://images.pexels.com/photos/1309644/pexels-photo-1309644.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=100&w=1000" class="d-block w-100 img-fluid" style="height:91%;">
        <div class="carousel-caption d-none d-md-block">
          <h5 class="display-4 animated zoomIn">Welcome To <strong>Travel Thru Air</strong></h5>
          <p class="animated zoomIn">We have some mind blowing deals waiting for you!</p>
        </div>
      </div>
      <div class="carousel-item">
        <img src="https://images.pexels.com/photos/104826/aircraft-holiday-sun-tourism-104826.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=100&w=1000" class="d-block w-100 img-fluid" style="height:91%;">
        <div class="carousel-caption d-none d-md-block">
          <h5 class="display-4 animated zoomIn">Welcome To <strong>Travel Thru Air</strong></h5>
          <p class="animated zoomIn">Don't forget to book the cheapest flights through us</p>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
</body>
</html>