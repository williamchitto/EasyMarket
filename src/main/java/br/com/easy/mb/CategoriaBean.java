package br.com.easy.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.easy.model.Categoria;
import br.com.easy.service.CategoriaService;

@Named
@RequestScoped
public class CategoriaBean extends BasicBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoriaService service;
	
	
	public Categoria buscarCategoriaByCodigo(int codigo){
		
		
		return service.categoriaServiceById(codigo);
		
		
	}

	public CategoriaService getService() {
		return service;
	}

	public void setService(CategoriaService service) {
		this.service = service;
	}
	

}
