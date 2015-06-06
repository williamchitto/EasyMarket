package br.com.easy.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.easy.dao.ImagemProdutoDao;
import br.com.easy.exception.NegocioException;
import br.com.easy.model.ImagemProduto;

public class ImagemProdutoService extends BasicService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	ImagemProdutoDao dao;
	

  public ImagemProduto buscarImagemProdutoById(int id){
	  
	  ImagemProduto imagem = dao.findImagemProduto(id);
	  if(imagem==null){
		  
		  throw new NegocioException("Imagem do produto não encontrada");
		  
	  }
	   
	return imagem ;
	 
  }
	

	
}
