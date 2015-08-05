package com.epam.lab.servlet.teg;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.epam.lab.database.model.Lecture;
import com.epam.lab.database.model.Message;
import com.epam.lab.database.model.Student;
import com.epam.lab.database.service.LectureService;
import com.epam.lab.database.service.MessageService;
import com.epam.lab.database.service.StudentService;

public class ShowMessage extends SimpleTagSupport {

	private Locale loc = new Locale("en", "US");
	private ResourceBundle res;

	@Override
	public void doTag() throws JspException, IOException {
		PageContext context = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		HttpSession session = request.getSession(true);
		JspWriter js = getJspContext().getOut();
		StringBuilder st = new StringBuilder();
		Locale loc1 = (Locale) session.getAttribute("login");
		if (loc1 != null) {
			loc = loc1;
		}
		res = ResourceBundle.getBundle("com.epam.lab.text.i18n", loc);
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");
		if (session.getAttribute("user") instanceof Lecture) {
			Lecture user = (Lecture) session.getAttribute("user");
			List<Message> messages = MessageService.getAllMessage(user.getId());
			Collections.reverse(messages);
			int cout = 1;
			for (Message message : messages) {
				st.append("<tr>" + "<td class=.\"col-xs-2\">" + cout++
						+ "</td>");
				if (message.getSenderlecture()) {
					st.append("<td class=.\"col-xs-2\">"
							+ "Lecture "
							+ LectureService.getLecture(message.getSender())
									.getName()
							+ " "
							+ LectureService.getLecture(message.getSender())
									.getSurname() + "</td>");
				} else {
					st.append("<td class=.\"col-xs-2\">"
							+ "Student "
							+ StudentService.getStudent(message.getSender())
									.getName()
							+ " "
							+ StudentService.getStudent(message.getSender())
									.getSurname() + "</td>");
				}
				st.append("<td class=.\"col-xs-2\">"
						+ convertUtf8(message.getSubject()) + "</td>"

						+ "<td class=.\"col-xs-2\">"
						+ convertUtf8(message.getText()) + "</td>"
						+ "<td class=.\"col-xs-2\">"
						+ format.format(message.getDate()) + "</td>"
						+ "<td class=.\"col-xs-2\"><p>"
						+ "<button type=\"button\" class=\"btn btn-info\""
						+ "data-toggle=\"modal\" data-target=\"#sendMessage\""
						+ "data-whatever=\"");
				if (message.getSenderlecture()) {
					st.append("Lecture" + message.getSender() + "\">");
				} else {
					st.append("Student" + message.getSender() + "\">");
				}
				st.append(convertUtf8(res.getString("message.boton"))
						+ "</button>"
						+ "<a class='btn btn-danger btn-xs' href='/deleteMessage?message="
						+ message.getId()
						+ "'>"
						+ "<span class=\"glyphicon glyphicon-trash\"></span></a>"
						+ "</td>"

						+ "</tr>");
			}

		} else {
			Student user = (Student) session.getAttribute("user");
			List<Message> messages = MessageService.getAllMessage(user.getId());
			Collections.reverse(messages);
			int cout = 1;
			for (Message message : messages) {
				st.append(" <tr>" + "<td class=.\"col-xs-2\">" + cout++
						+ "</td>");
				if (message.getSenderlecture()) {
					st.append("<td class=.\"col-xs-8\">"
							+ "Lecture "
							+ LectureService.getLecture(message.getSender())
									.getName()
							+ " "
							+ LectureService.getLecture(message.getSender())
									.getSurname() + "</td>");
				} else {
					st.append("<td class=.\"col-xs-2\">"
							+ "Student "
							+ StudentService.getStudent(message.getSender())
									.getName()
							+ " "
							+ StudentService.getStudent(message.getSender())
									.getSurname() + "</td>");
				}

				st.append("<td class=.\"col-xs-2\">"
						+ convertUtf8(message.getSubject()) + "</td>"

						+ "<td class=.\"col-xs-2\">"
						+ convertUtf8(message.getText()) + "</td>"
						+ "<td class=.\"col-xs-2\">"
						+ format.format(message.getDate()) + "</td>"
						+ "<td class=.\"col-xs-2\">"
						+ "<button type=\"button\" class=\"btn btn-info\""
						+ "data-toggle=\"modal\" data-target=\"#sendMessage\""
						+ "data-whatever=\"");
				if (message.getSenderlecture()) {
					st.append("Lecture" + message.getSender() + "\">");
				} else {
					st.append("Student" + message.getSender() + "\">");
				}
				st.append(convertUtf8(res.getString("message.boton"))
						+ "</button>"
						+ "<a class='btn btn-danger btn-xs' href='/deleteMessage?message="
						+ message.getId()
						+ "'>"
						+ "<span class=\"glyphicon glyphicon-trash\"></span></a>"
						+ "</td>"

						+ "</tr>");
			}

		}

		js.print(st.toString());
	}

	public String convertUtf8(String st) throws UnsupportedEncodingException {
		return new String(st.getBytes("ISO-8859-1"), "UTF-8");
	}
}
