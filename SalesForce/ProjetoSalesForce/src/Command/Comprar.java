package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Vendas;
import Service.VendasService;

public class Comprar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		Vendas venda = new Vendas();

		long id_produto = Long.parseLong(request.getParameter("id_produto"));
		int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
		String valor_venda = request.getParameter("valor");

		int qtd_produto = Integer.parseInt(request.getParameter("qtd_produto"));
		if (qtd_produto <= 0) {

			request.setAttribute("mensagem3", "A partir de uma unidade");

		} else {

			venda.setSku_produto(id_produto);
			venda.setCodigo_cliente(id_cliente);

			double valorVenda = Double.parseDouble(valor_venda) * qtd_produto;

			venda.setValor_venda(valorVenda);
			venda.setQtd_produto(qtd_produto);

			VendasService serviceVenda = new VendasService();
			request.setAttribute("mensagem", "Compra efetuada com sucesso!!!");
			request.setAttribute("mensagem1", " Compra");

			serviceVenda.guardarVenda(venda);

			RequestDispatcher view = null;

			view = request.getRequestDispatcher("index.jsp");

			view.forward(request, response);

		}

	}
}
