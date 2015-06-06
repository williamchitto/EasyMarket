package br.com.easy.dao;

import br.com.easy.model.Empresa;

public interface EmpresaDao {
	
	public void addEmpresa(Empresa empresa);
	public void removeEmpresa(int id);
	public void updateEmpresa(Empresa empresa);
	public void listEmpresa();
	public Empresa findEmpresa(int id);
	public Empresa buscarEmpresaPorCnpj(String cnpj);
	public Empresa buscarEmpresaPorEmail(String email);
	
	
	

}
