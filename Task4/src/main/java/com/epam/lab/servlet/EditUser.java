package com.epam.lab.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.database.model.Lecture;
import com.epam.lab.database.model.Student;
import com.epam.lab.database.service.LectureService;
import com.epam.lab.database.service.StudentService;
import com.epam.lab.log.MyLogger;
import com.epam.lab.md5.MD5Hashing;

/**
 * Servlet implementation class EditUser
 */
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("updates");

		if (user.contains("Student")) {
			Integer id = Integer.parseInt(user.replaceAll("([a-zA-Z])", ""));
			Student student = StudentService.getStudent(id);
			if (isNull("name", request)) {
				student.setName(convertUtf8(request.getParameter("name")));
			}
			if (isNull("surname", request)) {
				student.setSurname(convertUtf8(request.getParameter("surname")));
			}
			if (isNull("password", request)) {
				student.setPassword(MD5Hashing.getHesh(request
						.getParameter("password")));
			}
			if (isNull("email", request)) {
				student.setEmail(request.getParameter("email"));
				;
			}
			StudentService.updateStudent(student);

		} else {
			Integer id = Integer.parseInt(user.replaceAll("([a-zA-Z])", ""));
			Lecture lecture = LectureService.getLecture(id);
			if (isNull("name", request)) {
				lecture.setName(convertUtf8(request.getParameter("name")));
			}
			if (isNull("surname", request)) {
				lecture.setSurname(convertUtf8(request.getParameter("surname")));
			}
			if (isNull("password", request)) {
				lecture.setPassword(MD5Hashing.getHesh(request
						.getParameter("password")));
			}
			if (isNull("email", request)) {
				lecture.setEmail(request.getParameter("email"));
				;
			}
			if (request.getParameter("admin") != null
					&& request.getParameter("admin").equals("true")) {
				lecture.setAdmin(true);
			} else {
				lecture.setAdmin(false);
			}

			LectureService.updateLecture(lecture);
		}
		MyLogger.log.info("Edit user");
		request.getRequestDispatcher("pages/workroomAdmin.jsp").forward(
				request, response);
	}

	private boolean isNull(String st, HttpServletRequest request) {
		return !request.getParameter(st).isEmpty();
	}

	public String convertUtf8(String st) throws UnsupportedEncodingException {
		if (st == null || st.isEmpty()) {
			return null;
		} else {
			return new String(st.getBytes("ISO-8859-1"), "UTF-8");
		}

	}

}
