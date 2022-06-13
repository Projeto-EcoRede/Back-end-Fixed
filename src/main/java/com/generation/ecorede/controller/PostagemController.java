package com.generation.ecorede.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.ecorede.model.Postagem;
import com.generation.ecorede.repository.PostagemRepository;
import com.generation.ecorede.repository.TemaRepository;

@RestController
@RequestMapping("/postagem")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository postagemRepository;
	
	@Autowired
	private TemaRepository temaRepository;
	
	@Autowired
	private PostagemRepository postagemService;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> getAll(){
		return ResponseEntity.ok(postagemRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Postagem> getById(@PathVariable Long id){
		return postagemRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity <List<Postagem>> getByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
		
	}
	
	@PostMapping
	public ResponseEntity<Postagem> postProduto(@Valid @RequestBody Postagem postagem){
		return temaRepository.findById(postagem.getTema().getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem)))
				.orElse(ResponseEntity.badRequest().build());
	}
	
	@PutMapping
	public ResponseEntity<Postagem> putPostagem(@Valid @RequestBody Postagem postagem) {
					
		if (postagemRepository.existsById(postagem.getId())){

			return temaRepository.findById(postagem.getTema().getId())
					.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem)))
					.orElse(ResponseEntity.badRequest().build());
		}		
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/curtir/{id}")
    public ResponseEntity<Postagem> curtirPostagemId (@PathVariable Long id){

        return postagemService.curtir(id)
            .map(resposta-> ResponseEntity.ok(resposta))
            .orElse(ResponseEntity.badRequest().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePostagem(@PathVariable Long id) {
		
		return postagemRepository.findById(id)
				.map(resposta -> { postagemRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
}
