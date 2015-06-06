package br.com.easy.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import br.com.easy.model.Anuncio;
import br.com.easy.model.Empresa;

@Stateless
public class AnuncioDaoImpl extends BasicDao<Anuncio> implements AnuncioDao,Serializable {

	private static final long serialVersionUID = 1L;

	public AnuncioDaoImpl() {
		
		super(Anuncio.class);
		
	}

	@Override
	public void addAnuncio(Anuncio anuncio) {

		addEntity(anuncio);
		
		
	}

	@Override
	public void updateAnuncio(Anuncio anuncio) {
	
		 update(anuncio);
		
	}

	@Override
	public Anuncio findAnuncio(int id) {

		return findEntity(id);
	}
	
	

	@Override
	public List<Anuncio> anuncios() {
	
		return list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Anuncio> listAnunciosVisualizacao() {
	
		Criteria criteria = createCriteria();
		criteria.addOrder(Order.asc("visualizacao"));
		criteria.setMaxResults(8);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Anuncio> listAnunciosRecentes() {
	
		Criteria criteria = createCriteria();
		criteria.addOrder(Order.desc("dataAnuncio"));
		criteria.setMaxResults(15);
		return criteria.list();
		

	}

	@Override
	public void alterarNumeroAnuncios(Anuncio anuncio) {
	   Empresa empresa = em.find(Empresa.class,anuncio.getEmpresa().getCodigo());
	   int anuncios = numeroAnuncios(anuncio);
	   if(empresa.getNumeroAnuncios()!= anuncios){
		   
		   empresa.setNumeroAnuncios(anuncios);
		   
	   }
		
	}

	@Override
	public int numeroAnuncios(Anuncio anuncio) {
		String consulta = "SELECT COUNT(a) FROM Anuncio a where empresa=:empresa";
		TypedQuery<Number> query = em.createQuery(consulta, Number.class).setParameter("empresa",anuncio.getEmpresa());
		Number result = query.getSingleResult();
		  if(result==null ){
			   return 0;
			  
		  }
			return result.intValue();
	}

}
