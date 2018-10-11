package DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Vendas;

public class VendasDAO {

	ConnectionFactory cf = new ConnectionFactory();
	Vendas venda;

	public void guardarVenda(Vendas venda) {
		try {

			String sqlInsert = "INSERT INTO vendas (id, sku_produto, codigo_cliente ,valor_venda, qtd_produto) VALUES(?,?,?,?,?)";
			Connection conn2 = cf.getConexaoMySQL();
			PreparedStatement stm2 = conn2.prepareStatement(sqlInsert);

			stm2.setInt(1, venda.getId());
			stm2.setLong(2, venda.getSku_produto());
			stm2.setInt(3, venda.getCodigo_cliente());
			stm2.setDouble(4, venda.getValor_venda());
			stm2.setInt(5, venda.getQtd_produto());

			stm2.execute();

		} catch (Exception erro) {
			erro.printStackTrace();
		}

	}

	public void CriarRelatorio(Vendas venda) throws FileNotFoundException {
		String sqlSelect = "SELECT * FROM vendas\r\n" + "INNER JOIN produtos\r\n"
				+ "ON vendas.sku_produto = produtos.id_produto\r\n" + "INNER JOIN  clientes\r\n"
				+ "on vendas.codigo_cliente = clientes.id_cliente";
		try {
			Connection conn = cf.getConexaoMySQL();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);
			try (ResultSet rs = stm.executeQuery();) {

				File file = new File("C:\\Users\\Paula\\eclipse-workspace\\ProjetoSalesForce\\WebContent\\arquivo.txt");
				PrintWriter pw = new PrintWriter(file);
				while (rs.next()) {

					pw.printf(
							"Codigo do Produto %s; Nome do Produto %s; Nome Cliente %s; Quantidade %s; Valor Total %s\n",
							rs.getInt("sku_produto"), rs.getString("nome"), rs.getString("clientes.nome"),
							rs.getInt("qtd_produto"), rs.getString("valor_venda"));
					System.out.printf("%s;%s;%s;%s;%s", rs.getInt("sku_produto"), rs.getString("nome"),
							rs.getString("clientes.nome"), rs.getInt("qtd_produto"), rs.getDouble("valor_venda"));
				}
				pw.flush();
				pw.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

	}

}
