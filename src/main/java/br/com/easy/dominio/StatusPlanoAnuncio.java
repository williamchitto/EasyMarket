package br.com.easy.dominio;

public enum StatusPlanoAnuncio {
	
	ATIVADO(1),DESATIVADO(2);
	
	private final int valor;
	private StatusPlanoAnuncio(int valor) {
		
	this.valor = valor;	
		
	}
	public int getValor() {
		return valor;
	}

}
