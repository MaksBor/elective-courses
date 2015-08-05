package com.epam.lab.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.database.model.Subject;
import com.epam.lab.database.service.LectureService;
import com.epam.lab.database.service.SubjectService;

/**
 * Servlet implementation class Workroom
 */

public class Workroom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Workroom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Subject> list = new ArrayList<>();
		for (Subject subject : SubjectService.getAllSubject()) {
			if(LectureService.getLectureSubject(subject.getId())==null){
				list.add(subject);
			}
		}
		
		List<Subject> lists = new ArrayList<>();
		for (Subject subject : SubjectService.getAllSubject()) {
			
				lists.add(subject);
			
		}
		session.setAttribute("listsubject", lists);
		session.setAttribute("listobject", list);
		request.getRequestDispatcher("pages/workroom.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
