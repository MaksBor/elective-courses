package com.epam.lab.servlet.teg;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.epam.lab.database.model.Lecture;
import com.epam.lab.database.model.Student;
import com.epam.lab.database.service.LectureService;
import com.epam.lab.database.service.StudentService;

public class AllUsers extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		PageContext context = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		HttpSession session = request.getSession(true);
		JspWriter js = getJspContext().getOut();
		StringBuilder st = new StringBuilder();
		Lecture user = (Lecture) session.getAttribute("user");
	
		List<Lecture>  lecture= LectureService.getAllLecture();
		for (Lecture lecture2 : lecture) {
			st.append(" <tr>"
					+"<td>"+lecture2.getName()+"</td>"
					+ "<td>"+lecture2.getSurname()+"</td>"

					+ "<td>"+lecture2.getEmail()+"</td>"
					+ "<td><span class=\"label label-success\">"+getStatus(lecture2)+"</span>"
							+ "<span class=\"label label-success\">"+isStatus(lecture2.getStatus())+"</span></td>"
					+ "<td><p data-placement=\"top\" data-toggle=\"tooltip\"title=\"Edit\">"
					 +"<button type=\"button\" class=\"btn btn-danger btn-xs\""
						+ "data-toggle=\"modal\" data-target=\"#edite\""
						+ "data-whatever=\""+"Lecture"+lecture2.getId()+"\">"
						+ "<span class=\"glyphicon glyphicon-edit\"></span>"
						+ "</button>"
					+ "	</p></td>"
					+ "<td><p data-placement=\"top\" data-toggle=\"tooltip\""
					+ "title=\"Delete\">"
					+ "<button type=\"button\" class=\"btn btn-danger btn-xs\""
							+ "data-toggle=\"modal\" data-target=\""+isAdmin(lecture2, user)+"\""
							+ "data-whatever=\""+"Lecture"+lecture2.getId()+"\">"
							+ "<span class=\"glyphicon glyphicon-trash\"></span>"
							+ "</button>"
							+ "</p></td>"
							+ "</tr>");
		}
		List<Student> list = StudentService.getAllStudent();
		for (Student student : list) {
			st.append(" <tr>"
					+"<td>"+student.getName()+"</td>"
					+ "<td>"+student.getSurname()+"</td>"

					+ "<td>"+student.getEmail()+"</td>"
					+ "<td><span class=\"label label-success\">Student</span>"
					+ "<span class=\"label label-success\">"+isStatus(student.getStatus())+"</span></td>"
					+ "<td><p data-placement=\"top\" data-toggle=\"tooltip\"title=\"Edit\">"
					+ "<button type=\"button\" class=\"btn btn-danger btn-xs\""
					+ "data-toggle=\"modal\" data-target=\"#editestudent\""
					+ "data-whatever=\""+"Student"+student.getId()+"\">"
					+ "<span class=\"glyphicon glyphicon-edit\"></span>"
					+ "</button>"
					+ "	</p></td>"
					+ "<td><p data-placement=\"top\" data-toggle=\"tooltip\""
					+ "title=\"Delete\">"
					+ "<button type=\"button\" class=\"btn btn-danger btn-xs\""
							+ "data-toggle=\"modal\" data-target=\"#delete\""
							+ "data-whatever=\""+"Student"+student.getId()+"\">"
							+ "<span class=\"glyphicon glyphicon-trash\"></span>"
							+ "</button>"
							+ "</p></td>"
							+ "</tr>");
		}
		js.print(st.toString());
	}
	
	private String getStatus(Lecture lecture){
		
		if(lecture.getAdmin()== true){
			return "Admin";
		}else{
			return "Lecture";
		}
	}
	private String isAdmin(Lecture lecture, Lecture user){
		
		if(lecture.getId() == user.getId()){
			return "";
		}else{
			return "#delete";
		}
	}
	private String isStatus(Boolean status){
		if(status){
			return "Active";
		}
		else{
			return "Banned";
		}
	}
	
}
