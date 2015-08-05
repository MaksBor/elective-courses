package com.epam.lab.servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.database.model.Lecture;
import com.epam.lab.database.model.Student;
import com.epam.lab.database.service.LectureService;
import com.epam.lab.database.service.StudentService;
import com.epam.lab.log.MyLogger;
import com.epam.lab.md5.MD5Hashing;

/**
 * Servlet implementation class Login
 */

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("pages/login.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MyLogger.log.info("Load Home login");
		
		HttpSession sesion = request.getSession();
	
		if((request.getParameter("mail").isEmpty())||(request.getParameter("passwordl").isEmpty())){
			
		sesion.setAttribute("inemail", request.getParameter("mail"));
		sesion.setAttribute("error1", "Wrong email or password");
		request.getRequestDispatcher("pages/login.jsp").forward(request, response);
		
		}else{
			if(isUser("mail", request)){
				
				if(isStudent("mail", request)){
					Student student = StudentService.getStudent(request.getParameter("mail"));
					if(student.getStatus()){
					if(student.getPassword().equals(MD5Hashing.getHesh(request.getParameter("passwordl")))){
						sesion.setAttribute("user", student);
						sesion.setAttribute("type", "student");
						response.sendRedirect("/home");
					}else{
						sesion.setAttribute("inemail", request.getParameter("mail"));
						sesion.setAttribute("error1", "Wrong email or password");
						request.getRequestDispatcher("pages/login.jsp").forward(request, response);
					}}else{
						sesion.setAttribute("inemail", request.getParameter("mail"));
						sesion.setAttribute("error1", "You is banned");
						request.getRequestDispatcher("pages/login.jsp").forward(request, response);
					}
				}else{
					Lecture lecture = LectureService.getLecture(request.getParameter("mail"));
					if(!lecture.getStatus()){
						sesion.setAttribute("inemail", request.getParameter("mail"));
						sesion.setAttribute("error1", "You is banned");
						request.getRequestDispatcher("pages/login.jsp").forward(request, response);
					}
					else if(lecture.getPassword().equals(MD5Hashing.getHesh(request.getParameter("passwordl")))){
						
						sesion.setAttribute("user", lecture);
						if(lecture.getAdmin()==true){
							sesion.setAttribute("type", "admin");
						}else{
							sesion.setAttribute("type", "lector");
						}
						
						response.sendRedirect("/home");
					}else{
						sesion.setAttribute("inemail", request.getParameter("mail"));
						sesion.setAttribute("error1", "Wrong email or password");
						request.getRequestDispatcher("pages/login.jsp").forward(request, response);
					}
				}

				
			}else{
				sesion.setAttribute("inemail", request.getParameter("mail"));
				sesion.setAttribute("error1", "Wrong email or password");
				response.sendRedirect("pages/login.jsp");
			}
			
			
		}
		
	}
	private boolean isUser(String st, HttpServletRequest request){
	 return LectureService.getLecture(request.getParameter(st))!=null||StudentService.getStudent(request.getParameter(st))!=null;
	}
	private boolean isStudent(String st, HttpServletRequest request){
		return StudentService.getStudent(request.getParameter(st))!=null;
	}
}

