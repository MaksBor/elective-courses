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


		

				<jsp:include page="submenul.jsp" />

				<div class="col-sm-9 col-md-8 main">
					<script
						src="../js/jquery.min.js"></script>
					<script src="../js/bootstrap.min.js"></script>

					<div class="container">
						<div class="row">


							<div class="col-md-12">
								<h4><ex:i18n id="workroom.allusers" /></h4>


								<div class="table-responsive">


									<table id="mytable" class="table table-bordred table-striped">

										<thead>


											<th><ex:i18n id="class.name" /></th>
											<th><ex:i18n id="class.surname" /></th>
											<th><ex:i18n id="class.email" /></th>
											<th><ex:i18n id="workroom.status" /></th>
											<th><ex:i18n id="workroom.edit" /></th>
											<th><ex:i18n id="workroom.delete" /></th>
										</thead>
										<tbody>
											<ex:all />



										</tbody>

									</table>



								</div>
							</div>
						</div>


						<div class="modal fade" id="edite" tabindex="-1" role="dialog"
							aria-labelledby="edit" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">
											<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
										</button>
										<h4 class="modal-title custom_align" id="Heading">Edit
											Your Detail</h4>
									</div>
									<form action="/eduser" method="post">
										<div class="modal-body">

											<div class="form-group">
												<input class="form-control " type="text" name="name"
													placeholder="Name">
											</div>
											<div class="form-group">
												<input class="form-control " type="text" name="surname"
													placeholder="Surname">
											</div>
											<div class="form-group">

												<input class="form-control " type="text" name="password"
													placeholder="Password">
											</div>
											<div class="form-group">

												<input class="form-control " type="email" name="email"
													placeholder="Email">
											</div>
											<div class="form-group">
												<div class="col-sm-10">
													<label class="radio-inline"><input type="radio"
														name="admin" value="false">Lecture</label> <label
														class="radio-inline"><input type="radio"
														name="admin" value="true">Admin</label>
												</div>
											</div>
											<div class="form-groupse">
												<input type="hidden" name="updates" class="form-control"
													id="recipient-name">
											</div>
										</div>
										<div class="modal-footer ">
											<button type="submit" class="btn btn-warning btn-lg"
												style="width: 100%;">
												<span class="glyphicon glyphicon-ok-sign"></span> Update
											</button>
										</div>
									</form>
								</div>
								<!-- /.modal-content -->
							</div>
							<!-- /.modal-dialog -->
						</div>

						<div class="modal fade" id="editestudent" tabindex="-1"
							role="dialog" aria-labelledby="edit" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">
											<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
										</button>
										<h4 class="modal-title custom_align" id="Heading">Edit
											Your Detail</h4>
									</div>
									<form action="/eduser" method="post">
										<div class="modal-body">

											<div class="form-group">
												<input class="form-control " type="text" name="name"
													placeholder="Name">
											</div>
											<div class="form-group">
												<input class="form-control " type="text" name="surname"
													placeholder="Surname">
											</div>
											<div class="form-group">

												<input class="form-control " type="text" name="password"
													placeholder="Password">
											</div>
											<div class="form-group">

												<input class="form-control " type="email" name="email"
													placeholder="Email">
											</div>
											
											<div class="form-groupse">
												<input type="hidden" name="updates" class="form-control"
													id="recipient-name">
											</div>
										</div>
										<div class="modal-footer ">
											<button type="submit" class="btn btn-warning btn-lg"
												style="width: 100%;">
												<span class="glyphicon glyphicon-ok-sign"></span> Update
											</button>
										</div>
									</form>
								</div>
								<!-- /.modal-content -->
							</div>
							<!-- /.modal-dialog -->
						</div>

						<div class="modal fade" id="delete" tabindex="-1" role="dialog"
							aria-labelledby="edit" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>



									</div>

									<div class="modal-body">
										<div class="alert alert-danger">
											<span class="glyphicon glyphicon-warning-sign"></span> Are
											you sure you want to banned this user?
										</div>
										<form action="/bannedusers" method="post">
											<div class="form-group">
												<input type="hidden" name="delete" class="form-control"
													id="recipient-name">
											</div>

											<div class="sub">
												<button type="submit" class="btn btn-success">
													<span class="glyphicon glyphicon-ok-sign"></span> Yes
												</button>
												<button type="button" class="btn btn-default"
													data-dismiss="modal">
													<span class="glyphicon glyphicon-remove"></span> No
												</button>

											</div>
										</form>
									</div>
								</div>
							</div>
							<!-- /.modal-dialog -->
						</div>




					</div>
				</div>
	</section>
	<script type="text/javascript">
		$('#delete').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget)
			var recipient = button.data('whatever')
			var modal = $(this)
			modal.find('.modal-body input').val(recipient);
		})
	</script>

	<script type="text/javascript">
		$('#edite').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget) // Button that triggered the modal
			var recipient = button.data('whatever') // Extract info from data-* attributes
			var modal = $(this)
			
			modal.find('.form-groupse input').val(recipient)
		})
	</script>
	<script type="text/javascript">
		$('#editestudent').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget) // Button that triggered the modal
			var recipient = button.data('whatever') // Extract info from data-* attributes
			var modal = $(this)
			
			modal.find('.form-groupse input').val(recipient)
		})
	</script>
	<jsp:include page="script.jsp" />

</body>
</html>