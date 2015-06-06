package br.com.easy.dominio;

public enum StatusValidacaoAutenticacao {
	
	VALIDADO(1),NAO_VALIDADO(2),EXPIRADO(3);
	
	private final int valor;
	
	private StatusValidacaoAutenticacao(int valor) {
		
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
	

}
