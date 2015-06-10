package br.com.easy.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import br.com.easy.model.Categoria;

@Stateless
public class CategoriaDaoImpl extends BasicDao<Categoria> implements
		CategoriaDao, Serializable {

	private static final long serialVersionUID = 1L;

	public CategoriaDaoImpl() {

		super(Categoria.class);
	}

	@Override
	public Categoria findCategoria(int id) {

		return findEntity(id);
	}

	@Override
	public List<Categoria> raizes() {

		return em.createQuery("from Categoria where categoriaPai is null",
				Categoria.class).getResultList();
	}

	@Override
	public List<Categoria> subcategoriaDe(Categoria categoriaPai) {

		return em
				.createQuery("from Categoria where categoriaPai = :raiz",
						Categoria.class).setParameter("raiz", categoriaPai)
				.getResultList();
	}
	
	
	

}
