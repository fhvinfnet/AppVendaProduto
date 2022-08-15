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

	  <h3>Classe: Impressora</h3>
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Atributo</th>
	        <th>Tipo</th>
	        <th>Descrição</th>
	      </tr>
	    </thead>
	    <tbody>
	      <tr>
	        <td>wifi</td>
	        <td>boolean</td>
	        <td>Indicativo se tem wifi ou não</td>
	      </tr>
	      <tr>
	        <td>sistemaDeImpressao</td>
	        <td>String</td>
	        <td>Descrição do sistema de impressão</td>
	      </tr>
	      <tr>
	        <td>peso</td>
	        <td>float</td>
	        <td>Peso da impressora</td>
	      </tr>
	    </tbody>
	  </table>

	</div>
</body>
</html>