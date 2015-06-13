package br.com.easy.dao;

import java.util.List;

import br.com.easy.model.Anuncio;
import br.com.easy.model.Categoria;
import br.com.easy.model.Empresa;

public interface AnuncioDao {
	
	public void addAnuncio(Anuncio anuncio);
	public void updateAnuncio(Anuncio anuncio);
	public Anuncio findAnuncio(int id);
	public List<Anuncio>anuncios();
	public List<Anuncio>listAnunciosVisualizacao();	
	public List<Anuncio>listAnunciosRecentes();
	public void alterarNumeroAnuncios(Anuncio anuncio);
	public int numeroAnuncios(Anuncio anuncio);
	public void addLikeAnuncio(Anuncio anuncio);
	public List<Anuncio>listAnunOrderByCategoria(Categoria categoria);
	public List<Anuncio>listAnuncioByEmpresa(Empresa empresa);
}
