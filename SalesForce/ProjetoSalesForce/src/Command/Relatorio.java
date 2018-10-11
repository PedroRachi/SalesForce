package Command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Vendas;
import Service.VendasService;

public class Relatorio implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		Vendas venda = new Vendas();

		VendasService relatorio = new VendasService();
		request.setAttribute("mensagem", "Relatorio gerado com sucesso, confira na pasta do projeto");

		relatorio.CriarRelatorio(venda);

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

}
