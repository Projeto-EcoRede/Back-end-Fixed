package com.generation.ecorede.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.ecorede.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository <Postagem, Long> {
	
	public List <Postagem> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);
	
	boolean existsById(Long id);


	


}
