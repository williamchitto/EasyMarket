package br.com.easy.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.easy.validator.CEPVALIDO;
@Entity
public class Endereco implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_endereco")
	private int codigo;
	@Column(length=30,nullable=false)
	@CEPVALIDO
	private String cep;
	@Column(length=10,nullable=false)
	@NotEmpty(message="Número deve ser informado")
	@NotNull(message="Numero não pode ser nulo")
	private String numero;
	@Column(length=100,nullable=false)
	@NotEmpty(message="Bairro deve ser informado ")
	private String bairro;
	@Column(length=100,nullable=false)
	@NotEmpty(message="Cidade deve ser informada")
	private String cidade;
    @Column(length=2,nullable=false)
    @NotEmpty(message="Sigla do estado deve ser informada")
    @NotNull(message="Sigla do estado não pode ser nula")
	private String uf;
	@Column(length=100,nullable=false)
	private String complemento;
	@NotNull(message="Logradouro não pode ser nulo")
	@NotEmpty(message="Logradouro deve ser informado")
	private String logradouro;
	@OneToOne(mappedBy="endereco",cascade=CascadeType.ALL,orphanRemoval=true)
	private Empresa empresa;
	
	
	
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
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
		Endereco other = (Endereco) obj;
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
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	
	

}
