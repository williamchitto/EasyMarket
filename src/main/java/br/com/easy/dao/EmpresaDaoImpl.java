package br.com.easy.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.easy.model.Empresa;

@Stateless
public class EmpresaDaoImpl extends BasicDao<Empresa> implements EmpresaDao ,Serializable {

	public EmpresaDaoImpl() {
		super(Empresa.class);
		
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void addEmpresa(Empresa empresa) {
	   addEntity(empresa);
		
	
	}

	@Override
	public void removeEmpresa(int id) {
	    
		remove(id);
		
		
	}

	@Override
	public void updateEmpresa(Empresa empresa) {
		
		  update(empresa);
		
	}

	@Override
	public void listEmpresa() {
	
		 list();
		
	}

	@Override
	public Empresa findEmpresa(int id) {
	
		return findEntity(id);
	}

	@Override
	public Empresa buscarEmpresaPorCnpj(String cnpj) {
	     List<Empresa>list = new ArrayList<Empresa>();
	     list = em.createQuery("from Empresa where cnpj = :cnpj",Empresa.class).setParameter("cnpj",cnpj).getResultList();
	     if(list==null || list.size()==0){
	    	 
	    	 return null;
	    	 
	     }
		  
		return list.get(0);
	}

	@Override
	public Empresa buscarEmpresaPorEmail(String email) {
		 List<Empresa>list = new ArrayList<Empresa>();
	     list = em.createQuery("from Empresa where usuario.email = :email",Empresa.class).setParameter("email",email).getResultList();
	     if(list==null || list.size()==0){
	    	 
	    	 return null;
	    	 
	     }
		  
		return list.get(0);
		
		
		
	}
	
	
	

}
