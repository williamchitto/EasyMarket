package br.com.easy.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.easy.model.Pessoa;

@Stateless
public class PessoaDaoImpl extends BasicDao<Pessoa> implements PessoaDao,Serializable {

	


	private static final long serialVersionUID = 1L;
	
	
	public PessoaDaoImpl() {
		super(Pessoa.class);
		
	}

	@Override
	public void salvarPessoa(Pessoa pessoa) {
		
		addEntity(pessoa);
		
	}

	@Override
	public Pessoa pessoaById(int id) {
	
		return findEntity(id);
	}

	@Override
	public Pessoa pessoaByEmail(String email) {
	       List<Pessoa>list = new ArrayList<Pessoa>();
		     list = em.createQuery("from Pessoa where usuario.email = :email",Pessoa.class).setParameter("email",email).getResultList();
		     if(list==null || list.size()==0){
		    	 
		    	 return null;
		    	 
		     }
			  
			return list.get(0);
	}

	@Override
	public Pessoa pessoaByCpf(String cpf) {
		  List<Pessoa>list = new ArrayList<Pessoa>();
		     list = em.createQuery("from Pessoa where cpf = :cpf",Pessoa.class).setParameter("cpf",cpf).getResultList();
		     if(list==null || list.size()==0){
		    	 
		    	 return null;
		    	 
		     }
			  
			return list.get(0);
		
	}
	
	
	

}
