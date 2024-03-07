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
										<label for="name">name</label>
										<form:input type="text" path="name" class="form-control"
											id="name" value="${user.name}" />
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

									<div class="form-group">
										<label for="price">Password</label>
										<form:input type="password" path="password"
											class="form-control" id="price" placeholder="Enter email"
											value="${user.password}" />
										<div class="mt-2">
											<form:errors path="password" class="text-danger"></form:errors>
										</div>
									</div>

									<div class="row form-group">
										<div class="col-lg-12 form-group">
											<div class="margin-right-15 templatemo-inline-block">
												<form:radiobutton path="admin" id="admin" value="true" />
												<label for="admin" class="font-weight-400"><span></span>Admin</label>
											</div>
											<div class="margin-right-15 templatemo-inline-block">
												<form:radiobutton path="admin" id="u" value="false" />
												<label for="u" class="font-weight-400"><span></span>User</label>
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
									<div class="form-group">
										<a href="/admin/user" class="btn templatemo-blue-button">New</a>
										<button type="submit" class="btn templatemo-blue-button">Save</button>
										<button formaction="/admin/user/delete/${user.name}"
											class="btn templatemo-blue-button btn-bg-danger ${edit ? '' : 'disabled'}">Delete</button>
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
									<td><a href="" class="white-text templatemo-sort-by">name
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
							<c:forEach var="item" items="${page.content}">
								<tr>
									<td>${item.name}</td>
									<td>${item.firstName} ${item.lastName}</td>
									<td>${item.phoneNumber}</td>
									<td>${item.email}</td>
									<td>${item.admin ? 'Admin' : 'User'}</td>
									<td>${item.active ? 'Active' : 'Inactive'}</td>
									<td><a
										href="/admin/user?btnEdit=&name=${item.name}"
										class="templatemo-edit-btn">Edit</a></td>
									<td><a
										href="/admin/user?btnDel=&name=${item.name}"
										class="templatemo-edit-btn">Delete</a></td>
								</tr>
							</c:forEach>
							<tbody>
						</table>
						<div class="pagination-wrap">
							<ul class="pagination">
								<c:choose>
									<c:when test="${page.totalPages == 1}">
										<li><a href="/admin/user/page?page=${page.number}">${page.number + 1}</a></li>
									</c:when>
									<c:when test="${page.number + 1 == 1 && page.totalPages != 1}">
										<li><a href="/admin/user/page?page=${page.number}">${page.number + 1}</a></li>
										<li><a href="/admin/user/page?page=${page.number + 1}">${page.number + 2}</a></li>
										<li><a href="/admin/user/page?page=${page.number + 1}"
											aria-label="Next"><span aria-hidden="true"><i
													class="fa fa-caret-right"></i></span></a></li>
									</c:when>
									<c:when test="${page.number + 1 == page.totalPages}">
										<li><a href="/admin/user/page?page=${page.number - 1}"
											aria-label="Previous"><span aria-hidden="true"><i
													class="fa fa-caret-left"></i></span></a></li>
										<li><a href="/admin/user/page?page=${page.number - 1}">${page.number}</a></li>
										<li><a href="/admin/user/page?page=${page.number}">${page.number + 1}</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="/admin/user/page?page=${page.number - 1}"
											aria-label="First"><span aria-hidden="true"><i
													class="fa fa-caret-left"></i></i></span></a></li>
										<li><a href="/admin/user/page?page=${page.number - 1}">${page.number}</a></li>
										<li><a href="/admin/user/page?page=${page.number}">${page.number + 1}</a></li>
										<li><a href="/admin/user/page?page=${page.number + 1}">${page.number + 2}</a></li>
										<li><a href="/admin/user/page?page=${page.number + 1}"
											aria-label="Next"><span aria-hidden="true"><i
													class="fa fa-caret-right"></i></span></a></li>
									</c:otherwise>
								</c:choose>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- JS -->
	<%@ include file="/layout/admin/_java-script.jsp"%>
</body>
</html>