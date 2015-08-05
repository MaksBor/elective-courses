package com.epam.lab.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

import com.epam.lab.log.MyLogger;



/**
 * Servlet implementation class Home
 */

public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		   String log4jLocation = config.getInitParameter("log4j-properties-location");
		 
		   ServletContext sc = config.getServletContext();
		 
		   if (log4jLocation == null) {
		      
		      BasicConfigurator.configure();
		   } else {
		      String webAppPath = sc.getRealPath("/");
		      String log4jProp = webAppPath + log4jLocation;
		      File output = new File(log4jProp);
		 
		      if (output.exists()) {
		        
		         PropertyConfigurator.configure(log4jProp);
		      } else {
		        
		         BasicConfigurator.configure();
		      }
		   }
		 
		   super.init(config);
	}
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyLogger.log.debug("Load Home pages");
		request.getRequestDispatcher("pages/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
