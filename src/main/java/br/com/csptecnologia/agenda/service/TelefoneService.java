package br.com.csptecnologia.agenda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.csptecnologia.agenda.model.Pessoa;
import br.com.csptecnologia.agenda.model.Telefone;
import br.com.csptecnologia.agenda.repository.TelefoneRepository;

@Service
public class TelefoneService {
	
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	public List<Telefone> listar() {
		return telefoneRepository.findAll();
	}

	
	public Telefone salva(Telefone telefone) {
		return telefoneRepository.save(telefone);
	}
	
	public Telefone atualizar(Telefone telefone) {
		return telefoneRepository.save(telefone);
	}

	public void remover(@PathVariable Long Id) {
		telefoneRepository.deleteById(Id);
	}

}
