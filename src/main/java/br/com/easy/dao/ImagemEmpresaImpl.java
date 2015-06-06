package br.com.easy.dao;

import java.io.Serializable;

import javax.ejb.Stateless;

import br.com.easy.model.ImagemEmpresa;

@Stateless
public class ImagemEmpresaImpl extends BasicDao<ImagemEmpresa> implements Serializable, ImagemEmpresaDao{


	public ImagemEmpresaImpl() {
		super(ImagemEmpresa.class);
		
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void addImagemEmpresa(ImagemEmpresa imagem) {
		
		addEntity(imagem);
		
		
	}

	@Override
	public ImagemEmpresa findImagemEmpresa(int id) {
	
		return findEntity(id);
	}

	

}
