package com.epam.lab.servlet.teg;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.epam.lab.database.model.ClassRoom;
import com.epam.lab.database.model.Lecture;
import com.epam.lab.database.model.Student;
import com.epam.lab.database.service.ClassService;
import com.epam.lab.database.service.StudentService;
import com.epam.lab.database.service.SubjectService;

public class MyStudent extends SimpleTagSupport {

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
		
				
		st.append(" <table class='table table-striped'>");
		st.append("<thead>"
            +"<tr>"
              +"<th>id</th>"
              +"<th>"+convertUtf8("class.name")+"</th>"
              +"<th>"+convertUtf8("class.surname")+"</th>"
              +"<th>"+convertUtf8("class.email")+"</th>"
              +"<th>"+convertUtf8("class.country")+"</th>"
              +"<th>"+convertUtf8("class.adress")+"</th>"
              +"<th>"+convertUtf8("class.date")+"</th>"
              +"<th>"+convertUtf8("class.subject")+"</th>"
              +"<th>"+convertUtf8("class.rating")+"</th>"
           +"</tr>"
          +"</thead>"
          +"<tbody>");
 			int count =1;
 						
		for (ClassRoom cours : ClassService.getAllClassRoomForLecurer(((Lecture) session.getAttribute("user")).getId())) {
			Student student =cours.getStudent();
			st.append("	<form action='/SetRating' method='get' id='myform"+student.getId()+"'></form>");
			st.append("<tr>"
		 			+"<td>"+(count++)+"</td>"
		 			+"<td>"+student.getName()+"</td>"
		 			+"<td>"+student.getSurname()+"</td>"
		 			+"<td>"+student.getEmail()+"</td>"
		 			+"<td>"+student.getCountry()+"</td>"
		 			+"<td>"+student.getAdress()+"</td>"
		 			+"<td>"+student.getDate()+"</td>"
		 			+"<td>"+cours.getSubject().getName() +"</td>"
		 			+"<td>"+" <input  type=\"text\" class=\"form-control\" name=\"rating\" form=\"myform"+student.getId()+"\" size=2px>"
		 			
		 					+ "<input type=\"hidden\" name=\"coursid\" form=\"myform"+student.getId()+"\" value="+cours.getId() +">"
		 			+"</td>"
		 			+"<td>"+"<button type=\"submit\" class=\"btn btn-info\" form=\"myform"+student.getId()+"\">rating</button>"+"</td>"
		 			+"<td>"+"<a class='btn btn-info' href='/DeleteStudent?coursid="+cours.getId()+"'>Delete</a>"
		 						
		 			
		 +"</td>"
		 			+"</tr>");
		}
		st.append("</tbody>"+"</table>");
		js.print(st.toString());
	}
	public String convertUtf8(String st) throws UnsupportedEncodingException{
		return new String(res.getString(st).getBytes("ISO-8859-1"),"UTF-8");
	}
}
