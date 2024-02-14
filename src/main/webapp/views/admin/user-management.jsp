<%@ include file="/layout/common/_tablib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Visual Admin Dashboard - Manage User</title>
<%@ include file="/layout/admin/_head.jsp"%>
</head>
<body>

	<div class="templatemo-flex-row">
		<!-- Left column -->
		<%@ include file="/layout/admin/_left-column.jsp"%>
		<!-- Main content -->
		<div class="templatemo-content col-1 light-gray-bg">

			<div class="templatemo-content-container">
				<div class="templatemo-flex-row flex-content-row">
					<div class="col-1">
						<div class="panel panel-default margin-10">
							<div class="panel-heading">
								<h2 class="text-uppercase">User Management</h2>
							</div>
							<div class="panel-body">
								<form:form action="/admin/user" class="templatemo-login-form"
									modelAttribute="user" method="post"
									enctype="multipart/form-data">

									<div class="form-group">
										<label for="name">Username</label> <input type="text"
											name="username" class="form-control" id="name"
											value="${user.username}" disabled="disabled">
									</div>

									<div class="row">
										<div class="form-group col-lg-6">
											<label for="name">First Name</label>
											<form:input type="text" path="firstName" class="form-control"
												id="name" placeholder="Enter firstname"
												value="${user.firstName}" />
											<div class="mt-2">
												<form:errors path="firstName" class="text-danger" />
											</div>
										</div>

										<div class="form-group col-lg-6">
											<label for="name">Last Name</label>
											<form:input type="text" path="lastName" class="form-control"
												id="price" placeholder="Enter lastname"
												value="${user.lastName}" />
											<div class="mt-2">
												<form:errors path="lastName" class="text-danger" />
											</div>
										</div>
									</div>

									<div class="form-group">
										<label for="price">Phone Number</label>
										<form:input type="text" path="phoneNumber"
											class="form-control" id="price"
											placeholder="Enter phone number" value="${user.phoneNumber}" />
										<div class="mt-2">
											<form:errors path="phoneNumber" class="text-danger"></form:errors>
										</div>
									</div>

									<div class="form-group">
										<label for="price">Email</label>
										<form:input type="text" path="email" class="form-control"
											id="price" placeholder="Enter email" value="${user.email}" />
										<div class="mt-2">
											<form:errors path="email" class="text-danger"></form:errors>
										</div>
									</div>

									<div class="row form-group">
										<div class="col-lg-12 form-group">
											<div class="margin-right-15 templatemo-inline-block">
												<form:radiobutton path="admin" id="active" value="true" />
												<label for="active" class="font-weight-400"><span></span>Admin</label>
											</div>
											<div class="margin-right-15 templatemo-inline-block">
												<form:radiobutton path="admin" id="inactive" value="false" />
												<label for="inactive" class="font-weight-400"><span></span>User</label>
											</div>
										</div>
									</div>

									<div class="row form-group">
										<div class="col-lg-12 form-group">
											<div class="margin-right-15 templatemo-inline-block">
												<form:radiobutton path="active" id="active" value="true" />
												<label for="active" class="font-weight-400"><span></span>Active</label>
											</div>
											<div class="margin-right-15 templatemo-inline-block">
												<form:radiobutton path="active" id="inactive" value="false" />
												<label for="inactive" class="font-weight-400"><span></span>Inactive</label>
											</div>
										</div>
									</div>

									<div class="mt-2">
										<span class="text-primary">${message}</span>
									</div>

									<div>
										<button class="btn btn-primary">New</button>
										<button class="btn btn-primary">Save</button>
										<button class="btn btn-primary">Delete</button>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
				<!-- Second row ends -->

				<div class="templatemo-content-widget no-padding">
					<div class="panel panel-default table-responsive">
						<table
							class="table table-striped table-bordered templatemo-user-table">
							<thead>
								<tr>
									<td><a href="" class="white-text templatemo-sort-by">Username
											<span class="caret"></span>
									</a></td>
									<td><a href="" class="white-text templatemo-sort-by">Name
											User<span class="caret"></span>
									</a></td>
									<td><a href="" class="white-text templatemo-sort-by">PhoneNumber<span
											class="caret"></span>
									</a></td>
									<td><a href="" class="white-text templatemo-sort-by">Email<span
											class="caret"></span>
									</a></td>
									<td><a href="" class="white-text templatemo-sort-by">Role<span
											class="caret"></span></a>
									<td><a href="" class="white-text templatemo-sort-by">Status<span
											class="caret"></span>
									</a></td>
									<td>Edit</td>
									<td>Delete</td>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${users}">
									<tr>
										<td>${item.username}</td>
										<td>${item.firstName} ${item.lastName}</td>
										<td>${item.phoneNumber}</td>
										<td>${item.email}</td>
										<td>${item.admin ? 'Admin' : 'User'}</td>
										<td>${item.active ? 'Active' : 'Inactive'}</td>
										<td><a href="/admin/drink?btnEdit=&id=${item.username}"
											class="templatemo-edit-btn">Edit</a></td>
										<td><a href="/admin/drink?btnDel=&id=${item.username}"
											class="templatemo-edit-btn">Delete</a></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>


				<div class="pagination-wrap">
					<ul class="pagination">
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#" aria-label="Next"> <span
								aria-hidden="true"><i class="fa fa-play"></i></span>
						</a></li>
					</ul>
				</div>

			</div>
		</div>
	</div>

	<!-- JS -->
	<%@ include file="/layout/admin/_java-script.jsp"%>
</body>
</html>