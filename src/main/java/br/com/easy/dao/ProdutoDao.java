package br.com.easy.dao;

import java.util.List;

import br.com.easy.model.Produto;

public interface ProdutoDao {
	
	public void addProduto(Produto produto);
	public Produto findProduto(int id);
	public List<Produto>findProdutoByNome(Produto produto);


}
