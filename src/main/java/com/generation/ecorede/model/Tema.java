package com.generation.ecorede.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //create table
@Table(name = "tb_temas")
public class Tema {
	
	 
		@Id // Primary Key id
		@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
		private Long id;
			
		@NotBlank(message = "O atributo topico é obrigatório!")
		@Size(min = 5, max = 155, message = "O atributo topico deve conter no min 5 letras e no maximo 155")
		private String topico;
			
		@NotBlank(message = "O atributo descrição é obrigatório!")
		@Size(min = 10, max = 1000, message = "O atributo descrição deve conter no min 10 letras e no maximo 1000")
		private String descricao;
		
		@OneToMany(mappedBy = "tema", cascade = CascadeType.REMOVE)
		@JsonIgnoreProperties("tema")
		private List<Postagem> postagem;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTopico() {
			return topico;
		}

		public void setTopico(String topico) {
			this.topico = topico;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public List<Postagem> getPostagem() {
			return postagem;
		}

		public void setPostagem(List<Postagem> postagem) {
			this.postagem = postagem;
		}

}