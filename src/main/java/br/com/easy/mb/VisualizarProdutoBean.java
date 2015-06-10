package br.com.easy.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.easy.model.Anuncio;
import br.com.easy.service.AnuncioService;

@Named
@ConversationScoped
public class VisualizarProdutoBean extends BasicBean implements Serializable {


	private static final long serialVersionUID = 1L;
	
     @Inject
	private Anuncio anuncio;
	@Inject
	AnuncioService service;
	@Inject
    private Conversation conversation;
	
	
	@PostConstruct
	public void init(){
	
	System.out.println("iniciando");
	
      beginConversation();
		
	
	}
	
	@PreDestroy
	public void release(){
		System.out.println("Fim");
		endConversation();
		
		
	}
	
	public String Visualizacao(){
		
		this.anuncio.setVisualizacao(this.anuncio.getVisualizacao()+1);
		service.addVisualizacaoAnuncio(anuncio);
		return "visualizarAnuncio?faces-redirect=true";
		
		
	}
	
	
	public void beginConversation(){
		
		if(this.conversation.isTransient()){
			
			this.conversation.begin();
			
		}
		
	}
	
	
	public void endConversation(){
		
		if(!this.conversation.isTransient()){
			
			this.conversation.end();
			
		}
		
	}
	

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

	

}
