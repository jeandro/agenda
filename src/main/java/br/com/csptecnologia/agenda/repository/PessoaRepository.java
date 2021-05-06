package br.com.csptecnologia.agenda.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import br.com.csptecnologia.agenda.model.Pessoa;

public interface PessoaRepository extends JpaRepositoryImplementation<Pessoa, Long> {

}
