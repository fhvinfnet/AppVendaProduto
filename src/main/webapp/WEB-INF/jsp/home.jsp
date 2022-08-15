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
            <a class="nav-link" href="#/cliente/lista">Cliente</a>
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
	        <th>Atributo</th>
	        <th>Tipo</th>
	        <th>Descrição</th>
	      </tr>
	    </thead>
	    <tbody>
	      <tr>
	        <td>descricao</td>
	        <td>String</td>
	        <td>Descrição da venda</td>
	      </tr>
	      <tr>
	        <td>data</td>
	        <td>LocalDateTime</td>
	        <td>Data de realização da venda</td>
	      </tr>
	      <tr>
	        <td>web</td>
	        <td>boolean</td>
	        <td>Indicativo para uma venda online ou presencial</td>
	      </tr>
	    </tbody>
	  </table>

	  <h3>Classe: Notebook</h3>
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
	        <td>ssd</td>
	        <td>boolean</td>
	        <td>Indicativo se tem ssd ou não</td>
	      </tr>
	      <tr>
	        <td>configuracao</td>
	        <td>String</td>
	        <td>Descrição da configuracao do notebook</td>
	      </tr>
	      <tr>
	        <td>polegadas</td>
	        <td>float</td>
	        <td>numero de polegadas</td>
	      </tr>
	    </tbody>
	  </table>

      <h3>Classe: Celular</h3>
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
            <td>cameraFrontal</td>
            <td>boolean</td>
            <td>Indicativo se tem camera frontal ou não</td>
          </tr>
          <tr>
            <td>dimensão</td>
            <td>String</td>
            <td>Decritivo das dimensões do aparelho</td>
          </tr>
          <tr>
            <td>memória</td>
            <td>float</td>
            <td>Quantidade de memória</td>
          </tr>
        </tbody>
      </table>

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

	  <h3>Classe: Cliente</h3>
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
	        <td>nome</td>
	        <td>String</td>
	        <td>Nome do cliente</td>
	      </tr>
	      <tr>
	        <td>cpf</td>
	        <td>String</td>
	        <td>Cpf do cliente</td>
	      </tr>
	      <tr>
	        <td>email</td>
	        <td>String</td>
	        <td>Email do cliente</td>
	      </tr>
	    </tbody>
	  </table>

	  <h3>Classe: Produto</h3>
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
	        <td>nome</td>
	        <td>String</td>
	        <td>Nome do produto</td>
	      </tr>
	      <tr>
	        <td>valor</td>
	        <td>float</td>
	        <td>Valor do produto</td>
	      </tr>
	      <tr>
	        <td>codigo</td>
	        <td>int</td>
	        <td>Código do produto</td>
	      </tr>
	    </tbody>
	  </table>

	</div>
</body>
</html>