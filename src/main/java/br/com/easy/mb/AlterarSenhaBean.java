package br.com.easy.mb;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.easy.dao.UsuarioDao;
import br.com.easy.model.Usuario;
import br.com.easy.service.EmpresaService;
import br.com.easy.service.UsuarioService;

@Named
@ViewScoped
public class AlterarSenhaBean extends BasicBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuario usuarioSenha;
	@Inject
	private Usuario usuario;
	@Inject
	UsuarioDao usuarioDao;
	@Inject
	UsuarioService usuarioService;
	@Inject
	EmpresaService empresaService;
	@Inject
	UsuarioLogadoBean usuarioLogado;
	private String novaSenha;
	private String confirmNovaSenha;
	
	

	public void salvar() {
		
	System.out.println("metodo alterar senha");	
	this.usuarioService.compararSenha(this.empresaService.convertMD5(usuarioSenha.getSenha()),this.usuarioLogado.getUsuario().getSenha());
     Usuario usuario = usuarioService.buscarUserByid(this.usuarioLogado.getUsuario().getCodigo());
     usuario.setSenha(this.empresaService.convertMD5(novaSenha));
     this.usuarioDao.alterarUser(usuario);
     limparCampos();
     info("Senha alterada com sucesso");
    
	}
	
	
	
	
	public void limparCampos(){
		
		this.usuarioSenha = new Usuario();
		this.novaSenha = null;
		this.confirmNovaSenha = null;
		
		
		
	}
	
	
	public Usuario getUsuarioSenha() {
		return usuarioSenha;
	}

	public void setUsuarioSenha(Usuario usuarioSenha) {
		this.usuarioSenha = usuarioSenha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public String getConfirmNovaSenha() {
		return confirmNovaSenha;
	}

	public void setConfirmNovaSenha(String confirmNovaSenha) {
		this.confirmNovaSenha = confirmNovaSenha;
	}

}
