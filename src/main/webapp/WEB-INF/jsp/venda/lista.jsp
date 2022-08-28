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

    <nav class="navbar navbar-expand-sm bg-light navbar-light">
      <div class="container-fluid">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link active" href="/">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/celular/lista">Celular</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/notebook/lista">Notebook</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/impressora/lista">Impressora</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/produto/lista">Produto</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/cliente/lista">Cliente</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/venda/lista">Venda</a>
          </li>
        </ul>
      </div>
    </nav>

	<div class="container mt-3">
	  <h2>AppVendaProduto</h2>
	  <p>Projeto de gestão de vendas de produtos</p>

	  <h3>Classe: Venda</h3>
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>ID</th>
	        <th>descricao</th>
	        <th>data</th>
	        <th>web</th>
	        <th>clinte</th>
	        <th>produto</th>
	        <th></th>
	      </tr>
	    </thead>
	    <tbody>
            <c:forEach var="v" items="${listagem}">
              <tr>
                <td>${v.id}</td>
                <td>${v.descricao}</td>
                <td>${v.data}</td>
                <td>${v.web}</td>
                <td>${v.cliente.nome}</td>
                <td>${v.produtos.size()}</td>
                <td><a href="/venda/${v.id}/excluir">excluir</a></td>
              </tr>
            </c:forEach>
	    </tbody>
	  </table>

	</div>
</body>
</html>