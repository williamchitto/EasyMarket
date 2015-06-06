package br.com.easy.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.easy.dao.UsuarioAutenticacaoDao;
import br.com.easy.dominio.StatusValidacaoAutenticacao;
import br.com.easy.exception.NegocioException;
import br.com.easy.model.UsuarioAutenticacao;

public class UsuarioAutenticacaoService extends BasicService implements
		Serializable {

	private static final long serialVersionUID = 1;

	@Inject
   private	UsuarioAutenticacaoDao dao;

	
	public void invalidarUserAutenticacaoByEmailValido(UsuarioAutenticacao user){
		
		UsuarioAutenticacao autenticacao = dao.invalidarUltimoHash(user);
		if(autenticacao!=null){
			autenticacao.setStatusAutenticacao(StatusValidacaoAutenticacao.VALIDADO.getValor());
			alterarUsuarioAutenticacaoService(autenticacao);
			
		}
		
		
		
	}
	
	
	
	public void salvarUserAutenticacaoService(UsuarioAutenticacao user) {
		
		System.out.println("metodo salvar autenticador");

		dao.addUsuarioAutenticacao(user);

	}

	public UsuarioAutenticacao buscarUsuarioAutenticacaoByEmailAndHashService(
			UsuarioAutenticacao user) {

		UsuarioAutenticacao usuario = dao
				.findUserAutenticacaoByEmailAndHash(user);
		if (usuario == null) {

			throw new NegocioException("Usuario não autenticado");

		}

		return usuario;

	}

	public void alterarUsuarioAutenticacaoService(UsuarioAutenticacao user) {

		dao.updateUserAutenticacao(user);

	}

	public UsuarioAutenticacaoDao getDao() {
		return dao;
	}

	public void setDao(UsuarioAutenticacaoDao dao) {
		this.dao = dao;
	}
	
	
	
	

}
