<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="ex" uri="/WEB-INF/myteg.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="links.jsp" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<script
						src="../js/jquery.min.js"></script>
					<script src="../js/bootstrap.min.js"></script>
	<section id="recent-works">


		<div class="container-fluid">

			<div class="row row-offcanvas row-offcanvas-left">

				<jsp:include page="submenu.jsp" />

				<div class="col-sm-9 col-md-8 main">
					<ex:mylecturer />
				</div>
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
													class="form-control" required="required">

											</div>
											<div class="form-group">
												<label>Message *</label>
												<textarea name="message" id="message" required="required" pattern="^[^<>/{}]+$"
													class="form-control" rows="3"></textarea>
											</div>
											<div class="form-groupm">
												<input type="hidden" name="receiver" class="form-control" pattern="^[^<>/{}]+$"
													id="recipient-name">
											</div>
											<div class="form-group">
												<button type="submit" class="btn btn-info"
													required="required">Message</button>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript">
		$('#sendMessage').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget) // Button that triggered the modal
			var recipient = button.data('whatever') // Extract info from data-* attributes
			var modal = $(this)
			modal.find('.form-groupm input').val(recipient)
		})
	</script>
	<jsp:include page="script.jsp" />

</body>
</html>