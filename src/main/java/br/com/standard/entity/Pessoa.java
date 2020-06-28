package br.com.standard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank(message = "Nome é obrigatório")
	@Column(nullable = false, length = 100)
	private String nome;
	
	@NotBlank(message = "Email é obrigatório")
	@Column(nullable = false, length = 120)
	private String email;
	
	private String fone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}
	
	
	
}
