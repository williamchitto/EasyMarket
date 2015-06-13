package br.com.easy.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import br.com.easy.dao.UsuarioDao;
import br.com.easy.exception.NegocioException;
import br.com.easy.model.Usuario;
import br.com.easy.model.UsuarioAutenticacao;

public class UsuarioService extends BasicService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioDao usuarioDao;
	@Inject
	private EmpresaService empresaService;
     @Inject
	private Usuario usuario;
	@Inject
	private UsuarioAutenticacao userAtenticacao;

	
	
	public Usuario buscarUserByid(int id){
		return this.usuarioDao.findUserByid(id);
		
	}
	
	
	
	public Usuario pesquisarUserEmail(String email){
		
		Usuario usuario = this.usuarioDao.pesquisarUserEmailLogin(email);
	
		  if(usuario==null){
			  
			  throw new NegocioException("Email inválido");
			  
			  
		  }
		
		
		
		return usuario;
		
		
		
	}
	

	public Usuario buscarUserByEmailService(String email) {

		Usuario user = usuarioDao.pesquisarUserEmailLogin(email);
		if (user == null) {

			throw new NegocioException(
					"Não existe usuário cadastrado para o email informado");

		}

		return user;

	}

	public String geraSenha() {
		String[] novaSenha = { "0", "1", "2", "3", "4", "5", "6", "7", "8",
				"9", "0", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
				"w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H",
				"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
				"U", "V", "W", "X", "Y", "Z" };
		String senha = "";
		for (int x = 0; x < 5; x++) {

			int j = (int) (Math.random() * novaSenha.length);
			senha += novaSenha[j];

		}
		System.out.println("A senha gerada é:" + senha);
		return senha;

	}

	public Usuario buscarUserLoginService(Usuario usuario) {

		System.out.println(usuario.getSenha());
		usuario.setSenha(empresaService.convertMD5(usuario.getSenha()));
		this.usuario = usuarioDao.pesquisarUserByLogin(usuario);
		if (this.usuario == null) {

			throw new NegocioException("Senha ou email inválido");

		}
		return this.usuario;

	}

	public void alterarUserService(Usuario usuario) {

		Usuario user = usuarioDao.pesquisarUserEmailLogin(usuario.getEmail());
		if (user == null) {

			throw new NegocioException(
					"Email informado não existe no nosso cadastro");

		}
		user.setSenha(usuario.getSenha());
		usuarioDao.alterarUser(user);

	}
	
	
	public void preecherDadosHash(UsuarioAutenticacao autenticacao){
	
		String hash = autenticacao.getUsuario().getEmail()
				+ gerarNumeroAleatorio();
		autenticacao.setDataEnvio(new Date());
		autenticacao.setHash(empresaService.convertMD5(hash));
	
		
	}
		
		
	public void compararSenha(String informada,String atual){
		
	  if(!informada.equals(atual)){
		  
		  throw new NegocioException("Senha informada inválida");
		   
		  
	  }
		
	}
	
	
	public String GerarUrlAutenticacaoLogin(UsuarioAutenticacao autenticacao) {

		return "http://localhost:8080/EasyMarket/Autenticador?codigo="
				+ autenticacao.getUsuario().getCodigo()+ "&autenticacao="
				+ autenticacao.getTipoAutenticacao() + "&chave="
				+ autenticacao.getHash();

	}

	public double gerarNumeroAleatorio() {

		return Math.random() * 10;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public EmpresaService getEmpresaService() {
		return empresaService;
	}

	public void setEmpresaService(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioAutenticacao getUserAtenticacao() {
		return userAtenticacao;
	}

	public void setUserAtenticacao(UsuarioAutenticacao userAtenticacao) {
		this.userAtenticacao = userAtenticacao;
	}

}
