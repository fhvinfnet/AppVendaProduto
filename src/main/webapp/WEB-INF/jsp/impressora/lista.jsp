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
			<strong>Info!</strong> ${mensagem}
		</div>

	  	<h3>Classe: Impressora</h3>
		<h4><a href="/impressora">novo</a></h4>

		<table class="table table-striped">
	    <thead>
	      <tr>
	        <th>ID</th>
	        <th>nome</th>
	        <th>valor</th>
	        <th>codigo</th>
	        <th>wifi</th>
	        <th>sistema de impressao</th>
	        <th>peso</th>
	        <th></th>
	      </tr>
	    </thead>
	    <tbody>
            <c:forEach var="c" items="${listagem}">
              <tr>
                <td>${c.id}</td>
                <td>${c.nome}</td>
                <td>${c.valor}</td>
                <td>${c.codigo}</td>
                <td>${c.wifi}</td>
                <td>${c.sistemaDeImpressao}</td>
                <td>${c.peso}</td>
                <td><a href="/impressora/${c.id}/excluir">excluir</a></td>
              </tr>
            </c:forEach>
	    </tbody>
	  </table>

	</div>
</body>
</html>