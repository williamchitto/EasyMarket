package br.com.easy.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.easy.model.Empresa;
import br.com.easy.service.EmpresaService;

@Named
@ViewScoped
public class ListEmpresaBean extends BasicBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Empresa empresa;
	private Empresa empresaSelected;
	@Inject
	EmpresaService service;
	private List<Empresa>empresas = new ArrayList<Empresa>();
	
	@PostConstruct
	public void init(){
		
	  this.empresas = service.listEmpresaService();	
		
	}
	
	
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Empresa getEmpresaSelected() {
		return empresaSelected;
	}
	public void setEmpresaSelected(Empresa empresaSelected) {
		this.empresaSelected = empresaSelected;
	}
	public List<Empresa> getEmpresas() {
		return empresas;
	}
	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	
	

}
