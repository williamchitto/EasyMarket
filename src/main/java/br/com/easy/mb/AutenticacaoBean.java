package br.com.easy.mb;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.joda.time.DateTime;
import org.joda.time.Hours;

import br.com.easy.dominio.StatusValidacaoAutenticacao;
import br.com.easy.model.Usuario;
import br.com.easy.model.UsuarioAutenticacao;
import br.com.easy.service.UsuarioAutenticacaoService;
import br.com.easy.service.UsuarioService;

@Named
@RequestScoped
public class AutenticacaoBean extends BasicBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final int hora = 24;

	@Inject
	private Usuario usuario;
	@Inject
	UsuarioService userService;
	@Inject
	private UsuarioAutenticacao userAutenticacao;
	@Inject
	private UsuarioAutenticacaoService serviceAutenticacao;
	@Inject
	EnviarSenhaEmailBean email;
	@Inject
	Usuario userEmail;
	

	public boolean autenticarRecuperacaoSenha(UsuarioAutenticacao autenticacao) {

		System.out.println("Metodo recuperar autenticação senha");

		UsuarioAutenticacao user = serviceAutenticacao.buscarUsuarioAutenticacaoByEmailAndHashService(autenticacao);
		Date dataEnvio = new Date(user.getDataEnvio().getTime());
		Date dataValidacao = new Date(autenticacao.getDataEnvio().getTime());
		if (user != null && validarDataValidacao(dataEnvio, dataValidacao)) {
			this.userEmail.setSenha(userService.geraSenha());
			this.userEmail.setEmail(user.getUsuario().getEmail());

			autenticacao.getUsuario().setSenha(userService.getEmpresaService().convertMD5(userEmail.getSenha()));
			userService.getUsuarioDao().alterarUser(autenticacao.getUsuario());

			user.setStatusAutenticacao(StatusValidacaoAutenticacao.VALIDADO.getValor());

			serviceAutenticacao.alterarUsuarioAutenticacaoService(user);
			email.enviarEmailComSenha(userEmail);
			return true;

		}
		return false;

	}

	public boolean autenticarLogin(UsuarioAutenticacao autenticacao) {

		UsuarioAutenticacao user = serviceAutenticacao.buscarUsuarioAutenticacaoByEmailAndHashService(autenticacao);
		Date dataEnvio = new Date(user.getDataEnvio().getTime());
		Date dataValidacao = new Date(autenticacao.getDataEnvio().getTime());
		if (user != null && validarDataValidacao(dataEnvio,dataValidacao)) {

			user.setStatusAutenticacao(StatusValidacaoAutenticacao.VALIDADO.getValor());
			autenticacao.getUsuario().setUsuarioAutenticado(StatusValidacaoAutenticacao.VALIDADO.getValor());
			userService.getUsuarioDao().alterarUser(autenticacao.getUsuario());
			serviceAutenticacao.alterarUsuarioAutenticacaoService(user);

			return true;

		}

		return false;

	}

	public boolean validarDataValidacao(Date inicial, Date validacaoFinal) {
		DateTime inicio = new DateTime(inicial);
		DateTime validacao = new DateTime(validacaoFinal);
		Hours h = Hours.hoursBetween(inicio, validacao);
		System.out.println("Horas validação:" + h.getHours());
		if (h.getHours() > hora) {

			return false;

		}

		return true;

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioAutenticacao getUserAutenticacao() {
		return userAutenticacao;
	}

	public void setUserAutenticacao(UsuarioAutenticacao userAutenticacao) {
		this.userAutenticacao = userAutenticacao;
	}

	public static int getHora() {
		return hora;
	}

}
