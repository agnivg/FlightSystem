package com.adminAT.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.adminAT.dao.FlightDao;

/**
 * Application Lifecycle Listener implementation class initConn
 *
 */
@WebListener
public class initConn implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public initConn() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	ServletContext sc = sce.getServletContext();
		String connString = sc.getInitParameter("dbConnString");
		
		String connUser = sc.getInitParameter("dbuser");
		
		String connPwd = sc.getInitParameter("dbpass");
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(connString,connUser,connPwd); 
			System.out.println("**********************************");
			sc.setAttribute("conn",con);
			FlightDao flightDao = new FlightDao();
			sc.setAttribute("FlightDao", flightDao);
			System.out.println(con);
			flightsTable(con);
 
		}catch(Exception e){ System.out.println(e);}
    }
    
    private void flightsTable(Connection con) {
    	try {
    		Statement stmt1, stmt2;
			stmt1 = con.createStatement();
			stmt2 = con.createStatement();
			String sql1 = "CREATE TABLE IF NOT EXISTS flight (id int NOT NULL AUTO_INCREMENT, departure_city varchar(25) DEFAULT NULL, arrival_city varchar(25) DEFAULT NULL, cost int DEFAULT NULL, start_time time DEFAULT NULL, end_time time DEFAULT NULL, departure_time time DEFAULT NULL, arrival_time time DEFAULT NULL, stops int DEFAULT NULL, PRIMARY KEY (id));"; 
			String sql2 = "CREATE TABLE IF NOT EXISTS manager (username varchar(20) NOT NULL, password varchar(20) DEFAULT NULL, PRIMARY KEY (username));";
			int rs1 = stmt1.executeUpdate(sql1);
			int rs2 = stmt2.executeUpdate(sql2);
			System.out.println(rs1);
			System.out.println(rs2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
    }
}
