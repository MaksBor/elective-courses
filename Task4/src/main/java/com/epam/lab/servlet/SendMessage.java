package com.epam.lab.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.database.model.Lecture;
import com.epam.lab.database.model.Message;
import com.epam.lab.database.model.Student;
import com.epam.lab.database.service.MessageService;

/**
 * Servlet implementation class SendMessage
 */

public class SendMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		System.out.println(MessageService.getMessage(2));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String messag = request.getParameter("message");
		String subject = request.getParameter("subject");
		String sender = request.getParameter("receiver");
		Message message = new Message();
		message.setText(messag);
		message.setSubject(subject);
		message.setDate(new Date());
		message.setReciver(Integer.parseInt(sender.replaceAll("[a-zA-Z]", "")));
		if(session.getAttribute("user") instanceof Lecture){
			Lecture lecture = (Lecture) session.getAttribute("user"); 
			message.setSender(lecture.getId());
			message.setSenderlecture(true);
			
		}else{
			Student student =(Student)session.getAttribute("user"); 
			message.setSender(student.getId());
			message.setSenderlecture(false);
			
		}
		
		if(sender.replaceAll("[0-9]", "").equals("Student")){
			message.setReciverlecture(false);
			
		}else{
			message.setReciverlecture(true);
			
		}
		MessageService.addMessage(message);
		response.sendRedirect(request.getHeader("Referer"));
	}

}
