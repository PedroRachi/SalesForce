package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Clientes;

/*Dao*/

public class ClientesDAO {

	ConnectionFactory cf = new ConnectionFactory();
	Clientes cliente;

	public ArrayList<Clientes> listarClientes() {
		Clientes cliente;
		ArrayList<Clientes> lista = new ArrayList<>();
		String sqlSelect = "SELECT id_cliente, nome, cpf, data_nascimento, genero FROM clientes";

		try {
			Connection conn = cf.getConexaoMySQL();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					cliente = new Clientes();
					cliente.setId_cliente(rs.getInt("id_cliente"));
					cliente.setNome_cliente(rs.getString("nome"));
					cliente.setCpf(rs.getString("cpf"));
					cliente.setData_nascimento(rs.getDate("data_nascimento"));
					cliente.setGenero(rs.getString("genero"));
					lista.add(cliente);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

		return lista;
	}

	public ArrayList<Clientes> listarClientes(String chave) {
		Clientes cliente;
		ArrayList<Clientes> lista = new ArrayList<>();
		String sqlSelect = "SELECT  id_cliente, nome, CPF, data_nascimento, genero FROM clientes where upper(nome) like ?";
		try (Connection conn = cf.getConexaoMySQL(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					cliente = new Clientes();
					cliente.setId_cliente(rs.getInt("id_cliente"));
					cliente.setNome_cliente(rs.getString("nome"));
					cliente.setCpf(rs.getString("CPF"));
					cliente.setData_nascimento(rs.getDate("data_nascimento"));
					cliente.setGenero(rs.getString("genero"));
					lista.add(cliente);
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
