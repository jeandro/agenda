package br.com.csptecnologia.agenda.resource;

import java.util.List;
import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import br.com.csptecnologia.agenda.model.Pessoa;
import br.com.csptecnologia.agenda.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestControllerAdvice
@RequestMapping("/pessoa")
@Api(value = "/pessoa")
public class PessoaResource {
	
	@Autowired
	private PessoaService pessoaService;
	
	@ApiOperation(value = "Busca todas as Pessoas ", notes = "Este Metodo busca todas as Pessoas no Banco de Dados.")
	@GetMapping("todos")
	public List<Pessoa> listar() {
		return pessoaService.listar();
	}
	
	@ApiOperation(value = "Cria uma nova Pessoa ", notes = "Este Metodo cria uma Pessoa no Banco de Dados.")
	@PostMapping
	public ResponseEntity<Pessoa> criar(@RequestBody Pessoa pessoa, HttpServletResponse response) {
			Pessoa pessoaSalva = pessoaService.salva(pessoa);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(pessoaSalva.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(pessoaSalva);
	}
	
	@ApiOperation(value = "Atualizar uma Pessoa ", notes = "Este Metodo atualiza uma Pessoa no Banco de Dados.")
	@PutMapping
	public ResponseEntity<Pessoa> SalvarouAtualizar(@RequestBody Pessoa pessoa, HttpServletResponse response) {
		
		Pessoa pessoaAtualiza = pessoaService.atualizar(pessoa);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(pessoaAtualiza.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(pessoaAtualiza);
	}
	
	@ApiOperation(value = "Deleta a Pessoa pelo Codigo" , notes = "Este Metodo exclui a Pessoa do Banco de Dados.")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long Id) {
		pessoaService.remover(Id);
	}
	

}
