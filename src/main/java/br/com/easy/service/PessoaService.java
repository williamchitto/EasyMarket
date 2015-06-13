package br.com.easy.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.easy.dao.PessoaDao;
import br.com.easy.dao.UsuarioDao;
import br.com.easy.exception.NegocioException;
import br.com.easy.model.Pessoa;
import br.com.easy.model.Usuario;

public class PessoaService extends BasicService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	PessoaDao dao;
	@Inject
	EmpresaService empresaService;
	@Inject
	UsuarioDao usuarioDao;
	
	
	
	public void salvarPessoaService(Pessoa pessoa){
		
		cadastroPessoaValido(pessoa);
		pessoa.getUsuario().setSenha(empresaService.convertMD5(pessoa.getUsuario().getSenha()));
		dao.salvarPessoa(pessoa);
		
		
		
		
	}
	
	
	

	
	
	public void cadastroPessoaValido(Pessoa pessoaParam){
	
	   if(pessoaByCpfService(pessoaParam.getCpf())!=null){
		   
		   throw new NegocioException("CPF já foi cadastrado no sistema.");
		   
	   }
	   if(UsuarioByPessoaServiceEmail(pessoaParam.getUsuario().getEmail())!=null){
		   
		   throw new NegocioException("EMAIL já foi cadastrado no sistema.");
		   
	   }
		
		
		
	}
	
	
	public Usuario UsuarioByPessoaServiceEmail(String email){
		
		Usuario usuario = usuarioDao.pesquisarUserEmailLogin(email);
		if(usuario!=null){
			
			  return usuario;
			
		}
		
		
		return null;
		
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
