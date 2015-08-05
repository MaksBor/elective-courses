<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="ex" uri="/WEB-INF/myteg.tld"%>
 <div class="col-sm-5 col-md-2 sidebar-offcanvas" id="sidebar" role="navigation">
           
            <ul class="nav nav-sidebar">
              <li class="active"></li>
              <li ><a href="/Workroom"><ex:i18n id="submmenu.lable1" /></a></li>
              <li><a href="/WorkCourse"><ex:i18n id="submmenu.lable2" /></a></li>
              <li><a href="/WorkStudent"><ex:i18n id="submmenu.lable3" /></a></li>
               <li><a href="/WorkJournal"><ex:i18n id="submmenu.lable4" /></a></li>
               <c:if test="${type=='admin' }">
                 <li><a href="/adminroom"><ex:i18n id="submmenu.lable5" /></a></li>
               </c:if>
            
            </ul>

          
        </div><!--/span-->
      