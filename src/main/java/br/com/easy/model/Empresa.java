package br.com.easy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idempresa")
	private int codigo;
	
	@Column(length = 100, nullable = false)
	@NotNull(message="Razão social não pode ser nulo")
	@NotEmpty(message="Razão social deve ser informada")
	private String razaoSocial;
	
	@Column(length = 100, nullable = false)
	@NotNull(message="Nome Fantasia não pode ser nulo")
	@NotEmpty(message="Nome Fantasia deve ser informado")
	private String nomeFantasia;
	
	@Column(length = 30, nullable = false, unique = true)
	@NotNull(message="CNPJ não pode ser nulo")
	private String cnpj;
	
	@Column(length = 20, nullable = false)
	@NotNull(message="Telefone não pode ser nulo")
	@NotEmpty(message="Telefone deve ser informado")
	private String telefone;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "imagem_empresa_id")
	private ImagemEmpresa imagemEmpresa;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco = new Endereco();
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="usuario_id")
	private Usuario usuario = new Usuario();
	
	@OneToMany(mappedBy = "empresa")
	private List<Anuncio> anuncios = new ArrayList<Anuncio>();

	private int numeroAnuncios;
	
	
	public ImagemEmpresa getImagemEmpresa() {
		return imagemEmpresa;
	}

	public void setImagemEmpresa(ImagemEmpresa imagemEmpresa) {
		this.imagemEmpresa = imagemEmpresa;
	}

	public List<Anuncio> getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
		Empresa other = (Empresa) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getNumeroAnuncios() {
		return numeroAnuncios;
	}

	public void setNumeroAnuncios(int numeroAnuncios) {
		this.numeroAnuncios = numeroAnuncios;
	}

	

	
	

}
