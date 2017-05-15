<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<div class="h2">Manage Supplier</div>
		<c:if test="${isAdminClickedManageSupplierEdit=='true'}">
			<div id="UpdateSupplier">
				<div class="h3">Update Supplier</div>

				<form class="form-horizontal" action="manage_supplier_update"
					method="">
					<div class="form-group">
						<label class="control-label col-sm-3" for="id">Supplier
							Id:</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="id"
								placeholder="Enter Supplier Id" name="id"
								value="${selectedSupplier.id}" readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="name">Supplier
							Name:</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="name"
								placeholder="Enter Supplier Name" name="name"
								value="${selectedSupplier.name}" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="description">Supplier
							Description:</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="description"
								placeholder="Enter Supplier Description" name="description"
								value="${selectedSupplier.description}" required>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-9">
							<button type="submit" class="btn btn-primary">Update
								Supplier</button>
						</div>
					</div>
				</form>
			</div>
		</c:if>

		<c:if test="${!isAdminClickedManageSupplierEdit=='true'}">
			<div id="CreateSupplier">
				<div class="h3">Create Supplier</div>

				<form class="form-horizontal" action="manage_supplier_add">
					<div class="form-group">
						<label class="control-label col-sm-3" for="id">Supplier
							Id:</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="id"
								placeholder="Enter Supplier Id" name="id" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="name">Supplier
							Name:</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="name"
								placeholder="Enter Supplier Name" name="name" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="description">Supplier
							Description:</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="description"
								placeholder="Enter Supplier Description" name="description"
								required>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-9">
							<button type="submit" class="btn btn-success">Create
								Supplier</button>
						</div>
					</div>
				</form>
			</div>
		</c:if>




		<div id="ShowSupplier">
			<div class="h3">Show Suppliers</div>
			<table class="table table-bordered">
				<thead>
					<tr>
						<td>Supplier Id</td>
						<td>Supplier Name</td>
						<td>Supplier Description</td>
						<td>Action</td>
					</tr>
				</thead>
				<c:forEach var="supplier" items="${supplierList}">
					<tr>
						<td>${supplier.id}</td>
						<td>${supplier.name}</td>
						<td>${supplier.description}</td>
						<td><a href="manage_supplier_delete/${supplier.id}">
								<button type="button" class="btn btn-danger">
									<span class="glyphicon glyphicon-trash"></span> Delete
								</button>
							</a> <a href="manage-supplier-edit/${supplier.id}">
								<button type="button" class="btn btn-info">
									<span class="glyphicon glyphicon-pencil"></span> Edit
								</button>
							</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>


</body>
</html>