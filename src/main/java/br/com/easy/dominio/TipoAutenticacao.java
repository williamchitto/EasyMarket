package br.com.easy.dominio;

public enum TipoAutenticacao {
LOGIN(1),RECUPERACAO(2);
	
	private final int valor;
	
	private TipoAutenticacao(int valor) {
	 
		this.valor =valor;
	}

	public int getValor() {
		return valor;
	}
	
	
}
