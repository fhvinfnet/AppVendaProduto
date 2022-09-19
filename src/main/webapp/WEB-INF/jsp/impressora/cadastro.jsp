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
		<h2>Cadastro de impressora</h2>
		<form action="/impressora/incluir" method="post">
			<c:import url="/WEB-INF/jsp/produto/cadastro.jsp" />

			<div class="mb-3">
				<labe>Tem wifi:</labe>
				<label class="radio-inline">
					<input type="radio" name="wifi" value="true" checked>Sim
				</label>
				<label class="radio-inline">
					<input type="radio" came="wifi" value="false">Nao
				</label>
			</div>

			<div class="mb-3">
				<labe>Sistema de impressao:</labe>
				<input type="text" class="form-control" placeholder="Sistema de impressao" name="sistemaImpressao">
			</div>

			<div class="mb-3">
				<labe>Peso:</labe>
				<input type="text" class="form-control" placeholder="Peso" name="peso">
			</div>

			<button type="cadastrar" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>