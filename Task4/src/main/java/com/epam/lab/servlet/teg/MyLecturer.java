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
import com.epam.lab.database.service.LectureService;
import com.epam.lab.database.service.SubjectService;


public class MyLecturer extends SimpleTagSupport{

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
	
 			
		for (ClassRoom cours : ClassService.getAllClassRoomForStudent(((Student) session.getAttribute("user")).getId())) {
			Lecture lectur= cours.getLector();
			st.append(" 	<div class='col-md-8'>");
			st.append(" <div class='well well-lg'>"
	            +"<div class='row'>"
	              +"<div class='col-sm-4'>"
	              +"<img src='../download/"+lectur.getUrl()+"' class='img-thumbnail'"
	              +"	alt='Cinque Terre' width='204' height='236'>"
	              +"</div>"
	              +"<div class='col-sm-6'>"
	           +"<p>"+convertUtf8("class.name")+": "+lectur.getName()+"</p>"
	            +"<p>"+convertUtf8("class.surname")+": "+lectur.getSurname()+"</p>"
	             +"<p>"+convertUtf8("class.email")+": "+lectur.getEmail()+"</p>"
	              +"<p>"+convertUtf8("class.subject")+": "+cours.getSubject().getName()+"</p>"
	               + "<button type=\"button\" class=\"btn btn-info\""
						+ "data-toggle=\"modal\" data-target=\"#sendMessage\""
						+ "data-whatever=\""+"Lecture"+lectur.getId()+"\">"
						+"Send message"
						+ "</button>"
	          +"</div>"
	          +"	</div>"
			+"</div>"
		+"</div>");
		}
		
		js.print(st.toString());
	}
	
	public String convertUtf8(String st) throws UnsupportedEncodingException{
		return new String(res.getString(st).getBytes("ISO-8859-1"),"UTF-8");
	}
}
