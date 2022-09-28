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
	  	<h2>AppVendaProduto</h2>
	  	<p>Projeto de gestão de vendas de produtos</p>

		<div class="alert ${tipo}">
			<strong>Info!</strong> Indicates a neutral informative change or action.
		</div>

	  	<h3>Classe: Cliente</h3>
		<h4><a href="/cliente">novo</a></h4>
		<table class="table table-striped">
	    <thead>
	      <tr>
	        <th>ID</th>
	        <th>nome</th>
	        <th>cpf</th>
	        <th>email</th>
	        <th>usuario</th>
	        <th></th>
	      </tr>
	    </thead>
	    <tbody>
            <c:forEach var="c" items="${listagem}">
              <tr>
                <td>${c.id}</td>
                <td>${c.nome}</td>
                <td>${c.cpf}</td>
                <td>${c.email}</td>
                <td>${c.usuario.email}</td>
                <td><a href="/cliente/${c.id}/excluir">excluir</a></td>
              </tr>
            </c:forEach>
	    </tbody>
	  </table>

	</div>
</body>
</html>