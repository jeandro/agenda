package br.com.csptecnologia.agenda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.csptecnologia.agenda.model.Pessoa;
import br.com.csptecnologia.agenda.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}
	
	public Pessoa salva(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public Pessoa atualizar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public void remover(@PathVariable Long Id) {
		 pessoaRepository.deleteById(Id);
	}


}
