package br.com.easy.dominio;

public enum OpcoesEntrega {
	
	SIM("Sim"),NAO("Não");
	
	private final String valor;
	
	private OpcoesEntrega(String valor) {
		
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

}
