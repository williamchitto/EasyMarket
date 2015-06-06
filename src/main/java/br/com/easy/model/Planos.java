package br.com.easy.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Planos implements  Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idplano")
	private int codigo;
	private String nome;
	private BigDecimal preco;
	private int quantidadeMaximaAnuncios;
	private boolean ilimitado;
	private int quantidadeDiasPlano;
	

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public boolean isIlimitado() {
		return ilimitado;
	}
	public void setIlimitado(boolean ilimitado) {
		this.ilimitado = ilimitado;
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
		Planos other = (Planos) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	public int getQuantidadeMaximaAnuncios() {
		return quantidadeMaximaAnuncios;
	}
	public void setQuantidadeMaximaAnuncios(int quantidadeMaximaAnuncios) {
		this.quantidadeMaximaAnuncios = quantidadeMaximaAnuncios;
	}
	public int getQuantidadeDiasPlano() {
		return quantidadeDiasPlano;
	}
	public void setQuantidadeDiasPlano(int quantidadeDiasPlano) {
		this.quantidadeDiasPlano = quantidadeDiasPlano;
	}
	
	
	
	
	
	
	
	
	

}
