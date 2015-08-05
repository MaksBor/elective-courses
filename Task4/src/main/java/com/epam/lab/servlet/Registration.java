package com.epam.lab.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.epam.lab.database.model.Student;
import com.epam.lab.database.service.StudentService;
import com.epam.lab.mailer.Mailer;
import com.epam.lab.md5.MD5Hashing;
import com.epam.lab.upload.UploadMyFile;

/**
 * Servlet implementation class Registration
 */
@MultipartConfig
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {

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

		if (!isNull("email", request) && isStudent("email", request)) {
			session.setAttribute("error", "This email adresses used!");
			session.setAttribute("emails", request.getParameter("emails"));
			request.getRequestDispatcher("pages/login.jsp").forward(request,
					response);
			return;
		}
		if (isNull("emails", request) || isNull("password", request)
				|| isNull("name", request) || isNull("surname", request)
				|| isNull("country", request) || isNull("adress", request)
				|| isNull("gender", request) || isNull("date", request)) {
			session.setAttribute("error", "Incorect data!");
			session.setAttribute("emails", request.getParameter("emails"));
			session.setAttribute("password", request.getParameter("password"));
			session.setAttribute("name",
					convertUtf8(request.getParameter("name")));
			session.setAttribute("surname",
					convertUtf8(request.getParameter("surname")));
			session.setAttribute("country",
					convertUtf8(request.getParameter("country")));
			session.setAttribute("adress",
					convertUtf8(request.getParameter("adress")));
			session.setAttribute("gender",
					convertUtf8(request.getParameter("gender")));
			session.setAttribute("date",
					convertUtf8(request.getParameter("date")));
			session.setAttribute("file",
					convertUtf8(request.getParameter("file")));

			request.getRequestDispatcher("pages/login.jsp").forward(request,
					response);
			return;

		} else {
			Student st = new Student();
			st.setEmail(request.getParameter("emails"));
			st.setPassword(MD5Hashing.getHesh(request.getParameter("password")));
			st.setName(convertUtf8(request.getParameter("name")));
			st.setSurname(convertUtf8(request.getParameter("surname")));
			st.setCountry(convertUtf8(request.getParameter("country")));
			st.setAdress(convertUtf8(request.getParameter("adress")));
			st.setGender(convertUtf8(request.getParameter("gender")));

			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
				Date date = sdf.parse(request.getParameter("date"));
				st.setDate(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Part file = request.getPart("image");

			if (!file.getSubmittedFileName().isEmpty()) {

				UploadMyFile m = new UploadMyFile();
				String fileName = m.uploadFile(file, getServletContext());
				st.setUrl(fileName);

			} else {
				st.setUrl("1.jpg");
			}

			StudentService.addStudent(st);
			
			try {
				
				Mailer.sendHardCoded(st.getEmail(), "verification", "<a href=\"http://localhost:8080/verification?idStudent="+StudentService.getStudent(st.getEmail()).getId()+"\">Verificate</a>");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("user",
					StudentService.getStudent(st.getEmail()));
			session.setAttribute("type", "student");
			request.getRequestDispatcher("pages/index.jsp").forward(request,
					response);

		}

	}

	private boolean isNull(String st, HttpServletRequest request) {
		return request.getParameter(st) == null
				|| request.getParameter(st).isEmpty();
	}

	private boolean isStudent(String st, HttpServletRequest request) {
		return StudentService.getStudent(request.getParameter(st)) != null;
	}

	public String convertUtf8(String st) throws UnsupportedEncodingException {
		if(st==null|| st.isEmpty()){
			return null;
		}else{
			return new String(st.getBytes("ISO-8859-1"), "UTF-8");
		}
		
	}

}
