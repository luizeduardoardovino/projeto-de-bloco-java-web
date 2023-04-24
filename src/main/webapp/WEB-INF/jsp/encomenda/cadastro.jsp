<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<c:import url="/WEB-INF/jsp/header.jsp"></c:import>

		<body>
			<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>

			<div class="container">
				<h2>Cadastro de Encomendas</h2>

				<form action="/encomenda/incluir" method="POST">

					<div class="form-group">
						<c:if test="${not empty clientes}">
							<label>Cliente:</label>
							<select class="form-control" name="cliente.id" required>
								<option></option>
								<c:forEach var="cli" items="${clientes}">
									<option value="${cli.id}">${cli.nome}</option>
								</c:forEach>
							</select>
						</c:if>
						<c:if test="${empty clientes}">
							<c:set var="botao" value="disabled" />
							<label>Cliente: não existem registros cadastrados!!!</label>
						</c:if>
					</div>




					<div class="form-group">
						<div class="row">
							<div class="col-xs-6">
								<c:if test="${not empty produtos}">
									<label>Produto:</label>(selecione os itens)
									<c:forEach var="art" items="${produtos}">
										<div class="checkbox">
											<label class="form-check-label" >
												<input name="idProduto" type="checkbox" class="group-required" value="${art.id}">${art.nome}
											</label>
										</div>
									</c:forEach>
								</c:if>
								<c:if test="${empty produtos}">
									<c:set var="botao" value="disabled" />
									<label>Produto: não há itens nesta encomenda!!!</label>
								</c:if>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label>Observação:</label>
						<input type="text" class="form-control" placeholder="Entre com as observações"
							value="${encomenda.observacao}" name="observacao">
					</div>

					<br />
					<div class="form-group">
						<label>Usuario do cadastro:</label>
						<span>${user.nome}</span>
					</div>

					<button type="submit" ${botao} class="btn btn-default">Cadastrar</button>
				</form>
			</div>

		</body>

		</html>