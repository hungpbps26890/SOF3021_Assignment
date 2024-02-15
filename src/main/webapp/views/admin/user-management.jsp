<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/layout/common/_tablib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Visual Admin Dashboard - Manage Category</title>
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
								<form action="/admin/user/search" class="templatemo-login-form" method="post">
									<div class="form-group">
										<input type="text" class="form-control" placeholder="Keyword" name="keyword">
									</div>
									<div class="form-group">
										<button type="submit" class="btn templatemo-blue-button">Search</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!-- Second row ends -->

				<div class="templatemo-content-widget no-padding">
					<c:choose>
						<c:when test="${pages.size == 1}">
							<span>1 result</span>
						</c:when>
						<c:otherwise>
							<span>${pages.totalElements} result</span>
						</c:otherwise>
					</c:choose>	
					<div class="panel panel-default table-responsive">
						<table
							class="table table-striped table-bordered templatemo-user-table">
							<thead>
								<tr>
									<td><a href="" class="white-text templatemo-sort-by">#
											<span class="caret"></span>
									</a></td>
									<td>
										<a href="" class="white-text templatemo-sort-by">User Name<span class="caret"></span></a>
									</td>
									<td>First Name</td>
									<td>Last Name</td>
									<td>Phone Number</td>
									<td>Email</td>
									<td>Admin</td>
									<td>Active</td>
									<td>Edit</td>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${pages.content}"
								varStatus="i" begin="0"
									end="${pages.size - 1}">
									<tr>
										<td>${i.index + 1}</td>
										<td>${item.username}</td>
										<td>${item.firstName}</td>
										<td>${item.lastName}</td>
										<td>${item.phoneNumber}</td>
										<td>${item.email}</td>
										<td>${item.admin ? 'Admin' : 'User'}</td>
										<td>${item.active ? 'Active' : 'Inactive'}</td>
										<td><a href="/admin/user/edit?username=${item.username}">Edit</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="pagination-wrap">
					<ul class="pagination">
						<c:choose>
							<c:when test="${pages.totalPages == 1}">
								<li><a href="/admin/user/page?p=${pages.number}">${pages.number + 1}</a></li>			
							</c:when>
							<c:when test="${pages.number + 1 == 1 && pages.totalPages != 1}">
								<li><a href="/admin/user/page?p=${pages.number}">${pages.number + 1}</a></li>
								<li><a href="/admin/user/page?p=${pages.number + 1}">${pages.number + 2}</a></li>
								<li><a href="/admin/user/page?p=${pages.number + 1}" aria-label="Next"><span aria-hidden="true"><i class="fa fa-play"></i></span></a></li>
							</c:when>
							<c:when test="${pages.number + 1 == pages.totalPages}">
								<li><a href="/admin/user/page?p=${pages.number - 1}" aria-label="Previous"><span aria-hidden="true"><i class="fa fa-play"></i></span></a></li>
								<li><a href="/admin/user/page?p=${pages.number - 1}">${pages.number}</a></li>
								<li><a href="/admin/user/page?p=${pages.number}">${pages.number + 1}</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="/admin/user/page?p=${pages.number - 1}" aria-label="First"><span aria-hidden="true"><i class="fa fa-play"></i></span></a></li>
								<li><a href="/admin/user/page?p=${pages.number - 1}">${pages.number}</a></li>
								<li><a href="/admin/user/page?p=${pages.number}">${pages.number + 1}</a></li>
								<li><a href="/admin/user/page?p=${pages.number + 1}">${pages.number + 2}</a></li>
								<li><a href="/admin/user/page?p=${pages.number + 1}" aria-label="Next"><span aria-hidden="true"><i class="fa fa-play"></i></span></a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			
				<div class="templatemo-flex-row flex-content-row">
					<div class="col-1">
						<div class="panel panel-default margin-10">
							<div class="panel-heading">
								<h2 class="text-uppercase">User Management</h2>
							</div>
							<div class="panel-body">
								<form:form action="/admin/user/save" class="templatemo-login-form"
									modelAttribute="user" method="post">
									<div class="form-group">
										<label for="name">User Name</label>
										<form:input path="username" class="form-control" value="${user.username}" />
									</div>
									<div class="mt-2">
										<form:errors path="username" class="text-danger"></form:errors>
									</div>
									<div class="form-group">
										<label for="name">First Name</label>
										<form:input path="firstName" class="form-control" value="${user.firstName}" />
									</div>
									<div class="mt-2">
										<form:errors path="firstName" class="text-danger"></form:errors>
									</div>
									<div class="form-group">
										<label for="name">Last Name</label>
										<form:input path="lastName" class="form-control" value="${user.lastName}" />
									</div>
									<div class="mt-2">
										<form:errors path="lastName" class="text-danger"></form:errors>
									</div>
									<div class="form-group">
										<label for="name">Phone Number</label>
										<form:input path="phoneNumber" class="form-control" value="${user.phoneNumber}" />
									</div>
									<div class="mt-2">
										<form:errors path="phoneNumber" class="text-danger"></form:errors>
									</div>
									<div class="form-group">
										<label for="name">Email</label>
										<form:input path="email" class="form-control" value="${user.email}" />
									</div>
									<div class="mt-2">
										<form:errors path="email" class="text-danger"></form:errors>
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
						              <div class="form-group">
										<label for="category" class="control-label templatemo-block">Admin</label>
										<form:select class="form-control" path="admin">
											<form:option value="${user.admin ? true : false}"
												itemLabel="name" />
											<form:option value="${user.admin ? false : true}"
												itemLabel="name" />
										</form:select>
									  </div>
									
									<div class="mt-2">
										<span class="text-primary">${message}</span>
									</div>
									<div class="form-group">
										<button type="submit" class="btn templatemo-blue-button">New</button>
										<button formaction="/admin/user/save"
											class="btn templatemo-blue-button btn-bg-danger ${edit ? '' : 'disabled'}">Update</button>
										<a href="/admin/user" class="btn templatemo-white-button">Cancel</a>
									</div>
								</form:form>
							</div>
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