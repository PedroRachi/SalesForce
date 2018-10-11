<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Vendas</title>

<link href="css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

	<!-- Barra superior com os menus de navegaÃ§Ã£o -->
	<c:import url="Menu.jsp" />
	<!-- Container Principal -->
	<div class="full-bg-img">
		<div class="container flex-center">
			<div class="row pt-5 mt-3">
				<div class="col-md-12">
					<div class="text-center">

						<div class="alert alert-info">
							<h1>
								<strong>${mensagem}</strong>
							</h1>
						</div>

						<div class="success">

							<h2>
								<strong>${mensagem1} <a
									href="controller.do?command=ListarClientesReiniciar">SalesForce</a></strong>


								<br /> <br /> <br /> <a class="btn btn-success btn-xl"
									href="controller.do?command=Relatorio">Gerar Relatorio de
									Vendas</a>

							</h2>
						</div>

						<br /> <br /> <br />

					</div>
				</div>
			</div>

		</div>



	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>

