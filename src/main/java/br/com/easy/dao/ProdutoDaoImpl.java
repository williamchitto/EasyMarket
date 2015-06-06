package br.com.easy.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.easy.model.Categoria;
import br.com.easy.model.Produto;

@Stateless
public class ProdutoDaoImpl extends BasicDao<Produto> implements ProdutoDao,
		Serializable {

	private static final long serialVersionUID = 1L;

	public ProdutoDaoImpl() {

		super(Produto.class);
	}

	@Override
	public void addProduto(Produto produto) {

		addEntity(produto);

	}

	@Override
	public Produto findProduto(int id) {

		return findEntity(id);
	}

	@Override
	public List<Produto> findProdutoByNome(Produto produto) {
		// Criteria crit = createCriteria();
		// crit.add(Restrictions.ilike("nome",produto.getNome(),MatchMode.ANYWHERE));
		// return crit.list();
		return em
				.createQuery(
						"from Produto where origemProduto =2 and nome like:nome or  produtoEmpresa=:empresa and nome like:nome",
						Produto.class).setParameter("nome", "%"+produto.getNome()+"%")
				.setParameter("empresa", produto.getProdutoEmpresa())
				.getResultList();

	}

}
