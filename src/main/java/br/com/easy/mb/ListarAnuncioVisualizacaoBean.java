package br.com.easy.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.easy.model.Anuncio;
import br.com.easy.service.AnuncioService;

@Named
@ViewScoped
public class ListarAnuncioVisualizacaoBean extends BasicBean implements Serializable {

	private static final long serialVersionUID = 1L;

@Inject
private Anuncio anuncio;
private List<Anuncio>Anuncios = new ArrayList<Anuncio>();
private List<Anuncio>anunciosPorData= new ArrayList<Anuncio>();
@Inject
AnuncioService service;

   @PostConstruct
   public void init(){
	 
	  this.Anuncios = service.listarAnuncioVisualizacaoService(); 
	  this.anunciosPorData = service.listarAnuncioRecentesService();
	   
   }

   
  
public Anuncio getAnuncio() {
	return anuncio;
}

public void setAnuncio(Anuncio anuncio) {
	this.anuncio = anuncio;
}

public List<Anuncio> getAnuncios() {
	return Anuncios;
}

public void setAnuncios(List<Anuncio> anuncios) {
	Anuncios = anuncios;
}



public List<Anuncio> getAnunciosPorData() {
	return anunciosPorData;
}



public void setAnunciosPorData(List<Anuncio> anunciosPorData) {
	this.anunciosPorData = anunciosPorData;
}	
	
	
	
	
	
	
	

}
