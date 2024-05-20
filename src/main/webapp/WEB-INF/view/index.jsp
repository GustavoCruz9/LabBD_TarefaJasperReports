<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tarefa - JasperReports</title>
<link rel="stylesheet" type="text/css"
	href='<c:url value = "./resources/css/style.css"/>'>
</head>

<body>
	<div class="container">
		<form action="index" method="post">
			<div class="form-group">
				<label for="codigo">Produtos com qtd. menor que:</label> <input type="number"
					id="qtd" name="qtd">
			</div>
			<div class="form-group">
				<input type="submit" class="btn-pesquisar" value="Pesquisar"
					id="botao" name="botao">
			</div>
		</form>
		<div class="form-group">
			<input type="submit" class="btn-relatorio" value="Gerar Relatório"
				id="botao" name="botao">
		</div>
	</div>
	
	<div align="center">
			<c:if test="${not empty erro }">
				<h2>
					<b><c:out value="${erro }" /></b>
				</h2>
			</c:if>
		</div>

		<br />
		<div align="center">
			<c:if test="${not empty saida }">
				<h3>
					<b><c:out value="${saida }" /></b>
				</h3>
			</c:if>
		</div>

	<c:if test="${not empty produtos}">
		<table>
			<thead>
				<tr>
					<th>Codigo</th>
					<th>Nome</th>
					<th>Valor</th>
					<th>Qtd. Estoque</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${produtos}">
					<tr>
						<td><c:out value="${p.codigo}"></c:out></td>
						<td><c:out value="${p.nome}"></c:out></td>
						<td><c:out value="${p.valorUnitario}"></c:out></td>
						<td><c:out value="${p.qtdEstoque}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>