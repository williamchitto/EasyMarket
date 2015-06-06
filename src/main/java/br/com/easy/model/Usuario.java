package br.com.easy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.easy.dominio.TipoUser;


@Entity
public class Usuario implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
    private int codigo;
	@Column(unique=true)
	@Email(message="Email inválido")
	@NotEmpty(message="Email deve ser informado")
    private String email; 
	@NotEmpty(message="Senha deve ser informada")
    private String senha;
    @OneToOne(mappedBy="usuario")
    private Empresa empresa;
    @Column(name="usuario_autenticado")
    private int usuarioAutenticado;
    @OneToMany(mappedBy="usuario")
    private List<UsuarioAutenticacao>userAutenticacoes = new ArrayList<UsuarioAutenticacao>();
    @Enumerated(EnumType.STRING)
    @Column(name="tipo_user")
    private TipoUser tipoUser;;
    
   
	public TipoUser getTipoUser() {
		return tipoUser;
	}
	public void setTipoUser(TipoUser tipoUser) {
		this.tipoUser = tipoUser;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public List<UsuarioAutenticacao> getUserAutenticacoes() {
		return userAutenticacoes;
	}
	public void setUserAutenticacoes(List<UsuarioAutenticacao> userAutenticacoes) {
		this.userAutenticacoes = userAutenticacoes;
	}
	public int getUsuarioAutenticado() {
		return usuarioAutenticado;
	}
	public void setUsuarioAutenticado(int usuarioAutenticado) {
		this.usuarioAutenticado = usuarioAutenticado;
	}
	
	
	
    
	
	

}
