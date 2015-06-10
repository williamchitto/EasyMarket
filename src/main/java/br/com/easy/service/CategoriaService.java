package br.com.easy.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.easy.dao.CategoriaDao;
import br.com.easy.model.Categoria;

public class CategoriaService extends BasicService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaDao dao;

	public Categoria categoriaServiceById(int id) {
		return dao.findCategoria(id);

	}
	
	

	public CategoriaDao getDao() {
		return dao;
	}

	public void setDao(CategoriaDao dao) {
		this.dao = dao;
	}

}
