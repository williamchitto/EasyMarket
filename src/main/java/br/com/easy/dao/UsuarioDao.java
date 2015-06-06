package br.com.easy.dao;

import br.com.easy.model.Usuario;

public interface UsuarioDao {
	
	public Usuario findUserByid(int id);
	public void addUser(Usuario user);
	public Usuario pesquisarUserByLogin(Usuario usuario);
	public Usuario pesquisarUserByemail(String email);
	public void alterarUser(Usuario usuario);
	public Usuario pesquisarUserEmailLogin(String email);


}
