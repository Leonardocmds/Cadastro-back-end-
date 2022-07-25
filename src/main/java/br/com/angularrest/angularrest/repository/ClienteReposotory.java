package br.com.angularrest.angularrest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.angularrest.angularrest.model.Cliente;

public interface ClienteReposotory extends JpaRepository<Cliente, Long> {

	Optional<Cliente> findByCpf(String cpf);
	
	Optional<Cliente> findByNome(String nome);
}
