package Command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

public class EnviarParametroIdCliente implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
		request.setAttribute("id_cliente", id_cliente);

		int quantidade = 0;
		request.setAttribute("quantidade", quantidade);

		ListarProdutosBuscar busca = new ListarProdutosBuscar();

		busca.executar(request, response);

	}

}
