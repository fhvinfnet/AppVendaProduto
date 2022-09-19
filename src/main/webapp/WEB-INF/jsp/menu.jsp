<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-sm bg-light navbar-light">
  <div class="container-fluid">
	<ul class="navbar-nav">
	  <li class="nav-item">
		<a class="nav-link active" href="/">Home</a>
	  </li>

	  <c:if test="${not empty user}">
	  <li class="nav-item">
		<a class="nav-link" href="/usuario/lista">Usuario</a>
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
	  </c:if>
	</ul>
	<ul class="navbar-nav">
		<c:if test="${empty user}">
			<li class="nav-item">
			  <a class="nav-link" href="/usuario">Signup</a>
			</li>
			<li class="nav-item">
			  <a class="nav-link" href="/login">Login</a>
			</li>
		</c:if>

		<c:if test="${not empty user}">
			<li class="nav-item">
				<a class="nav-link" href="/logout">Logout</a>
			</li>
		</c:if>
	</ul>

  </div>

</nav>