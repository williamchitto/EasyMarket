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
import br.com.easy.model.Empresa;
import br.com.easy.service.AnuncioService;

@Named
@ViewScoped
public class ListAnunciosEmpresaBean extends BasicBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private List<Anuncio>anunciosByEmpresa = new ArrayList<Anuncio>();
	@Inject
    private Anuncio anuncio;
    private Anuncio anuncioSelected;
    @Inject
    AnuncioService service;
    @Inject
    UsuarioLogadoBean user;
    private boolean status;
    
    
    @PostConstruct
    public void init (){
    
     Empresa empresa = user.getUsuario().getEmpresa();
     this.anunciosByEmpresa = service.listAnuncioByEmpresaService(empresa);
    
    }
	
    
    public void alterarStatusAnuncio(){
    	
      Anuncio anuncio = service.buscarAnuncioServiceById(this.anuncioSelected.getCodigo());
      anuncio.setStatusAnuncio(this.anuncioSelected.isStatusAnuncio());
      service.alterarAnuncio(anuncio);
    
    	
    }
    	
   

	public List<Anuncio> getAnunciosByEmpresa() {
		return anunciosByEmpresa;
	}


	public void setAnunciosByEmpresa(List<Anuncio> anunciosByEmpresa) {
		this.anunciosByEmpresa = anunciosByEmpresa;
	}


	public Anuncio getAnuncioSelected() {
		return anuncioSelected;
	}


	public void setAnuncioSelected(Anuncio anuncioSelected) {
		this.anuncioSelected = anuncioSelected;
	}


	public Anuncio getAnuncio() {
		return anuncio;
	}


	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}
 
	 public void onRowSelect(SelectEvent event) {
	        FacesMessage msg = new FacesMessage("Anuncio Selecionado");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
