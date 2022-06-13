package com.generation.ecorede.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //create table
@Table(name = "tb_postagens") //tb_postagens
public class Postagem {
	
	@Id // Primary Key id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private Long id;
	
	@NotBlank(message = "O atributo título é obrigatório!")
	@Size(min = 5, max = 155, message = "O atributo titulo deve conter no min 5 letras e no maximo 155")
	private String titulo;
	
	@NotBlank(message = "O atributo texto é obrigatório!")
	@Size(min = 10, max = 1000, message = "O atributo texto deve conter no min 10 letras e no maximo 1000")
	private String texto;
	
	@Size(min = 5, max = 1000, message = "O atributo midia deve conter no min 5 letras e no maximo 1000")
	private String midia;
	
	@UpdateTimestamp
	private LocalDateTime data;
	
	@NotBlank(message = "O atributo regiões é obrigatório!")
	@Size(min = 5, max = 100, message = "O atributo regiões deve conter no min 5 letras e no maximo 100")
	private String regioes;
	
	@Column(columnDefinition = "integer default 0")
    private int curtir;

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getMidia() {
		return midia;
	}

	public void setMidia(String midia) {
		this.midia = midia;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getRegioes() {
		return regioes;
	}

	public void setRegioes(String regioes) {
		this.regioes = regioes;
	}

	public int getCurtir() {
		return curtir;
	}

	public void setCurtir(int curtir) {
		this.curtir = curtir;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
