package br.com.easy.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.com.easy.model.Anuncio;
import br.com.easy.service.AnuncioService;

@Named
@ViewScoped
public class ListAllAnunciosBean extends BasicBean implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	private List<Anuncio>anuncios = new ArrayList<Anuncio>();
	@Inject
	AnuncioService service;
	private Anuncio anuncioSelected;
	
	@PostConstruct
	public void init(){
		
		this.anuncios = service.listAllAnunciosService();
		
		
	}
	

	public List<Anuncio> getAnuncios() {
		return anuncios;
	}


	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}


	public Anuncio getAnuncioSelected() {
		return anuncioSelected;
	}


	public void setAnuncioSelected(Anuncio anuncioSelected) {
		this.anuncioSelected = anuncioSelected;
	}
	
	 public void onRowSelect(SelectEvent event) {
	        FacesMessage msg = new FacesMessage("Anuncio Selecionado");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	
	

}
