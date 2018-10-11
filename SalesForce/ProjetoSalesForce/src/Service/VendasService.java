package Service;

import java.io.FileNotFoundException;

import DAO.VendasDAO;

import Model.Vendas;

public class VendasService {

	VendasDAO dao;

	public VendasService() {
		dao = new VendasDAO();
	}

	public void guardarVenda(Vendas venda) {
		dao.guardarVenda(venda);
	}

	public void CriarRelatorio(Vendas venda) throws FileNotFoundException {
		dao.CriarRelatorio(venda);
	}

}
