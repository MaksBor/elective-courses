<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="ex" uri="/WEB-INF/myteg.tld"%>
<header id="header">
	<div class="top-bar">
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-xs-4">
					<c:if test="${user!=null&&type=='student'}">
						<c:if test="${!user.getVerificate()}">
								<div class="col-md-9">
									<div class="alert alert-danger alert-dismissable" role="alert">
										<button type="button" class="close" data-dismiss="alert"
											aria-hidden="true">&times;</button>
										<ex:i18n id="mail.vereficate"/>
									</div>
								</div>
								</c:if>
								</c:if>
				</div>
				<c:if test="${user!=null}">
					
                       
                     
				<div class="col-sm-6 col-xs-8">
				
					<div class="social">
					
						<div class="search">
						
							<form action="/search" role="form">
								<input type="text" name="search" class="search-form" autocomplete="off"
									placeholder="<ex:i18n id="hader.search"/>"> <i
									class="fa fa-search"></i>
							</form>
							
						</div>
						


					</div>
				</div>
				    
                      </c:if>
			</div>
		</div>
		<!--/.container-->
	</div>
	<!--/.top-bar-->

	<nav class="navbar navbar-inverse" role="banner">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
					<c:if test="${user!=null}">
						<h2><span class="label label-info">Hello ${user.getName() }</span></h2>
                       
                         
                      </c:if>
                      <c:if test="${user==null}">
				<a class="navbar-brand" href="index.html"><img
					src="../images/logo.png" alt="logo"></a>
					 </c:if>
			</div>

			<div class="collapse navbar-collapse navbar-right">
			<div class="topmenu">
				<ul class="nav navbar-nav">
					<li ><a href="/home"><ex:i18n
								id="heder.navigation.index" /></a></li>
					<li><a href="/Cours"><ex:i18n
								id="heder.navigation.courses" /></a></li>
								<c:if test="${user!=null}">
					<c:if test="${type=='student'}"><li><a href="/StudentRoom"><ex:i18n
								id="hader.navigation.classrooms" /></a></li>
								</c:if>
								</c:if>
								<c:if test="${user!=null}">
								<c:if test="${type=='lector'||type=='admin'}">
					<li><a href="/Workroom"><ex:i18n
								id="hader.navigation.classrooml" /></a></li>
								</c:if>
								</c:if>
					<li><a href="/aboutus"><ex:i18n
								id="heder.navigation.about_us" /></a></li>
					<li><a href="/contact"><ex:i18n
								id="hader.navigation.contact" /></a></li>

					<c:if test="${user==null}">
						<li><a href="/login"><ex:i18n
									id="hader.navigation.login" /></a></li>
					</c:if>
					<c:if test="${user!=null}"> <li><a href="/Exit"><ex:i18n
									id="hader.navigation.Exit" /></a></li>
					 </c:if>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><ex:i18n id="hader.language" /><i
							class="fa fa-angle-down"></i></a>
						<ul class="dropdown-menu">
							<li><a href="/langu"><ex:i18n
										id="hader.language1" /></a></li>
							<li><a href="/lange"><ex:i18n
										id="hader.language2" /></a></li>
						</ul></li>
						
                     
				</ul>
				</div>
			</div>
			
			<div class="btn-group" role="group"></div>
			
		</div>
		
		<!--/.container-->
	</nav>
	<!--/nav-->

</header>
<!--/header-->