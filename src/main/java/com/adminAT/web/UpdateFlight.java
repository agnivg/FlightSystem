package com.adminAT.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adminAT.bean.Flight;
import com.adminAT.dao.FlightDao;

/**
 * Servlet implementation class UpdateFlight
 */
@WebServlet("/update")
public class UpdateFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String departure_city = request.getParameter("departure_city");
		String arrival_city = request.getParameter("arrival_city");
		int cost = Integer.parseInt(request.getParameter("cost"));
		String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
		String departure_time = request.getParameter("departure_time");
		String arrival_time = request.getParameter("arrival_time");
		int stops = Integer.parseInt(request.getParameter("stops"));
		Flight updatedFlight = new Flight(id,departure_city, arrival_city, cost, start_time, end_time,departure_time,arrival_time, stops );
		Connection conn = (Connection)request.getServletContext().getAttribute("conn");
		try {
			((FlightDao) request.getServletContext().getAttribute("FlightDao")).updateFlight(updatedFlight,conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listadmin");
	}

}
