package br.com.easy.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="usuario_autenticacao")
public class UsuarioAutenticacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario_autenticacao")
	private int codigo;
	@NotNull(message="Chave de autenticação não pode ser nula")
	@NotEmpty(message="Chave de autenticação deve ser informada")
	private String hash;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dataEnvio;
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	@Column(name="tipo_autenticacao")
	private int tipoAutenticacao;
	@Column(name="status_autenticacao")
	private int statusAutenticacao;

	
	

	
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
		UsuarioAutenticacao other = (UsuarioAutenticacao) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public Date getDataEnvio() {
		return dataEnvio;
	}
	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public int getTipoAutenticacao() {
		return tipoAutenticacao;
	}
	public void setTipoAutenticacao(int tipoAutenticacao) {
		this.tipoAutenticacao = tipoAutenticacao;
	}
	public int getStatusAutenticacao() {
		return statusAutenticacao;
	}
	public void setStatusAutenticacao(int statusAutenticacao) {
		this.statusAutenticacao = statusAutenticacao;
	}
	
	
	
	
	

}
