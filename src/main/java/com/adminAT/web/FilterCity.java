package com.adminAT.web;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adminAT.bean.Flight;
import com.adminAT.dao.FlightDao;

/**
 * Servlet implementation class FilterCity
 */
@WebServlet("/filtercitytime")
public class FilterCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilterCity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection conn = (Connection)request.getServletContext().getAttribute("conn");
	    String departure_city = request.getParameter("departure_city");
		String arrival_city = request.getParameter("arrival_city");	
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		List<Flight> filterFlight = ((FlightDao) request.getServletContext().getAttribute("FlightDao")).filterFlightCityTime(departure_city,arrival_city,startTime,endTime,conn);
	   	request.setAttribute("listFlight", filterFlight);
	   	RequestDispatcher dispatcher = request.getRequestDispatcher("FlightFilterCity.jsp");
	   	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
