<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="ex" uri="/WEB-INF/myteg.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Courses</title>
<jsp:include page="links.jsp" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<section id="recent-works">
		<div class="container">
			<div class="center wow fadeInDown">
				<h2>
					<ex:i18n id="cours.hendler" />
				</h2>
				<p class="lead">

					<ex:i18n id="cours.hendler.description" />
				</p>
			</div>

			<c:forEach items="${listcourse}" var="list">
				<div class="col-xs-12 col-sm-4 col-md-3">
				<div class="recent-work-wrap">
					<img class="img-responsive" src="download/${list.getUrl()}"
						alt="">
					<div class="overlay">
						<div class="recent-work-inner">
							<h3>
								<a href="#">${list.getName()} </a>
							</h3>
							<p>
								${list.getDescription()}
							</p>
							<c:if test="${type=='student'}">
								<c:choose>
									<c:when test="${user.isStudyCours(list.getId())!=true}">
										<a class="preview" href="/ASCours?coursid=${list.getId() }" rel="prettyPhoto"><i
											class="fa fa-eye"></i> <ex:i18n id="cours.registration" /></a>
									</c:when>
									<c:otherwise>
										<p>
											<ex:i18n id="cours.study" />
											<a class="preview" href="/DelCours?coursid=${list.getId()}"
												rel="prettyPhoto"><i class="fa fa-eye"></i> <ex:i18n
													id="cours.delete" /></a>
										</p>
									</c:otherwise>
								</c:choose>
							</c:if>
						</div>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
		<!--/.row-->
		<!--/.container-->
	</section>
	<!--/#recent-works-->
	<jsp:include page="script.jsp" />
	<jsp:include page="foter.jsp" />
</body>
</html>