package com.epam.lab.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.database.model.Student;
import com.epam.lab.database.model.Subject;
import com.epam.lab.database.service.ClassService;


/**
 * Servlet implementation class DeleteCours
 */

public class DeleteStudentFromCours extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudentFromCours() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int coursId= Integer.parseInt(request.getParameter("coursid"));
		
		 Student student = (Student) session.getAttribute("user");
		 ClassService.delStudentClassRoom(student.getId(), coursId);
			response.sendRedirect(request.getHeader("Referer"));
	}

	

}
