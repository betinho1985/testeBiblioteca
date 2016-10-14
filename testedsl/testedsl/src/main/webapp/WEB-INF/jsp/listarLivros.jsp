<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="corpo">
		<h1>Listar Livros</h1>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Escritor</th>
					<th>Ano Edição</th>
					<th>Classificação</th>
					<th>Excluir</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="l" items="${livros}">
					<tr>
						<td>${l.idLivro}</td>
						<td>${l.nome}</td>
						<td>${l.escritor}</td>
						<td>${l.anoEdicao}</td>
						<td>${l.classificacao}</td>
						<td><a
							href="${pageContext.request.contextPath}/livro/excluir.do?idLivro=${l.idLivro}">
								<input type="button" value="Excluir" class="btn btn-danger" />
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</tiles:putAttribute>
</tiles:insertDefinition>

</html>

