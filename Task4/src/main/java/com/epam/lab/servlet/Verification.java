package com.epam.lab.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.database.model.Student;
import com.epam.lab.database.service.StudentService;

/**
 * Servlet implementation class Verification
 */
@WebServlet("/verification")
public class Verification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessio = request.getSession();
		
		Integer idStudent = Integer.parseInt(request.getParameter("idStudent"));
		Student student = StudentService.getStudent(idStudent);
		student.setVerificate(true);
		 sessio.setAttribute("user", student);
		StudentService.updateStudent(student);
		request.getRequestDispatcher("/home").forward(request,
				response);
		
	}

	

}
