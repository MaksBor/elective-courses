package com.epam.lab.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;




import com.epam.lab.database.model.Subject;
import com.epam.lab.database.service.SubjectService;
import com.epam.lab.log.MyLogger;
import com.epam.lab.upload.UploadMyFile;

/**
 * Servlet implementation class CreateNewCourse
 */
@MultipartConfig
public class CreateNewCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateNewCourse() {
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
		HttpSession session = request.getSession(true);
		if (isSubject("namesubject", request)) {
			session.setAttribute("errorsubject", "This course exists!");
			session.setAttribute("namesubject", request.getParameter("emailsubject"));
			session.setAttribute("descriptionsubject", request.getParameter("descriptionsubject"));
			request.getRequestDispatcher("pages/workroom.jsp").forward(request,
					response);
			return;
		} else {
			Subject subject = new Subject();
			subject.setName(convertUtf8(request.getParameter("namesubject")));
			subject.setDescription(convertUtf8(request.getParameter("descriptionsubject")));
			Part file = request.getPart("imagesubject");

			if (!file.getSubmittedFileName().isEmpty()) {

				UploadMyFile m = new UploadMyFile();
				String fileName = m.uploadFile(file, getServletContext());
				subject.setUrl(fileName);

			} 
			SubjectService.addSubject(subject);
			session.setAttribute("errorsubject", null);
			response.sendRedirect("/Workroom");

		}
		MyLogger.log.info("Create new course");
	}

	private boolean isSubject(String st, HttpServletRequest request) {
		return SubjectService.getSubject(request.getParameter(st)) != null;
	}
	public String convertUtf8(String st) throws UnsupportedEncodingException{
		return new String(st.getBytes("ISO-8859-1"),"UTF-8");
	}
}
