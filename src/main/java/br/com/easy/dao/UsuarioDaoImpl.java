package br.com.easy.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.easy.model.Empresa;
import br.com.easy.model.Usuario;

@Stateless
public class UsuarioDaoImpl extends BasicDao<Usuario> implements Serializable,
		UsuarioDao {

	private static final long serialVersionUID = 1L;

	@Inject
	private EmpresaDao empresaDao;

	public UsuarioDaoImpl() {
		super(Usuario.class);

	}

	@Override
	public Usuario findUserByid(int id) {
		return findEntity(id);

	}

	@Override
	public void addUser(Usuario user) {

		addEntity(user);

	}

	@Override
	public Usuario pesquisarUserByLogin(Usuario usuario) {
		List<Usuario> user = new ArrayList<Usuario>();
		user = em
				.createQuery(
						"from Usuario where email=:email and senha=:senha",
						Usuario.class)
				.setParameter("email", usuario.getEmail())
				.setParameter("senha", usuario.getSenha()).getResultList();
		if (user == null || user.size() == 0) {

			return null;

		}

		return user.get(0);
	}

	@Override
	public Usuario pesquisarUserByemail(String email) {
		Empresa empresa = empresaDao.buscarEmpresaPorEmail(email);
		if (empresa != null) {

			return empresa.getUsuario();

		}

		return null;
	}

	
	

	
	public EmpresaDao getEmpresaDao() {
		return empresaDao;
	}

	public void setEmpresaDao(EmpresaDao empresaDao) {
		this.empresaDao = empresaDao;
	}

	@Override
	public void alterarUser(Usuario usuario) {

		update(usuario);

	}
	
	
	
	

	@Override
	public Usuario pesquisarUserEmailLogin(String email) {

		List<Usuario> user = new ArrayList<Usuario>();
		user = em.createQuery("from Usuario where email=:email", Usuario.class)
				.setParameter("email", email).getResultList();
		if (user == null || user.size() == 0) {

			return null;

		}

		return user.get(0);

	}

}
