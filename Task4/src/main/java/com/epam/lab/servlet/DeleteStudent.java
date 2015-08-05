package com.epam.lab.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.database.service.ClassService;
import com.epam.lab.log.MyLogger;



public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteStudent() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int coursId= Integer.parseInt( request.getParameter("coursid"));
		ClassService.delClassRoomID(coursId);
		MyLogger.log.info("Delete student from course");
		 request.getRequestDispatcher("/WorkStudent").forward(request, response);
	}

	

}
