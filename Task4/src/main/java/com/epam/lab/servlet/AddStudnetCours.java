package com.epam.lab.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.database.model.ClassRoom;
import com.epam.lab.database.model.Lecture;
import com.epam.lab.database.model.Student;
import com.epam.lab.database.model.Subject;
import com.epam.lab.database.service.ClassService;
import com.epam.lab.database.service.LectureService;
import com.epam.lab.database.service.SubjectService;

/**
 * Servlet implementation class AddStudnetCours
 */

public class AddStudnetCours extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudnetCours() {
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
		 Lecture lecture = LectureService.getLectureSubject(coursId);
		 Subject subject = SubjectService.getSubject(coursId);
	 	ClassRoom classRoom = new ClassRoom();
	 	classRoom.setStudent(student);
	 	classRoom.setLector(lecture);
	 	classRoom.setSubject(subject);
		 ClassService.addClassRoom(classRoom);
		 
		 
		 request.getRequestDispatcher("pages/courses.jsp").forward(request, response);
	}

}
