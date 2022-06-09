package com.generation.ecorede.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.generation.ecorede.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public Optional<Usuario> findByUsuario(String usuario);

}
