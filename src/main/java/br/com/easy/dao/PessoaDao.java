package br.com.easy.dao;

import br.com.easy.model.Pessoa;

public interface PessoaDao {
	
	public void salvarPessoa(Pessoa pessoa);
	public Pessoa pessoaById(int id);
	public Pessoa pessoaByEmail(String email);
	public Pessoa pessoaByCpf(String cpf);
    
}
