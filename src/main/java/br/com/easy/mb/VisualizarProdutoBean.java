package br.com.easy.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.easy.model.Anuncio;

@Named
@ViewScoped
public class VisualizarProdutoBean extends BasicBean implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Inject
	private Anuncio anuncio;
	
	
	
	@PostConstruct
	public void init(){
		
	
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	

}
