package br.com.easy.admin;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.easy.dominio.StatusValidacaoAutenticacao;
import br.com.easy.dominio.TipoUser;
import br.com.easy.mb.BasicBean;
import br.com.easy.model.Pessoa;
import br.com.easy.model.Usuario;
import br.com.easy.service.PessoaService;

@Named
@ViewScoped
public class CadastrarPessoaBean extends BasicBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	PessoaService service;
	@Inject
	private Pessoa pessoa;
	@Inject
	private Usuario usuario;
	
	
	public void salvar(){
	  this.usuario.setTipoUser(TipoUser.ADMIN); 	
	  this.usuario.setUsuarioAutenticado(StatusValidacaoAutenticacao.VALIDADO.getValor());
	  this.pessoa.setUsuario(this.usuario);	
	  this.service.salvarPessoaService(this.pessoa);
	  limparCampos();
		info("Usuário cadastrado com sucesso.");
		
	}
	
	
	public void limparCampos(){
		
		this.pessoa = new Pessoa();
		this.usuario = new Usuario();
		
		
	}
	

	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
