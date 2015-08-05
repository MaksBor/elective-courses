<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="ex" uri="/WEB-INF/myteg.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact</title>
<jsp:include page = "links.jsp"/>
</head>
<body>
<jsp:include page ="header.jsp"/>
<section id="contact-info">
        <div class="center">      
          
            <h2><ex:i18n id="contact.heder" /></h2>
           
        </div>
        <div class="gmap-area">
            <div class="container">
                <div class="row">
                    <div class="col-sm-5 text-center">
                        <div class="gmap">
                           <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d10304.38331560854!2d23.668660545480705!3d49.78426280930478!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1suk!2sua!4v1432808631211" width="600" height="450" frameborder="0" style="border:0"></iframe>
                        </div>
                    </div>

                    <div class="col-sm-7 map-content">
                        <ul class="row">
                            <li class="col-sm-6">
                                <address>
                                    <h4><ex:i18n id="contact.office" /></h4>
                                    <p><ex:i18n id="contact.street" /><br>
                                    <ex:i18n id="contact.city" /></p>
                                    <p><ex:i18n id="contact.phone" /><br>
                                    <ex:i18n id="contact.email" /></p>
                                </address>

                              
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>  <!--/gmap_area -->
 <jsp:include page ="script.jsp"/>
 <jsp:include page ="foter.jsp"/>
</body>
</html>