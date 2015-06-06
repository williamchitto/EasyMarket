package br.com.easy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_produto")
	private int codigo;
	@Column(nullable=false)
	@NotNull(message="Nome não pode ser nulo")
	@NotEmpty(message="Nome deve ser informado")
	private String nome;
	private String descricao;
	@ManyToOne
	@JoinColumn(name="categoria_id",nullable=false)
	private Categoria categoria;
	@OneToMany(mappedBy="produto")
	private List<Anuncio>produtoAnuncios = new ArrayList<Anuncio>();
	@OneToOne(cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name="produto_imagem_id")
	private ImagemProduto produtoImagem;
	@ManyToOne
	@JoinColumn(name="produto_empresa_id")
	private Empresa produtoEmpresa;
	private int origemProduto;
	

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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		Produto other = (Produto) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public List<Anuncio> getProdutoAnuncios() {
		return produtoAnuncios;
	}
	public void setProdutoAnuncios(List<Anuncio> produtoAnuncios) {
		this.produtoAnuncios = produtoAnuncios;
	}
	public ImagemProduto getProdutoImagem() {
		return produtoImagem;
	}
	public void setProdutoImagem(ImagemProduto produtoImagem) {
		this.produtoImagem = produtoImagem;
	}
	public Empresa getProdutoEmpresa() {
		return produtoEmpresa;
	}
	public void setProdutoEmpresa(Empresa produtoEmpresa) {
		this.produtoEmpresa = produtoEmpresa;
	}
	public int getOrigemProduto() {
		return origemProduto;
	}
	public void setOrigemProduto(int origemProduto) {
		this.origemProduto = origemProduto;
	}
	


}
