<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="ex" uri="/WEB-INF/myteg.tld"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css"
	href="../css/dataTables.bootstrap.css">
<link rel="stylesheet" type="text/css" href="../css/Style.css">
<script type="text/javascript" src="../js/jquery-1.10.2.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../js/dataTables.bootstrap.js"></script>
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
								<div class="col-sm-4">
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
								</div>

							</div>




						</div>
					</div>

				</div>
				<div style="clear: both;">&nbsp;</div>
				<div class="container">
					<div class="body-content">


						<table id="tblContact" class="table table-striped table-bordered"
							cellspacing="0" style="width: 100%;">
							<thead>
								<tr>
									<th>№</th>
									<th><ex:i18n id="message.sender" /></th>
									<th><ex:i18n id="message.subject" /></th>
									<th><ex:i18n id="message.message" /></th>
									<th><ex:i18n id="message.date" /></th>
									<th></th>
								</tr>
							</thead>

							<tbody>
								<ex:message />
							</tbody>
						</table>



					</div>
					<hr />
				</div>

			</div>

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
	<script type="text/javascript">
		$(document).ready(function() {
			$('#tblContact').dataTable({
				"iDisplayLength" : 4,
				"lengthMenu" : [ 4, 10, 25, 50, 100 ]
			});
		});
	</script>







</body>
</html>