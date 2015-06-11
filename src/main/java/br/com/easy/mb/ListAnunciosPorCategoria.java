package br.com.easy.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.com.easy.dao.AnuncioDao;
import br.com.easy.model.Anuncio;
import br.com.easy.model.Categoria;

@Named
@ConversationScoped
public class ListAnunciosPorCategoria extends BasicBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Anuncio> anunciosCategoria = new ArrayList<Anuncio>();
	@Inject
	AnuncioDao dao;
	@Inject
	private Anuncio anuncioParameter;
	private Anuncio anuncioSelected;
	private Categoria categoria;
	@Inject
	private Conversation conversation;

	public String preencher() {
		System.out.println("executou");
		this.anunciosCategoria = dao.listAnunOrderByCategoria(categoria);
		return "/listaCategoriaAnuncios?faces-redirect=true";

	}
	

	
	@PostConstruct
	public void init(){
		System.out.println("inicio");
		beginConvesation();
		
		
	}
	
	
	@PreDestroy
	public void destroy(){
		System.out.println("fim");
		endConversation();
		
	}
	
	

	public void beginConvesation() {

		if (this.conversation.isTransient()) {

			this.conversation.begin();

		}

	}
	
	
	public void endConversation(){
		
		
		if(!this.conversation.isTransient()){
			  
			   this.conversation.end();
			
		}
		
	}

	public List<Anuncio> getAnunciosCategoria() {
		return anunciosCategoria;
	}

	public void setAnunciosCategoria(List<Anuncio> anunciosCategoria) {
		this.anunciosCategoria = anunciosCategoria;
	}

	public Anuncio getAnuncioParameter() {
		return anuncioParameter;
	}

	public void setAnuncioParameter(Anuncio anuncioParameter) {
		this.anuncioParameter = anuncioParameter;
	}

	public Anuncio getAnuncioSelected() {
		return anuncioSelected;
	}

	public void setAnuncioSelected(Anuncio anuncioSelected) {
		this.anuncioSelected = anuncioSelected;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Anuncio Selecionado");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

}
