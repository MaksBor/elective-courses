package com.epam.lab.servlet.teg;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class I18nClass extends SimpleTagSupport {

	private String id;
	private Locale loc = new Locale("en", "US");
	private ResourceBundle res = ResourceBundle.getBundle(
			"com.epam.lab.text.i18n", loc);

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public void doTag() throws JspException, IOException {

		PageContext context = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		HttpSession session = request.getSession(true);
		if(request.getCookies()!=null){
		Cookie[] cookie= request.getCookies();
		String language = null;
		String country = null;
		
		for (Cookie cookie2 : cookie) {
			if(cookie2.getName().equals("localLengeuge")){
				language = cookie2.getValue();
			}
			else if(cookie2.getName().equals("localCountry")){
				country = cookie2.getValue();
				loc =new Locale(language,country);
				session.setAttribute("login", loc);
				break;
			}
			
		}
		}
		Locale loc1 = (Locale) session.getAttribute("login");
		
		if (loc1 != null) {
			loc = loc1;
		}

		res = ResourceBundle.getBundle("com.epam.lab.text.i18n", loc);

		JspWriter js = getJspContext().getOut();
		js.print(new String(res.getString(getId()).getBytes("ISO-8859-1"),
				"UTF-8"));
	}

}
