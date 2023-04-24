<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<c:import url="/WEB-INF/jsp/header.jsp"></c:import>

		<body>
			<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>

			<div class="container">
				<h2>Cadastro de Frutas</h2>
				<form action="/fruta/incluir" method="POST">

					<div class="form-group">
						<label>Nome:</label>
						<input type="text" class="form-control" required
							placeholder="entre com o nome da fruta" name="nome">
					</div>

					<div class="form-group">
						<label>Grau de maturação:</label>
						<select class="form-control" name="tipo">
							<option selected="selected">madura</option>
							<option>meio madura</option>
							<option>verde</option>
						</select>
					</div>

					<div class="form-group">
						<label>Quantidade(em kg)</label>
						<input value="0" min="25" step="1" max="70" type="number" class="form-control" required
							placeholder="Entre com a quantidade,em kg, da fruta" name="qtdFruta">
					</div>


					<div class="form-group">
						<label>Valor base:</label>
						<input  type="number" min="0.00" step="0.01" class="form-control" required
							value="0.00" name="valorBase">
					</div>

					<br/>
					<div class="form-group">
						<label>Usuario do cadastro:</label>
						<span>${user.nome}</span>
					</div>

					<button type="submit" class="btn btn-default">Cadastrar</button>
				</form>
			</div>

		</body>

		</html>