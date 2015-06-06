package br.com.easy.dao;

import java.io.Serializable;

import javax.ejb.Stateless;

import br.com.easy.model.ImagemProduto;

@Stateless
public class ImagemProdutoDaoImpl extends BasicDao<ImagemProduto> implements ImagemProdutoDao,Serializable {


	private static final long serialVersionUID = 1L;
	
	
	public ImagemProdutoDaoImpl() {
		super(ImagemProduto.class);
	}
	

	@Override
	public ImagemProduto findImagemProduto(int id) {
		
		return findEntity(id);
	}

}
