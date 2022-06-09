package com.generation.ecorede.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity //create table
@Table(name = "tb_usuarios")
public class Usuario {
	
	@Id // Primary Key id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private Long id;
	
	@Schema(example = "email@email.com")
	@Email(message = "O atributo Usuário deve ser um email válido!")
	@NotBlank(message = "O atributo usuario é obrigatório!")
	@Size(min = 5, max = 255, message = "O atributo usuario deve conter no min 5  letras e no maximo 255")
	private String usuario;
	
	@NotBlank(message = "O atributo senha é obrigatório!")
	@Size(min = 8, message = "O atributo senha deve conter no min 8 caracteres.")
	private String senha;
	
	@NotBlank(message = "O atributo nome é obrigatório!")
	@Size(min = 2, max = 100, message = "O atributo nome deve conter no min 5 letras e no maximo 255")
	private String nome;
	
	private String foto;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
}