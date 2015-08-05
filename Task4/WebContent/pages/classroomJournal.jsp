<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="ex" uri="/WEB-INF/myteg.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Classroom</title>
<jsp:include page="links.jsp" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<section id="recent-works">


		<div class="container-fluid">

			<div class="row row-offcanvas row-offcanvas-left">

				<jsp:include page="submenu.jsp" />

				<div class="col-sm-9 col-md-8 main">



					<div class="col-md-8">
						<div class="well well-lg">
							<div class="row">
								<ex:myjournal />
							</div>
						</div>
					</div>

				</div>
			</div>

		</div>
	</section>

	<jsp:include page="script.jsp" />
</body>
</html>