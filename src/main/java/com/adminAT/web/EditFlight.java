package com.adminAT.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adminAT.bean.Flight;
import com.adminAT.dao.FlightDao;

/**
 * Servlet implementation class EditFlight
 */
@WebServlet("/edit")
public class EditFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFlight() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		Flight flight = ((FlightDao) request.getServletContext().getAttribute("FlightDao")).selectFlight(id,conn);
		System.out.print(flight);
		request.setAttribute("flight", flight);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FlightForm.jsp");
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
