package br.com.easy.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.outjected.email.api.MailMessage;
import com.outjected.email.impl.templating.velocity.VelocityTemplate;

import br.com.easy.exception.Mailer;
import br.com.easy.model.Usuario;
import br.com.easy.model.UsuarioAutenticacao;
import br.com.easy.service.UsuarioService;

@Named
@RequestScoped
public class EnviarSenhaEmailBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Mailer mailer;
	@Inject
	private UsuarioService usuarioService;
	
	
	public void enviarEmailRecuperacao(UsuarioAutenticacao userAtenticacao){
		
    MailMessage message = mailer.novaMensagem();
    usuarioService.preecherDadosHash(userAtenticacao);
		message.to(userAtenticacao.getUsuario().getEmail())
			.subject("Recuperação senha Easy Market")
			.bodyHtml(new VelocityTemplate(getClass().getResourceAsStream("/emails/reenviar.template")))
			.put("url",usuarioService.GerarUrlAutenticacaoLogin(userAtenticacao))
			.send();
		
		
	}
	
	
	public void enviarEmailComSenha(Usuario usuario){
		 MailMessage message = mailer.novaMensagem();
		message.to(usuario.getEmail())
		.subject("Recuperação senha Easy Market")
		.bodyHtml(new VelocityTemplate(getClass().getResourceAsStream("/emails/reenviarSenha.template")))
		.put("email",usuario.getEmail())
		.put("senha",usuario.getSenha())
		.send();
		
	}
	
	
	
	public void enviarEmailValidacao(UsuarioAutenticacao user){
		
		 MailMessage message = mailer.novaMensagem();
		
		message.to(user.getUsuario().getEmail())
			.subject("Validar login")
			.bodyHtml(new VelocityTemplate(getClass().getResourceAsStream("/emails/validarLogin.template")))
			.put("url",usuarioService.GerarUrlAutenticacaoLogin(user))
			.send();
		
		
	}
	
	
	public Mailer getMailer() {
		return mailer;
	}

	public void setMailer(Mailer mailer) {
		this.mailer = mailer;
	}

	

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	

}
