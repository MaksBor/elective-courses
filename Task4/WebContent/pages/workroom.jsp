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
<title>Workroom</title>
<jsp:include page="links.jsp" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<section id="recent-works">


		<div class="container-fluid">

			<div class="row row-offcanvas row-offcanvas-left">

				<jsp:include page="submenul.jsp" />

				<div class="col-sm-9 col-md-9 main">



					<div class="col-md-8">
						<div class="well well-lg">
							<div class="row">
								<div class="col-sm-4">
									<img src="../download/${user.getUrl()}" class="img-thumbnail"
										alt="Cinque Terre" width="204" height="236">
								</div>
								<div class="col-sm-6">
									<p><ex:i18n id="class.name" />: ${user.getName()}</p>
									<p><ex:i18n id="class.surname" />: ${user.getSurname()}</p>
									<p><ex:i18n id="class.email" />: ${user.getEmail()}</p>
									<p><ex:i18n id="class.subject" />: ${user.getSubjectName()}</p>
									<c:if test="${type=='admin' }">
										

									
									<span class="input-group-btn"> <a class="btn btn-info"
										href="#" data-toggle="modal" data-target="#basicModal"><ex:i18n id="workroom.newl" /></a> <a class="btn btn-info" href="#"
										data-toggle="modal" data-target="#basicModalC"><ex:i18n id="workroom.newc" /></a><a class="btn btn-info" href="#"
										data-toggle="modal" data-target="#basicModalD"><ex:i18n id="workroom.dec" /></a>

									</span>
									</c:if>
									<p class="text-danger">${errorsubject}<br>
									</p>
									<p class="text-danger">${errorlector}<br>
									</p>


								</div>

								<div class="modal fade" id="basicModalC" tabindex="-1"
									role="dialog">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button class="close" type="button" data-dismiss="modal">x</button>
												<h2>Create new course</h2>
											</div>
											<div class="modal-body">
												<form action="/NewCourse" method="post"
													class="form-horizontal" accept-charset="UTF-8"
													enctype="multipart/form-data" role="form">

													<div class="form-group">
														<div class="col-sm-10">

															<input type="text" required="required"
																class="form-control" id="text" name="namesubject" pattern="^[^<>/{}]+$"
																placeholder="<ex:i18n id="login.name" />"
																value=${namesubject}>
														</div>
													</div>
													<div class="form-group">
													<div class="col-sm-10">
														<label>Description</label>
														<textarea name="descriptionsubject" id="message" class="form-control" rows="2" value=${descriptionsubject}></textarea>
														</div>
													</div>
													
													<div class="form-group">
														<div class="col-sm-10">
															<input type="file" required="required" class="filestyle" 
																name="imagesubject">
														</div>
													</div>

													<div class="form-group">
														<div class="col-sm-offset-0 col-sm-10">
															<button type="submit" class="btn btn-success">
																<ex:i18n id="login.butom2" />
															</button>
														</div>
													</div>

												</form>
											</div>

										</div>
									</div>
								</div>
								<div class="modal fade" id="basicModalD" tabindex="-1"
									role="dialog">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button class="close" type="button" data-dismiss="modal">x</button>
												<h2>Delete</h2>
											</div>
											<div class="modal-body">
												<form action="/delcourse" method="post"
													class="form-horizontal" accept-charset="UTF-8"
													 role="form">

													<div class="form-group">
														<div class="col-sm-10">
															<select class="form-control" required="required"
																id="sel2" name="subjectfirst">
																<option selected value=""><c:out
																		value=""></c:out></option>
																<c:forEach items="${listsubject}" var="list">
																	<option value="${list.getId()}">${list.getName()}</option>
																</c:forEach>


															</select>
														</div>
													</div>

													<div class="form-group">
														<div class="col-sm-offset-0 col-sm-10">
															<button type="submit" class="btn btn-success">
																Delete
															</button>
														</div>
													</div>

												</form>
											</div>

										</div>
									</div>
								</div>



								<div class="modal fade" id="basicModal" tabindex="-1"
									role="dialog">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button class="close" type="button" data-dismiss="modal">x</button>
												<h2>Create new lecturer</h2>
											</div>
											<div class="modal-body">
												<form action="/NewLector" method="post"
													class="form-horizontal" accept-charset="UTF-8"
													enctype="multipart/form-data" role="form">
													<div class="form-group">
														<div class="col-sm-10">

															<input type="email" required="required" pattern="^[^<>/{}]+$"
																class="form-control" id="email" name="emaillector"
																placeholder="<ex:i18n id="login.email" />"
																value=${emaillector}>
														</div>
													</div>
													<div class="form-group">
														<div class="col-sm-10">
															<input type="password" required="required" pattern="^[^<>/{}]+$"
																class="form-control" id="pwd" name="passwordlector"
																placeholder="<ex:i18n id="login.password" />">
														</div>
													</div>
													<div class="form-group">
														<div class="col-sm-10">
															<input type="text" required="required" pattern="^[^<>/{}]+$"
																class="form-control" id="text" name="namelector"
																placeholder="<ex:i18n id="login.name" />"
																value=${namelector}>
														</div>
													</div>
													<div class="form-group">
														<div class="col-sm-10">
															<input type="text" required="required" pattern="^[^<>/{}]+$"
																class="form-control" id="text" name="surnamelector"
																placeholder="<ex:i18n id="login.surname" />"
																value=${surnamelector}>
														</div>
													</div>

													<div class="form-group">
														<div class="col-sm-10">
															<select class="form-control" required="required"
																id="sel2" name="objectlector">
																<option selected value="${objectlector}"><c:out
																		value="${objectlector}"></c:out></option>
																<c:forEach items="${listobject}" var="list">
																	<option value="${list.getId()}">${list.getName()}</option>
																</c:forEach>


															</select>
														</div>
													</div>

													<div class="form-group">
														<div class="col-sm-10">
															<input type="file" required="required" class="filestyle" 
																name="imagelector">
														</div>
													</div>

													<div class="form-group">
														<div class="col-sm-offset-0 col-sm-10">
															<button type="submit" class="btn btn-success">
																<ex:i18n id="login.butom2" />
															</button>
														</div>
													</div>

												</form>
											</div>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>

		</div>
	</section>
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
									<textarea name="message" id="message" required="required"
										class="form-control" rows="3"></textarea>
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