package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Clientes;

import Service.ClientesService;

public class ListarClientesBuscar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String chave = request.getParameter("data[search]");
		ClientesService cli = new ClientesService();
		ArrayList<Clientes> lista = null;
		HttpSession session = request.getSession();
		if (chave != null && chave.length() > 0) {
			lista = cli.listarClientes(chave);
		} else {
			lista = cli.listarClientes();
		}
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarClientes.jsp");
		dispatcher.forward(request, response);
	}

}
