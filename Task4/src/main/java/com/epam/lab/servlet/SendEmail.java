package com.epam.lab.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.mailer.Mailer;

/**
 * Servlet implementation class SendEmail
 */

public class SendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	HttpSession session = req.getSession();
	String email =req.getParameter("email");
	String message=convertUtf8(req.getParameter("message"));
	String subject =convertUtf8(req.getParameter("subject"));
	try {
		Mailer.sendHardCoded(email,subject,message);
		session.setAttribute("email", true);
		session.setAttribute("statusEmail", "Email send");
	} catch (MessagingException e) {
		session.setAttribute("email", true);
		session.setAttribute("statusEmail", "Error send email");
	}
	resp.sendRedirect(req.getHeader("Referer"));
	
}
public String convertUtf8(String st) throws UnsupportedEncodingException {
	if(st==null|| st.isEmpty()){
		return null;
	}else{
		return new String(st.getBytes("ISO-8859-1"), "UTF-8");
	}
	
}

}
