package br.com.csptecnologia.agenda.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
@Table(name="tbl_pessoas")
@ApiModel(value = "Pessoa", description = "Modelo para mostrar detalhes das Pessoas da Agenda ")
public class Pessoa {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String sobrenome;
	private String email;
	
	  @OneToMany( targetEntity = Telefone.class, fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	  
	  @JoinColumn(name = "pessoa_id") // Esta coluna está na tabela "telefone".
	  private List<Telefone> telefones;
	 
	
	
}
