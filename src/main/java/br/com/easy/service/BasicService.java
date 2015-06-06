package br.com.easy.service;

public abstract class BasicService {
	
	private String[]types = {"jpg","png","jpeg"};
	private final long bytesPermitidos = 5000000;

	public BasicService() {
		
		
		
	}

	

	public boolean isImagemValida(String url){
	  
		for (String type : types) {
			 if(url.endsWith(type)){
				 
				 return true;
				 
				 
			 }
					
		}
	
		return false;
		
		
	}
	
	
	public boolean isTamanhomaximoPermitido(long bytes){
		
		if(bytes < bytesPermitidos){
			
			 return true;
			
		}
		
		
		return false;
		
		
		
	}
	
	
	
	public String[] getTypes() {
		return types;
	}

	public void setTypes(String[] types) {
		this.types = types;
	}



	public long getBytesPermitidos() {
		return bytesPermitidos;
	}

}
