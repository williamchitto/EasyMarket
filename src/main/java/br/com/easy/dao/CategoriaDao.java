package br.com.easy.dao;

import java.util.List;

import br.com.easy.model.Categoria;

public interface CategoriaDao {
	public Categoria findCategoria(int id);
	public List<Categoria> raizes();
	public List<Categoria>subcategoriaDe(Categoria categoriaPai);

}
