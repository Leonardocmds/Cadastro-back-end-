package br.com.angularrest.angularrest.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;


import br.com.angularrest.angularrest.repository.ClienteReposotory;

@Entity
public class Cliente {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@CPF @NotBlank
	private String cpf;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String endereco;
	
	@NotNull @JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;
	
	

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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Cliente atualizar(Long id, ClienteReposotory transferenciaRepository) {
		Cliente transf = transferenciaRepository.getOne(id);
		
		transf.setNome(this.nome);
		transf.setCpf(this.cpf);
		transf.setEmail(this.email);
		transf.setEndereco(this.endereco);
		transf.setDataNascimento(this.dataNascimento);
		
		return transf;
		
	}

}
