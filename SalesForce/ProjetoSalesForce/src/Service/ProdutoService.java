package Service;

import java.util.ArrayList;

import DAO.ProdutoDAO;
import Model.Produto;

public class ProdutoService {

	ProdutoDAO dao;

	public ProdutoService() {
		dao = new ProdutoDAO();
	}

	public ArrayList<Produto> listarProdutos() {
		return dao.listarProdutos();

	}
}
