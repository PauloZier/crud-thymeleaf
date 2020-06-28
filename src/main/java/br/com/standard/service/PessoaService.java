package br.com.standard.service;

import java.util.List;

import br.com.standard.entity.Pessoa;

public interface PessoaService {

	Pessoa save(Pessoa pessoa);
	
	Boolean delete(Long id);
	
	Pessoa findById(Long id);
	
	List<Pessoa> findAll();
}
