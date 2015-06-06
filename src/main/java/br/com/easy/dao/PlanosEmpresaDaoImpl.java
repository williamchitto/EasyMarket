package br.com.easy.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.easy.model.Empresa;
import br.com.easy.model.PlanoEmpresa;
import br.com.easy.model.Planos;

@Stateless
public class PlanosEmpresaDaoImpl extends BasicDao<PlanoEmpresa> implements PlanoEmpresaDao,Serializable {


	public PlanosEmpresaDaoImpl() {
		super(PlanoEmpresa.class);
		
	}

	private static final long serialVersionUID = 1L;

	@Override
	public PlanoEmpresa buscarPlanoByEmpresaValido(Empresa empresaParam) {
		 List<PlanoEmpresa>list = new ArrayList<PlanoEmpresa>();
	     list = em.createQuery("from PlanoEmpresa  where empresa  = :empresa and status = 1",PlanoEmpresa.class).setParameter("empresa",empresaParam).getResultList();
	     if(list==null || list.size()==0){
	    	 
	    	 return null;
	    	 
	     }
		  
		return list.get(0);
		
		
	}

	@Override
	public List<Planos> listplanos() {
	
		return em.createQuery("from Planos",
				Planos.class).getResultList();
	}

	@Override
	public void salvar(PlanoEmpresa planoEmpresa) {
		
		addEntity(planoEmpresa);
		
	}

	@Override
	public Planos findPlanoByid(int id) {
		
		return em.find(Planos.class,id);
	
	}

}
