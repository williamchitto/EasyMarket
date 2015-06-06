package br.com.easy.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "webservicecep")
public class EnderecoWare implements Serializable{
	
	private static final long serialVersionUID = 1L;

private String uf;
	
	private String estado;
	
	private String cidade;
	
	private String bairro;
	
	private String logradouro;
	
	private String logradouro_curto;
	
	private int numero;
	
	private String complemento;
	
	private String cep;
	
	private String resultado_txt;
	

	
	public String getResultado_txt() {
		return resultado_txt;
	}
	public void setResultado_txt(String resultado_txt) {
		this.resultado_txt = resultado_txt;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}	
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getLogradouro_curto() {
		return logradouro_curto;
	}
	public void setLogradouro_curto(String logradouro_curto) {
		this.logradouro_curto = logradouro_curto;
	}	
	
	

}
