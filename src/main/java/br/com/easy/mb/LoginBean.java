package br.com.easy.mb;

import java.io.Serializable;

import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.easy.dominio.StatusValidacaoAutenticacao;
import br.com.easy.dominio.TipoUser;
import br.com.easy.model.Usuario;
import br.com.easy.service.UsuarioService;
@Named
@ViewScoped
public class LoginBean extends BasicBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuario usuario;
	@Inject
	private UsuarioService usuarioService;
	@Inject
	private UsuarioLogadoBean usuarioLogado;
	
	
	
	
	public String efetuarLogin(){
   
      Usuario usuarioEncontrado = usuarioService.buscarUserLoginService(this.usuario);
      if(usuarioEncontrado!=null){
    	  
    	  if(usuarioEncontrado.getUsuarioAutenticado()==StatusValidacaoAutenticacao.NAO_VALIDADO.getValor()){
    		  
    		  warn("Usuário não autenticado,acesse seu email e confirme sua conta");
    		  return "login";
    		  
    	  }
    	  
    	  System.out.println("Usuario encontrado");
    	  this.usuarioLogado.logar(usuarioEncontrado);
    	  
    	  if(usuarioEncontrado.getTipoUser().equals(TipoUser.ADMIN)){
    		  
    		  return "/admin/buscaEmpresa?faces-redirect=true";
    		  
    	  }
    	 
    	  return "index?faces-redirect=true";
    	  
      }
      
	    return "login";
	 	
	}
	
	
	
	
	public void isEmailValido(AjaxBehaviorEvent event){
		System.out.println("validar email executando");
		if(usuarioService.buscarUserByEmailService(this.usuario.getEmail())!=null){
			
			System.out.println("Email encontrado");
			
			
		}
		
		  
		
	}
	
	
	
	
			
			
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}




	public UsuarioLogadoBean getUsuarioLogado() {
		return usuarioLogado;
	}




	public void setUsuarioLogado(UsuarioLogadoBean usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}




	


	

}
