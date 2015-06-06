package br.com.easy.dominio;

public enum TipoOrigemProduto {
	
SISTEMA(1),SISTEMA_ADMIM(2);	
	
private final int valor;

private TipoOrigemProduto(int valor) {

	this.valor = valor;
	
}

public int getValor() {
	return valor;
}
	

}
