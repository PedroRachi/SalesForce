package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Produto;

import Service.ProdutoService;

public class ListarProdutosBuscar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
		request.setAttribute("id_cliente", id_cliente);
		ProdutoService prod = new ProdutoService();
		ArrayList<Produto> lista = null;
		HttpSession session = request.getSession();

		lista = prod.listarProdutos();

		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request.getRequestDispatcher("Produtos.jsp");
		dispatcher.forward(request, response);
	}

}
