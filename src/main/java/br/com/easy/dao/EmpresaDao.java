package br.com.easy.dao;

import java.util.List;

import br.com.easy.model.Empresa;

public interface EmpresaDao {
	
	public void addEmpresa(Empresa empresa);
	public void removeEmpresa(int id);
	public void updateEmpresa(Empresa empresa);
	public List<Empresa> listEmpresa();
	public Empresa findEmpresa(int id);
	public Empresa buscarEmpresaPorCnpj(String cnpj);
	public Empresa buscarEmpresaPorEmail(String email);
	
	
	

}
