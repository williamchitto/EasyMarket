package br.com.easy.dominio;

public enum StatusAnuncio {
	
	ATIVO(1),NAO_ATIVO(2);
	
	private final int valor;
	
	private StatusAnuncio(int valor) {
		
		this.valor = valor;
		
	}

	public int getValor() {
		return valor;
	}
	
}
