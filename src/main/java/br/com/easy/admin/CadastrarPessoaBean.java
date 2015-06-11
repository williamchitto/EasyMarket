package br.com.easy.admin;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.easy.mb.BasicBean;
import br.com.easy.model.Pessoa;
import br.com.easy.service.PessoaService;

public class CadastrarPessoaBean extends BasicBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	PessoaService service;
	private Pessoa pessoa;
	
	

	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
