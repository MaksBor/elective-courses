<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="ex" uri="/WEB-INF/myteg.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Workroom</title>
<jsp:include page="links.jsp" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<section id="recent-works">


		<div class="container-fluid">

			<div class="row row-offcanvas row-offcanvas-left">

				<jsp:include page="submenul.jsp" />

				<div class="col-sm-9 col-md-10 main">



					<div class="col-md-20">
						<div class="well well-lg">
							<div class="row">
								<h2 class="sub-header">Student</h2>
								<c:if test="${mesegerating!=null}">
								<div class="col-md-4">
									<div class="alert alert-danger alert-dismissable" role="alert">
										<button type="button" class="close" data-dismiss="alert"
											aria-hidden="true">&times;</button>
										${mesegerating}
									</div>
								</div>
								</c:if>
								

								<div class="table-responsive">
									<ex:mystudent />
								</div>
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