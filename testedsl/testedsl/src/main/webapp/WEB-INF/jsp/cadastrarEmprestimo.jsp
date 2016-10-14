<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="springform"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="corpo">
		<h1>Cadastrar Empréstimo</h1>
		
		<springform:form method="post"
			action="${pageContext.request.contextPath}/emprestimo/cadastrar.do"
			modelAttribute="emprestimo">
				<div class="form-group">
					<label for="pessoa">Pessoa:</label>
					<springform:select id="pessoa" path="pessoa.id"
						cssClass="form-control">
						<option value="">selecione</option>
						<c:forEach items="${pessoas}" var="p">
							<option value="${p.idPessoa}">${p.nome}</option>
						</c:forEach>
					</springform:select>
				</div>
				<div class="form-group">
					<label for="paciente">Livro:</label>
					<springform:select id="livro" path="livro.id"
						cssClass="form-control">
						<option value="">selecione</option>
						<c:forEach items="${livros}" var="l">
							<option value="${l.idLivro}">${l.nome}</option>
						</c:forEach>
					</springform:select>
				</div>
				<div class="form-group">
					<label for="data">Data Empréstimo(DD/MM/AAAA):</label> <input id="dataemprestimo"
						type="text" name="dataemprestimo" maxlength="10" class="form-control" />
				</div>
			<input type="submit" value="Gravar" class="btn btn-primary" />
		</springform:form>
	</tiles:putAttribute>
</tiles:insertDefinition>
</html>

