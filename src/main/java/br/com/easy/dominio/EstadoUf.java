package br.com.easy.dominio;

public enum EstadoUf {
	 AC("Acre"), AL("Alagoas"), AP("Amapá"), AM("Amazonas"), BA("Bahia"), CE("Ceará"), DF("Distrito Federal"), 
	 ES("Espírito Santo"), GO("Goiás"), MA("Maranhão"), MT("Mato Grosso"), MS("Mato Grosso do sul"), MG("Minas Gerais"),
	    PA("Pará"), PB("Paraíba"), PR("Paraná"), PE("Pernambuco"), 
	    PI("Piauí"), RJ("Rio de Janeiro"), RN("Rio Grande do Norte"), RS("Rio grande do Sul"), RO("Rondônia"),
	    RR("Roraima"), SC("Santa Catarina"), SP("São Paulo"), SE("Sergipe"),
	    TO("Tocantins");
	 
	 private final String valor;
	 private EstadoUf(String valor) {
	 
		 this.valor = valor;
		 
		 
	}
	public String getValor() {
		return valor;
	}
	 
	 
	 

	
}