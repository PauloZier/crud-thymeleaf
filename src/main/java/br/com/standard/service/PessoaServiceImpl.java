package br.com.standard.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.standard.entity.Pessoa;
import br.com.standard.repository.PessoaRepository;

@Service
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	@Override
	public Pessoa save(Pessoa p) {
		
		repository.saveAndFlush(p);
		
		return p;
		
	}

	@Override
	public Boolean delete(Long id) {
		
		repository.deleteById(id);
		
		return true;
	}

	@Override
	public Pessoa findById(Long id) {
		
		return repository.findById(id).get();
		
	}

	@Override
	public List<Pessoa> findAll() {
		
		return repository.findAll();
		
	}
	
}
