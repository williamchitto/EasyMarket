package br.com.easy.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.easy.dao.CategoriaDao;
import br.com.easy.dao.ProdutoDao;
import br.com.easy.exception.NegocioException;
import br.com.easy.model.Categoria;
import br.com.easy.model.ImagemProduto;
import br.com.easy.model.Produto;

public class ProdutoService extends BasicService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaDao categoriaDao;
	@Inject
	private ProdutoDao produtoDao;
	public void salvarProdutoService(Produto produto){
		
		produtoDao.addProduto(produto);
		
	}
	
	
	public void isImagemProdutoValida(ImagemProduto imagem,long tamanho){
		
		if(!isImagemValida(imagem.getType())){
			
			throw new NegocioException("Arquivo de imagem inválido");
			 
			
		}
		else if(!isTamanhomaximoPermitido(tamanho)){
			
			throw new NegocioException("Tamanho de arquivo não permitido");
			
		}
		
		
	}
	
	
	public List<Produto>ProdutoServiceBynome(Produto produto){
		
		return this.produtoDao.findProdutoByNome(produto);
		
	}
	
	
	


	public List<Categoria> categoriaRaizesService() {
		return categoriaDao.raizes();

	}

	public List<Categoria> subcategoriaRaizes(Categoria categoria) {
		return categoriaDao.subcategoriaDe(categoria);

	}

	public CategoriaDao getCategoriaDao() {
		return categoriaDao;
	}

	public void setCategoriaDao(CategoriaDao categoriaDao) {
		this.categoriaDao = categoriaDao;
	}

	public ProdutoDao getProdutoDao() {
		return produtoDao;
	}

	public void setProdutoDao(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
	}

}
