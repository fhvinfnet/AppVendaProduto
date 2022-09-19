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
    <c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container mt-3">
		<h2>Cadastro de cliente</h2>
		<form action="/cliente/incluir" method="post">
			<div class="mb-3 mt-3">
				<label>Nome:</label>
				<input type="text" class="form-control" placeholder="Nome" name="nome">
			</div>
			<div class="mb-3">
				<labe>Cpf:</labe>
				<input type="text" class="form-control" placeholder="Cpf" name="cpf">
			</div>
			<div class="mb-3 mt-3">
				<label>Email:</label>
				<input type="email" class="form-control" placeholder="Email" name="email">
			</div>
			<button type="cadastrar" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>