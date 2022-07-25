package br.com.angularrest.angularrest.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ClienteDto {

	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private String endereco;
	
	@NotNull @JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;
	
	public ClienteDto (Cliente transf) {
		this.id = transf.getId();
		this.nome = transf.getNome();
		this.cpf = transf.getCpf();
		this.email = transf.getEmail();
		this.endereco = transf.getEndereco();
		this.dataNascimento = transf.getDataNascimento();
	}

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
	
	public static List<ClienteDto> converter(List<Cliente> transf) {
		return transf.stream().map(ClienteDto::new).collect(Collectors.toList());
	}
}
