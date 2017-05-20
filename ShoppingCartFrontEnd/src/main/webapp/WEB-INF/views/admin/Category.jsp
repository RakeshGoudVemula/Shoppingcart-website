<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style type="text/css">
</style>
</head>
<body>
	<div class="container">
		<div class="h2">Manage Categories</div>

		<!-- Create Category -->
		<c:if test="${!isAdminClickedManageCategoryEdit=='true'}">
			<!-- Add Category -->
			<div id="CreateCategory">
				<div class="h3">Create Category</div>

				<form class="form-horizontal" action="manage_category_add">
					<div class="form-group">
						<label class="control-label col-sm-3" for="id">Category
							Id:</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="id"
								placeholder="Enter Category Id" name="id" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="name">Category
							Name:</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="name"
								placeholder="Enter Category Name" name="name" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="description">Category
							Description:</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="description"
								placeholder="Enter Category Description" name="description"
								required>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-9">
							<button type="submit" class="btn btn-success">Create
								Category</button>
						</div>
					</div>
				</form>
			</div>
		</c:if>

		<!-- Update Category -->
		<c:if test="${isAdminClickedManageCategoryEdit=='true'}">
			<div id="UpdateCategory">
				<div class="h3">Update Category</div>

				<form class="form-horizontal" action="manage_category_update"
					method="">

					<div class="form-group">
						<label class="control-label col-sm-3" for="id">Category
							Id:</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="id"
								placeholder="Enter Category Id" name="id"
								value="${selectedCategory.id}" required readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="name">Category
							Name:</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="name"
								placeholder="Enter Category Name" name="name"
								value="${selectedCategory.name}" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for=description>Category
							Description:</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="description"
								placeholder="Enter Category Description" name="description"
								value="${selectedCategory.description}">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-9">
							<button type="submit" class="btn btn-primary">Update
								Category</button>
						</div>
					</div>
				</form>
			</div>
		</c:if>
		<!-- Show Category -->
		<div id="ShowCategories">
			<div class="h3">Show Categories</div>
			<table class="table table-bordered">
				<thead>
					<tr>
						<td>Category Id</td>
						<td>Category Name</td>
						<td>Category Description</td>
						<td>Action</td>
					</tr>
				</thead>
				<c:forEach var="category" items="${categoryList}">
					<tr>
						<td>${category.id}</td>
						<td>${category.name}</td>
						<td>${category.description}</td>
						<td><a href="manage_category_delete/${category.id}">
								<button type="button" class="btn btn-danger">
									<span class="glyphicon glyphicon-trash"></span> Delete
								</button>
							</a> <a href="manage-category-edit/${category.id}">
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
















