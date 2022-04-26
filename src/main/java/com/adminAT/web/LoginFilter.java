package com.adminAT.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adminAT.bean.Login;
import com.adminAT.dao.FlightDao;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, urlPatterns = { "/login" })
public class LoginFilter extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 7335871814668846362L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public LoginFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		System.out.println("In filter");
		String uname = ((HttpServletRequest)request).getParameter("username");
		String password = ((HttpServletRequest)request).getParameter("password");
		Login login = new Login();
		login.setUsername(uname);
		login.setPassword(password);
		Connection conn = (Connection) ((HttpServletRequest)request).getServletContext().getAttribute("conn");
		if(((FlightDao) ((HttpServletRequest)request).getServletContext().getAttribute("FlightDao")).validate(login,conn))
			chain.doFilter(request, response);
		else
			((HttpServletResponse) response).sendRedirect("Login.jsp");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
