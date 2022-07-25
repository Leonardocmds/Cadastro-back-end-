package br.com.angularrest.angularrest.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.angularrest.angularrest.model.Cliente;
import br.com.angularrest.angularrest.model.ClienteDto;
import br.com.angularrest.angularrest.repository.ClienteReposotory;
import br.com.angularrest.angularrest.security.TokenService;

@RestController
@RequestMapping("/cadastro")
public class ClientesController {

	@Autowired
	private ClienteReposotory clienteReposotory;
	
	@Autowired
	private TokenService tokenService;

	@Autowired
	private AuthenticationManager authmanager;
	
	private Cliente xd;

	@PostMapping
	public void cadastrar(@RequestBody @Valid Cliente cliente) {
		clienteReposotory.save(cliente);

	}

	@GetMapping("/{cpf}")
		public ResponseEntity<ClienteDto> acharPeloCpf(@PathVariable String cpf) {
		Optional<Cliente> transf = clienteReposotory.findByCpf(cpf);
		if(transf.isPresent()) {
			return ResponseEntity.ok(new ClienteDto(transf.get()));
		}
 		return null;
	}
	
	
	@GetMapping
	public List<Cliente> listar(Cliente transfe) {
		List<Cliente> findAll = clienteReposotory.findAll();
		return findAll;
	}
	
	@GetMapping("/nome/{id}")
	public Optional<Cliente> pesquisarNome(@PathVariable Long id) {
		Optional<Cliente> findNome = clienteReposotory.findById(id);
		return findNome;
	}
	
	@PutMapping("edita/{id}")
	@Transactional
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody @Valid Cliente form){
		Optional<Cliente> optional = clienteReposotory.findById(id);
		if(optional.isPresent()) {
			Cliente cliente = form.atualizar(id, clienteReposotory);
			return ResponseEntity.ok(cliente);
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/exclui/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Cliente> optional = clienteReposotory.findById(id);
		if(optional.isPresent()) {
			clienteReposotory.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}
	
	
	
			

	
	
	
	
	
}
