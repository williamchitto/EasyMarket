package br.com.easy.dao;

import java.util.List;

import br.com.easy.model.Empresa;
import br.com.easy.model.PlanoEmpresa;
import br.com.easy.model.Planos;

public interface PlanoEmpresaDao {
	
	public PlanoEmpresa buscarPlanoByEmpresaValido(Empresa empresa);
	public List<Planos>listplanos();
	public void salvar(PlanoEmpresa planoEmpresa);
	public Planos findPlanoByid(int id);

}
