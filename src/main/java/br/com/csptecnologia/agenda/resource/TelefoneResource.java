package br.com.csptecnologia.agenda.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import br.com.csptecnologia.agenda.model.Telefone;
import br.com.csptecnologia.agenda.service.TelefoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestControllerAdvice
@RequestMapping("/telefone")
@Api(value = "/telefone")
public class TelefoneResource {
	
	@Autowired
	private TelefoneService telefoneService;
	
	@ApiOperation(value = "Busca todas os telefones ", notes = "Este Metodo busca todas os Telefones no Banco de Dados.")
	@GetMapping("todos")
	public List<Telefone> listar() {
		return telefoneService.listar();
	}
	
	@ApiOperation(value = "Cria uma novo Telefone", notes = "Este Metodo cria um Telefone no Banco de Dados.")
	@PostMapping
	public ResponseEntity<Telefone> criar(@RequestBody Telefone telefone, HttpServletResponse response) {
			Telefone telefoneSalva = telefoneService.salva(telefone);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(telefoneSalva.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(telefoneSalva);
	}
	
	@ApiOperation(value = "Atualizar um Telefone ", notes = "Este Metodo atualiza um Telefone no Banco de Dados.")
	@PutMapping
	public ResponseEntity<Telefone> SalvarouAtualizar(@RequestBody Telefone telefone, HttpServletResponse response) {
		
		Telefone telefoneAtualiza = telefoneService.atualizar(telefone);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(telefoneAtualiza.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(telefoneAtualiza);
	}
	
	@ApiOperation(value = "Deleta o Telefone pelo Codigo" , notes = "Este Metodo exclui o Telefone do Banco de Dados.")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long Id) {
		telefoneService.remover(Id);
	}
	

}
