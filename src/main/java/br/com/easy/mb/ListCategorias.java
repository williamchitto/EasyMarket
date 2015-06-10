package br.com.easy.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.easy.dao.CategoriaDao;
import br.com.easy.model.Categoria;

@Named
@SessionScoped
public class ListCategorias extends BasicBean implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	
	private List<Categoria>categorias = new ArrayList<Categoria>();
	@Inject
	transient CategoriaDao dao;
    
	
    public void preencherCategorias(List<Categoria>categorias){
    	
    	this.categorias = categorias;
    
    }
    
    @PostConstruct
   public void init(){
	 
		   
		   this.categorias = dao.raizes();
		   
	   
    
   }


	public List<Categoria> getCategorias() {
		return categorias;
	}


	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

}
