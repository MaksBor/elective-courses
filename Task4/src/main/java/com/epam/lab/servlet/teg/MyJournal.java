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

import com.epam.lab.database.model.Archive;
import com.epam.lab.database.model.Student;
import com.epam.lab.database.service.ArchiveSrvice;
import com.epam.lab.database.service.LectureService;
import com.epam.lab.database.service.SubjectService;

public class MyJournal extends SimpleTagSupport{

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
		st.append(" <thead>"
            +"<tr>"
              +"<th>id</th>"
              +"<th>"+convertUtf8("class.subject")+"</th>"
              +"<th>"+convertUtf8("class.lecturer")+"</th>"
              +"<th>"+convertUtf8("class.rating")+"</th>"
           +"</tr>"
          +"</thead>"
          +"<tbody>");
 			int count =1;
 			
		for (Archive archive : ArchiveSrvice.getAllArchiveStudetn(((Student) session.getAttribute("user")).getId())) {
			st.append("<tr>"
		 			+"<td>"+(count++)+"</td>"
		 			+"<td>"+SubjectService.getSubject(archive.getSubject().getId()).getName()+"</td>"
		 			+"<td>"+archive.getLector().getName()+" "+archive.getLector().getSurname()+"</td>"
		 			+"<td>"+archive.getRating()+"</td>"
		 			+"</tr>");
		}
		st.append("</tbody>"+"</table>");
		js.print(st.toString());
	}
	
	public String convertUtf8(String st) throws UnsupportedEncodingException{
		return new String(res.getString(st).getBytes("ISO-8859-1"),"UTF-8");
	}
}
