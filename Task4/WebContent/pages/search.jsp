<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="ex" uri="/WEB-INF/myteg.tld"%>
<!DOCTYPE html>
<html>
<head>
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>
<jsp:include page="links.jsp" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<section id="contact-info">
		<div class="center">

			<h2>
				<ex:i18n id="search.heder" />
			</h2>
		</div>
		<div class="col-sm-9 col-md-8 main">



			<c:forEach items="${searchstudent}" var="user">
				<div class="col-md-8">
					<div class="well well-lg">
						<div class="row">
							<div class="col-sm-4">
							<h2>Student</h2>
								<img src="../download/${user.getUrl()}" class="img-thumbnail"
									alt="Cinque Terre" width="204" height="236">
							</div>

							<div class="col-sm-6">
								<p>
									<ex:i18n id="class.name" />
									: ${user.getName()}
								</p>
								<p>
									<ex:i18n id="class.surname" />
									: ${user.getSurname()}
								</p>
								<p>
									<ex:i18n id="class.country" />
									: ${user.getCountry()}
								</p>
								<p>
									<ex:i18n id="class.adress" />
									: ${user.getAdress()}
								</p>
								<p>
									<ex:i18n id="class.gender" />
									: ${user.getGender()}
								</p>
								<p>
									<ex:i18n id="class.date" />
									: ${user.getDate()}
								</p>
								<p>
									<ex:i18n id="class.email" />
									: ${user.getEmail()}
								</p>
								<p>
									<button type="button" class="btn btn-info" data-toggle="modal"
										data-target="#sendMessage"
										data-whatever="Student${user.getId()}">Send message</button>
								</p>
							</div>

						</div>



					</div>

				</div>
			</c:forEach>
			<c:forEach items="${searchlecture}" var="user">
				<div class="col-md-8">
					<div class="well well-lg">
						<div class="row">
							<div class="col-sm-4">
							<h2>Lecture</h2>
								<img src="../download/${user.getUrl()}" class="img-thumbnail"
									alt="Cinque Terre" width="204" height="236">
							</div>

							<div class="col-sm-6">
								<p>
									<ex:i18n id="class.name" />
									: ${user.getName()}
								</p>
								<p>
									<ex:i18n id="class.surname" />
									: ${user.getSurname()}
								</p>

								<p>
									<ex:i18n id="class.date" />
									: ${user.getSubject()}
								</p>
								<p>
									<ex:i18n id="class.email" />
									: ${user.getEmail()}
								</p>
								<p>
									<button type="button" class="btn btn-info" data-toggle="modal"
										data-target="#sendMessage"
										data-whatever="Lecture${user.getId()}">Send message</button>
								</p>
							</div>

						</div>



					</div>

				</div>
			</c:forEach>
		</div>


	</section>
	<div class="modal fade" id="sendMessage" tabindex="-1" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" type="button" data-dismiss="modal">x</button>
					<h4 class="modal-title" id="myModalLabel">Send message</h4>
				</div>
				<div class="modal-body">

					<form id="main-contact-form" class="contact-form"
						accept-charset="UTF-8" name="contact-form" method="post"
						action=/sendMesage role="form">
						<div class="row">

							<div class="col-sm-10">
								<div class="form-group">
									<label>Subject *</label> <input type="text" name="subject"
										pattern="^[^<>/{}]+$" class="form-control"
										required="required">

								</div>
								<div class="form-group">
									<label>Message *</label>
									<textarea name="message" id="message" required="required"
										pattern="^[^<>/{}]+$" class="form-control" rows="3"></textarea>
								</div>
								<div class="form-groupm">
									<input type="hidden" name="receiver" class="form-control"
										id="recipient-name">
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-info" required="required">Message</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$('#sendMessage').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget) // Button that triggered the modal
			var recipient = button.data('whatever') // Extract info from data-* attributes
			var modal = $(this)
			modal.find('.form-groupm input').val(recipient)
		})
	</script>
	<!--/gmap_area -->
	<jsp:include page="script.jsp" />
	>
</body>
</html>