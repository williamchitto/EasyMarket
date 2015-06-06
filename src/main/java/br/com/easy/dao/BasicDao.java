package br.com.easy.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;


public abstract class BasicDao<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Class<T> clazz;

	@PersistenceContext
	public EntityManager em;

	public BasicDao(Class<T> clazz) {

		this.clazz = clazz;

	}
	
	protected Session getSession(){
		
		Session session = em.unwrap(Session.class);
		return session;
		
	}
	
	protected Criteria createCriteria(){
		
		return getSession().createCriteria(clazz);
		
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> list(){
		
		return createCriteria().list();
		
	}
	
	

	protected void addEntity(T entity) {

		em.persist(entity);

	}

	protected T findEntity(int id) {

		return em.find(clazz, id);

	}

	protected void remove(int id) {

		T entity = findEntity(id);
		em.remove(entity);

	}
	
	
	protected void update(T entity){
		
		em.merge(entity);
		
	}
	

}
