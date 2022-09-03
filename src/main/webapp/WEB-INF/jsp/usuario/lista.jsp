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
	  <h2>AppVendaProduto</h2>
	  <p>Projeto de gestão de vendas de produtos</p>

      <h3>Usuarios</h3>
      <table class="table table-striped">
        <thead>
          <tr>
            <th>nome</th>
            <th>e-mail</th>
            <th>senha</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
            <c:forEach var="u" items="${listagem}">
              <tr>
                <td>${u.nome}</td>
                <td>${u.email}</td>
                <td>${u.senha}</td>
                <td><a href="/usuario/${u.email}/excluir">excluir</a></td>
              </tr>
            </c:forEach>
        </tbody>
      </table>

	</div>
</body>
</html>