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
	<c:set var="ativaBotao" value="" />
    <c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container mt-3">
		<h2>Cadastro de venda</h2>
		<form action="/venda/incluir" method="post">
			<div class="mb-3">
				<labe>Descricao:</labe>
				<input type="text" class="form-control" placeholder="Descricao da venda" name="descricao">
			</div>

			<div class="mb-3">
				<c:if test="${not empty clientes}">
					<labe>Cliente:</labe>
					<select name="cliente" class="form-control" id="sel1">
						<c:forEach var="c" items="${clientes}">
							<option name="${c.id}">${c.nome}</option>
						</c:forEach>
					</select>
				</c:if>
				<c:if test="${empty clientes}">
					<labe>Sem clientes cadastrados:</labe>
					<c:set var="ativaBotao" value="disabled" />
				</c:if>
			</div>

			<div class="mb-3">
				<c:if test="${not empty produtos}">
					<labe>Produtos:</labe>
					<c:forEach var="p" items="${produtos}">
						<div class="checkbox">
							<label><input type="checkbox" name="vendas" value="${p.nome}">${p.nome}</label>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty produtos}">
					<labe>Sem produtos cadastrados</labe>
					<c:set var="ativaBotao" value="disabled" />
				</c:if>
			</div>

			<button ${ativaBotao} type="cadastrar" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>