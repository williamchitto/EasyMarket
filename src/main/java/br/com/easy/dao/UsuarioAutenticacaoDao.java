package br.com.easy.dao;

import br.com.easy.model.UsuarioAutenticacao;

public interface UsuarioAutenticacaoDao {
	
	public void addUsuarioAutenticacao(UsuarioAutenticacao user);
	public UsuarioAutenticacao findUserAutenticacao(int codigo);
	public UsuarioAutenticacao findUserAutenticacaoByEmailAndHash(UsuarioAutenticacao userAutenticacao);
	public void updateUserAutenticacao(UsuarioAutenticacao user);
	public UsuarioAutenticacao invalidarUltimoHash(UsuarioAutenticacao userautenticacao);

}
