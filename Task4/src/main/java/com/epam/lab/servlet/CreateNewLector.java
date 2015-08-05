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

import com.epam.lab.database.model.Lecture;
import com.epam.lab.database.service.LectureService;
import com.epam.lab.database.service.SubjectService;
import com.epam.lab.log.MyLogger;
import com.epam.lab.md5.MD5Hashing;
import com.epam.lab.upload.UploadMyFile;

/**
 * Servlet implementation class CreateNewLector
 */
@MultipartConfig
public class CreateNewLector extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewLector() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		if (isLecture("emaillector", request)) {
			session.setAttribute("errorlector", "This email adresses used!");
			session.setAttribute("emaillector", request.getParameter("email"));
			session.setAttribute("namelector", request.getParameter("namelector"));
			session.setAttribute("surnamelector", request.getParameter("surnamelector"));
			session.setAttribute("objectlector", request.getParameter("objectlector"));
			request.getRequestDispatcher("pages/workroom.jsp").forward(request,
					response);
			return;
		}else {
			Lecture lecture = new Lecture();
			lecture.setEmail(request.getParameter("emaillector"));
			lecture.setPassword(MD5Hashing.getHesh(request.getParameter("passwordlector")));
			lecture.setName(convertUtf8(request.getParameter("namelector")));
			lecture.setSurname(convertUtf8(request.getParameter("surnamelector")));
			lecture.setSubject(SubjectService.getSubject(Integer.parseInt(request.getParameter("objectlector"))));
			

			Part file = request.getPart("imagelector");

			if (!file.getSubmittedFileName().isEmpty()) {

				UploadMyFile m = new UploadMyFile();
				String fileName = m.uploadFile(file, getServletContext());
					lecture.setUrl(fileName);
				 
			}else {
				lecture.setUrl("1.png");
			}
			LectureService.addLecture(lecture);
			response.sendRedirect("/Workroom");

		}
		MyLogger.log.info("Creat new lecturer");
	}

	private boolean isLecture(String st, HttpServletRequest request) {
		return LectureService.getLecture(request.getParameter(st)) != null;
	}
	public String convertUtf8(String st) throws UnsupportedEncodingException{
		return new String(st.getBytes("ISO-8859-1"),"UTF-8");
	}
}
