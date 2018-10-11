package Service;

import java.util.ArrayList;

import DAO.ClientesDAO;
import Model.Clientes;

public class ClientesService {

	ClientesDAO dao;

	public ClientesService() {
		dao = new ClientesDAO();
	}

	public ArrayList<Clientes> listarClientes() {
		return dao.listarClientes();
	}

	public ArrayList<Clientes> listarClientes(String chave) {
		return dao.listarClientes(chave);
	}
}
