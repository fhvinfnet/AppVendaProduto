<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<meta charset="UTF-8">
	<title>AppVendaProduto</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>

	<div class="container mt-3">
		<h2>Stacked form</h2>
		<form action="/login" method="post">
			<div class="mb-3 mt-3">
				<label>Email:</label>
				<input type="email" class="form-control" placeholder="Email" name="email">
			</div>
			<div class="mb-3">
				<labe>Senha:</labe>
				<input type="password" class="form-control" placeholder="Senha" name="senha">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>