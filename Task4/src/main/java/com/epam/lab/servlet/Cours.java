package com.epam.lab.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.database.service.SubjectService;
import com.epam.lab.log.MyLogger;




/**
 * Servlet implementation class Cours
 */

public class Cours extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cours() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setAttribute("listcourse", SubjectService.getAllSubject()); 
		MyLogger.log.info("Load course pages");
		request.getRequestDispatcher("pages/courses.jsp").forward(request, response);
		
	 	
		
		
		
	}

	


}
