package Model;

import java.io.Serializable;

public class Vendas implements Serializable {

	private static final long serialVersionUID = 1L;

	private long sku_produto;
	private int codigo_cliente;
	private double valor_venda;
	private int qtd_produto;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getSku_produto() {
		return sku_produto;
	}

	public void setSku_produto(long sku_produto) {
		this.sku_produto = sku_produto;
	}

	public int getCodigo_cliente() {
		return codigo_cliente;
	}

	public void setCodigo_cliente(int codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}

	public double getValor_venda() {
		return valor_venda;
	}

	public void setValor_venda(double valor_venda) {
		this.valor_venda = valor_venda;
	}

	public int getQtd_produto() {
		return qtd_produto;
	}

	public void setQtd_produto(int qtd_produto) {
		this.qtd_produto = qtd_produto;
	}

}
