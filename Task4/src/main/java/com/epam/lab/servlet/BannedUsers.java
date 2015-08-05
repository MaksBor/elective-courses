package com.epam.lab.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.database.model.Lecture;
import com.epam.lab.database.model.Student;
import com.epam.lab.database.service.LectureService;
import com.epam.lab.database.service.StudentService;
import com.epam.lab.log.MyLogger;

/**
 * Servlet implementation class DeleteUsers
 */

public class BannedUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BannedUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("delete");
				if(user.contains("Student")){
			
			Integer id = Integer.parseInt(user.replaceAll("([a-zA-Z])", ""));
			Student student = StudentService.getStudent(id);
			if(student.getStatus()){
				student.setStatus(false);
			}else{
				student.setStatus(true);
			}
			
			StudentService.updateStudent(student);
			
		}
		else{
			
			Integer id = Integer.parseInt(user.replaceAll("([a-zA-Z])", ""));
			Lecture lecture =LectureService.getLecture(id);
			if(lecture.getStatus()){
				lecture.setStatus(false);
			}else{
				lecture.setStatus(true);
			}
			
			LectureService.updateLecture(lecture);
		}
		MyLogger.log.info("Load banned user");
		 request.getRequestDispatcher("pages/workroomAdmin.jsp").forward(request, response);
	}

}
