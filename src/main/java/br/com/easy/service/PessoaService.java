package br.com.easy.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.easy.dao.PessoaDao;
import br.com.easy.exception.NegocioException;
import br.com.easy.model.Pessoa;

public class PessoaService extends BasicService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	PessoaDao dao;
	
	
	
	public void salvarPessoaService(Pessoa pessoa){
		
		cadastroPessoaValido(pessoa);
		dao.salvarPessoa(pessoa);
		
		
		
		
	}
	
	
	public void cadastroPessoaValido(Pessoa pessoaParam){
	
	   if(pessoaByCpfService(pessoaParam.getCpf())!=null){
		   
		   throw new NegocioException("CPF ja cadastrado no sistema.");
		   
	   }
	   if(pessoaByemailService(pessoaParam.getUsuario().getEmail())!=null){
		   
		   throw new NegocioException("EMAIL ja cadastrado no sistema.");
		   
	   }
		
		
		
	}
	
	
	public Pessoa pessoaByemailService(String email){
		
     Pessoa pessoa = dao.pessoaByEmail(email);
     if(pessoa!=null){
    	 
    	 return pessoa;
    	 
     }
		
		return null;
	
	}
	
	
	public Pessoa pessoaByCpfService(String cpf){
		Pessoa pessoa = dao.pessoaByCpf(cpf);
		if(pessoa!=null){
			
		    return pessoa;	
			
		}
		
		return null;
		
	}
	

}
