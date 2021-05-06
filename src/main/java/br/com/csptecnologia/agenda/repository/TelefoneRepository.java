package br.com.csptecnologia.agenda.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import br.com.csptecnologia.agenda.model.Telefone;

public interface TelefoneRepository extends JpaRepositoryImplementation<Telefone, Long> {

}
