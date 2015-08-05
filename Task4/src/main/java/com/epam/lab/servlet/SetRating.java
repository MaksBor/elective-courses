package com.epam.lab.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.database.model.Archive;
import com.epam.lab.database.model.ClassRoom;
import com.epam.lab.database.model.Student;
import com.epam.lab.database.service.ArchiveSrvice;
import com.epam.lab.database.service.ClassService;
import com.epam.lab.database.service.StudentService;
import com.epam.lab.log.MyLogger;

/**
 * Servlet implementation class SetRating
 */

public class SetRating extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SetRating() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		int coursId = Integer.parseInt(request.getParameter("coursid"));
		ClassRoom room = ClassService.getClassRoom(coursId);

		Student student = StudentService.getStudent(room.getStudent().getId());

		Date end = new Date();
		if (end.before(student.getDate())) {

			sesion.setAttribute("mesegerating", "Student starting study at "
					+ student.getDate());

			request.getRequestDispatcher("/WorkStudent").forward(request,
					response);
			return;
		}
		String ratin = request.getParameter("rating");
		int rating = 0;
		try {

			rating = Integer.parseInt(ratin);

			if (rating > 100 || rating < 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			MyLogger.log.error(e);
			sesion.setAttribute("mesegerating",
					"You entered incorrect rating! Enter 0-100");
			request.getRequestDispatcher("/WorkStudent").forward(request,
					response);
			return;
		}

		Archive archive = new Archive();
		archive.setLector(room.getLector());
		archive.setStudent(room.getStudent());
		archive.setSubject(room.getSubject());
		archive.setRating(rating);
		archive.setDate(end);
		ArchiveSrvice.addDaybook(archive);
		ClassService.delClassRoomID(coursId);
		sesion.setAttribute("mesegerating", null);
		request.getRequestDispatcher("/WorkStudent").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
	}

}
