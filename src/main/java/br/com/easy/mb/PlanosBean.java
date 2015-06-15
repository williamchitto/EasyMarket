package br.com.easy.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.easy.dao.PlanoEmpresaDao;
import br.com.easy.model.Planos;

@Named
@ViewScoped
public class PlanosBean extends BasicBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	PlanoEmpresaDao dao;
	private List<Planos>planos = new ArrayList<Planos>();
	
	@PostConstruct
	public void init(){
		
		this.planos = dao.listplanos();
		
	}
	
	
	

	
	
	public List<Planos> getPlanos() {
		return planos;
	}
	public void setPlanos(List<Planos> planos) {
		this.planos = planos;
	}

	
	
	
	
}
