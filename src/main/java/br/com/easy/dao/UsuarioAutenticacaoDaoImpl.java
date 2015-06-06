package br.com.easy.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.easy.dominio.StatusValidacaoAutenticacao;
import br.com.easy.model.UsuarioAutenticacao;

@Stateless
public class UsuarioAutenticacaoDaoImpl extends BasicDao<UsuarioAutenticacao>
		implements Serializable, UsuarioAutenticacaoDao {

	public UsuarioAutenticacaoDaoImpl() {
		super(UsuarioAutenticacao.class);

	}

	private static final long serialVersionUID = 1L;

	@Override
	public void addUsuarioAutenticacao(UsuarioAutenticacao user) {

		addEntity(user);

	}

	@Override
	public UsuarioAutenticacao findUserAutenticacao(int codigo) {

		return findEntity(codigo);
	}

	@Override
	public UsuarioAutenticacao findUserAutenticacaoByEmailAndHash(
			UsuarioAutenticacao userAutenticacao) {
		
		List<UsuarioAutenticacao> list = new ArrayList<UsuarioAutenticacao>();
		list = em.createQuery("from UsuarioAutenticacao where usuario.email=:email and hash=:hash and statusAutenticacao=:status",UsuarioAutenticacao.class)
				.setParameter("email",userAutenticacao.getUsuario().getEmail()).setParameter("hash",userAutenticacao.getHash()).
				setParameter("status",StatusValidacaoAutenticacao.NAO_VALIDADO.getValor()).getResultList();
		
		if(list==null || list.size()==0){
			
			  return null;
			
		}
		
		
		return list.get(0);
	}
	
	
	public UsuarioAutenticacao invalidarUltimoHash(UsuarioAutenticacao userautenticacao){
		
		List<UsuarioAutenticacao> list = new ArrayList<UsuarioAutenticacao>();
		list = em.createQuery("from UsuarioAutenticacao where usuario.email=:email and statusAutenticacao=:status",UsuarioAutenticacao.class).
				setParameter("email",userautenticacao.getUsuario().getEmail()).setParameter("status",StatusValidacaoAutenticacao.NAO_VALIDADO.getValor()).getResultList();
		if(list==null || list.size()==0){
		
		      return null;
			
			
		}
		
		return list.get(0);
		

	}
	

	@Override
	public void updateUserAutenticacao(UsuarioAutenticacao user) {
		
		update(user);
		
	}
}
