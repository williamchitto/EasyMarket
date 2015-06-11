package br.com.easy.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Anuncio  implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_anuncio")
	private int codigo;
	@Column(precision=10,scale=2,nullable=false)
	@NotNull(message="O Preço do produto não pode ser nulo")
	private BigDecimal preco;
	@Column(nullable=false)
	private boolean pagamentoCartao;
	@Column(nullable=false)
	private boolean pagamentoDinheiro;
	@Column(nullable=true)
	private boolean opcaoEntrega;
	@ManyToOne
	@JoinColumn(name="empresa_id")
	private Empresa empresa;
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto = new Produto();
	private int visualizacao;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAnuncio;
	private int statusAnuncio;

   		

	public Date getDataAnuncio() {
		return dataAnuncio;
	}



	public void setDataAnuncio(Date dataAnuncio) {
		this.dataAnuncio = dataAnuncio;
	}



	
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public boolean isPagamentoCartao() {
		return pagamentoCartao;
	}
	public void setPagamentoCartao(boolean pagamentoCartao) {
		this.pagamentoCartao = pagamentoCartao;
	}
	public boolean isPagamentoDinheiro() {
		return pagamentoDinheiro;
	}
	public void setPagamentoDinheiro(boolean pagamentoDinheiro) {
		this.pagamentoDinheiro = pagamentoDinheiro;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anuncio other = (Anuncio) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	public boolean isOpcaoEntrega() {
		return opcaoEntrega;
	}
	public void setOpcaoEntrega(boolean opcaoEntrega) {
		this.opcaoEntrega = opcaoEntrega;
	}
	public int getVisualizacao() {
		return visualizacao;
	}
	public void setVisualizacao(int visualizacao) {
		this.visualizacao = visualizacao;
	}



	public int getStatusAnuncio() {
		return statusAnuncio;
	}



	public void setStatusAnuncio(int statusAnuncio) {
		this.statusAnuncio = statusAnuncio;
	}


}
