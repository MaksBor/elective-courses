package com.epam.lab.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.database.model.Lecture;
import com.epam.lab.database.service.ClassService;
import com.epam.lab.database.service.LectureService;
import com.epam.lab.database.service.SubjectService;
import com.epam.lab.log.MyLogger;

/**
 * Servlet implementation class DeleteCourse
 */
public class DeleteCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCourse() {
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
		
		MyLogger.log.info("Load workroom pages");
		int subject = Integer.parseInt(request.getParameter("subjectfirst"));
		ClassService.delClassRoom(subject);
		List<Lecture> list= LectureService.getAllLecture();
		for (Lecture lecture : list) {
			if(lecture.getSubject().getId()==subject){
				lecture.setSubject(null);
				LectureService.updateLecture(lecture);
			}
		}
		SubjectService.delSubject(subject);
		response.sendRedirect("/Workroom");
		
	}

}
