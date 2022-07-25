package br.com.angularrest.angularrest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.angularrest.angularrest.model.Usuario;
import br.com.angularrest.angularrest.model.UsuarioDto;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario>findByEmail(String email);


}
