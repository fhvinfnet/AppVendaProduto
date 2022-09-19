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
		<h2>Cadastro de celular</h2>
		<form action="/celular/incluir" method="post">
			<c:import url="/WEB-INF/jsp/produto/cadastro.jsp" />

			<div class="mb-3">
				<labe>Camera frontal:</labe>
				<label class="radio-inline">
					<input type="radio" name="cameraFrontal" value="true" checked>Sim
				</label>
				<label class="radio-inline">
					<input type="radio" came="cameraFrontal" value="false">Nao
				</label>
			</div>

			<div class="mb-3">
				<labe>Dimensao:</labe>
				<input type="text" class="form-control" placeholder="Dimensao" name="dimensao">
			</div>

			<div class="mb-3">
				<labe>Memoria:</labe>
				<input type="text" class="form-control" placeholder="Memoria" name="memoia">
			</div>

			<button type="cadastrar" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>