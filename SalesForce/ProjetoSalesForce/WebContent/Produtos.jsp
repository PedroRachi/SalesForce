<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Buscar Produtos</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>

<body>

	<!-- Modal -->
	<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog"
		aria-labelledby="modalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Fechar">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalLabel">Quantidade</h4>
				</div>
				<div class="modal-body">
					<div class="modal-footer">
						<form action="controller.do" method="post">
							<div class="row">
								<div class="form-group col-md-6">
									<label for="razaoSocial">Quantidade de produtos</label>
									<p>
										<strong>${mensagem3}</strong>
									</p>
									<input type="text" class="form-control"
										data-target="#quantidade" name="qtd_produto" id="qtd_produto"
										value="${quantidade}" />
								</div>
							</div>
							<c:forEach var="produtos" items="${lista}">
								<input type="hidden" value="${id_cliente}" name="id_cliente" />
								<input type="hidden" value="${produtos.id_produto}"
									name="id_produto" />

								<input type="hidden" value="${produtos.valor}" name="valor" />
							</c:forEach>
							<input type="hidden" name="id" id="id_excluir" />
							<button type="submit" class="btn btn-primary" name="command"
								value="Comprar">Sim</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">N&atilde;o</button>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal -->

	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<form action="controller.do" method="post">
			<div id="top" class="row">
				<div class="col-md-6">
					<h2>Produtos</h2>
				</div>

				<div class="col-md-6">
					<div class="input-group h2">
						<input name="data[search]" class="form-control" id="search"
							type="text"
							placeholder="Pesquisar Produtos (deixe vazio para trazer todos)">
						<span class="input-group-btn">
							<button class="btn btn-primary" type="submit" name="command"
								value="ListarProdutosBuscar">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</div>

			</div>
			<!-- /#top -->
		</form>
		<hr />
		<c:if test="${not empty lista}">
			<div id="list" class="row">

				<div class="table-responsive col-md-12">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Codigo Do Poduto</th>
								<th>Nome</th>
								<th>Preço</th>
								<th class="actions">Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="produtos" items="${lista}">
								<tr>

									<td>${produtos.id_produto}</td>
									<td>${produtos.nome_produto}</td>
									<td>R$ ${produtos.valor}</td>
									<td class="actions">

										<button id="btn${produtos.id_produto}%>" type="button"
											class="btn btn-success btn-xl" data-toggle="modal"
											data-target="#delete-modal"
											data-empresa="${produtos.id_produto}">Selecionar</button>

									</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>

				</div>
			</div>
			<!-- /#list -->

			<div id="bottom" class="row">
				<div class="col-md-12">
					<!-- paginação ainda não foi implementada -->
					<ul class="pagination">
						<li class="disabled"><a>&lt; Anterior</a></li>
						<li class="disabled"><a>1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li class="next"><a href="#" rel="next">Próximo &gt;</a></li>
					</ul>
					<!-- /.pagination -->
				</div>
			</div>
		</c:if>
		<!-- /#bottom -->
	</div>
	<!-- /#main -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$("#delete-modal").on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget); //botao que disparou a modal
			var recipient = button.data('quantidade');
			$("#qtd_produto").val(recipient);
		});
	</script>

</body>

</html>