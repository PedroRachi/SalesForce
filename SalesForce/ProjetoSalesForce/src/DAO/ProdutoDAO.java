package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Produto;

public class ProdutoDAO {

	ConnectionFactory cf = new ConnectionFactory();
	Produto produto;

	public ArrayList<Produto> listarProdutos() {
		Produto produto;
		ArrayList<Produto> lista = new ArrayList<>();
		String sqlSelect = "SELECT id_produto, nome, valor FROM produtos";

		try {
			Connection conn = cf.getConexaoMySQL();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					produto = new Produto();
					produto.setId_produto(rs.getInt("id_produto"));
					produto.setNome_produto(rs.getString("nome"));
					produto.setValor(rs.getString("valor"));

					lista.add(produto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

}
