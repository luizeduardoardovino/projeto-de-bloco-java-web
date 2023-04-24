<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<c:import url="/WEB-INF/jsp/header.jsp"></c:import>

		<body>
			<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>

			<div class="container">
				<h2>Cadastro de Erva</h2>
				<form action="/erva/incluir" method="POST">

					<div class="form-group">
						<label>Nome:</label>
						<input type="text" class="form-control" required
							placeholder="Entre com o nome do produto" name="nome">
					</div>

					<div class="form-group">
						<label>Tipo de folha:</label>
						<select class="form-control" name="tipoFolha">
							<option selected="selected">Folha Seca</option>
							<option>Flor</option>
							<option>Raíz</option>
						</select>
					</div>

					<div class="form-group">
						<div class="radio">
							<label>Produto Orgãnico?:</label>
							<label><input type="radio" name="proprio" checked="checked" value="true">Sim</label>
							<label><input type="radio" name="proprio" value="false">Não</label>
						</div>
					</div>

					<div class="form-group">
						<label>Quantidade(em g)</label>
						<input value="0" min="25" step="1" max="70" type="number" class="form-control" required
							placeholder="Entre com a quantidade de peças da decoração" name="qtdErva">
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