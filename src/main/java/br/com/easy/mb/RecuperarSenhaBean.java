package br.com.easy.mb;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.easy.dao.UsuarioDao;
import br.com.easy.dominio.StatusValidacaoAutenticacao;
import br.com.easy.dominio.TipoAutenticacao;
import br.com.easy.model.Usuario;
import br.com.easy.model.UsuarioAutenticacao;
import br.com.easy.service.EmpresaService;
import br.com.easy.service.UsuarioAutenticacaoService;
import br.com.easy.service.UsuarioService;

@Named
@ViewScoped
public class RecuperarSenhaBean extends BasicBean implements Serializable {

	private static final long serialVersionUID = 1L;
     
	
	
	@Inject
	private Usuario usuario;
	@Inject
	private Usuario userEmail;
	@Inject
	LoginBean loginBean;
	@Inject
	UsuarioService service;
	@Inject
	EmpresaService empresaService;
	@Inject
	EnviarSenhaEmailBean email;
	@Inject
	UsuarioDao usuarioDao;
	@Inject
	UsuarioAutenticacao userAutenticacao;
	@Inject
	UsuarioAutenticacaoService autenticacaoService;
	

	
	
	public void recuperarLogin(){
		
		Usuario user = this.service.pesquisarUserEmail(this.usuario.getEmail());
		this.userAutenticacao.setUsuario(user);
		if(user.getUsuarioAutenticado()==StatusValidacaoAutenticacao.NAO_VALIDADO.getValor()){
			this.userAutenticacao.setTipoAutenticacao(TipoAutenticacao.LOGIN.getValor());
			email.getUsuarioService().preecherDadosHash(userAutenticacao);
			email.enviarEmailValidacao(userAutenticacao);
			  this.userAutenticacao.setStatusAutenticacao(StatusValidacaoAutenticacao.NAO_VALIDADO.getValor());
			  this.usuario.getUserAutenticacoes().add(userAutenticacao);
			  this.userAutenticacao.setCodigo(0);
			  this.autenticacaoService.invalidarUserAutenticacaoByEmailValido(userAutenticacao);
			  this.autenticacaoService.salvarUserAutenticacaoService(userAutenticacao);
			info("Um email foi enviado para autenticar sua conta");
		}else{
			
        this.autenticacaoService.invalidarUserAutenticacaoByEmailValido(userAutenticacao);
		this.userAutenticacao.setTipoAutenticacao(TipoAutenticacao.RECUPERACAO.getValor());
		this.email.enviarEmailRecuperacao(this.userAutenticacao);
		this.userAutenticacao.setStatusAutenticacao(StatusValidacaoAutenticacao.NAO_VALIDADO.getValor());
		this.usuario.getUserAutenticacoes().add(userAutenticacao);
		this.userAutenticacao.setCodigo(0);
		this.autenticacaoService.salvarUserAutenticacaoService(userAutenticacao);
		limparCampos();
		info("Um email foi enviado para confirmar a recuperação da sua conta"); 
		}
	   
	
	}
	

	public void limparCampos(){
		
		this.usuario = new Usuario();
		
	}

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public Usuario getUserEmail() {
		return userEmail;
	}



	public void setUserEmail(Usuario userEmail) {
		this.userEmail = userEmail;
	}

	

}
