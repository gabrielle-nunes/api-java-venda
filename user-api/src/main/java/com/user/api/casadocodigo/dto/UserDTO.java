package com.user.api.casadocodigo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import com.user.api.casadocodigo.entities.User;

public class UserDTO {

	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	private String telefone;
	private Date dataCadastro;

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public static UserDTO convert(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setNome(user.getNome());
		userDTO.setEndereco(user.getEndereco());
		userDTO.setCpf(user.getCpf());
		userDTO.setEmail(user.getEmail());
		userDTO.setTelefone(user.getTelefone());
		userDTO.setDataCadastro(user.getDataCadastro());

		return userDTO;

	}

	public static List<UserDTO> usuarios = new ArrayList<UserDTO>();

	@PostConstruct
	public void initiateList() {

		UserDTO userDTO = new UserDTO();
		userDTO.setNome("Gabrielle");
		userDTO.setCpf("123456");
		userDTO.setEndereco("Rua dos Bobos");
		userDTO.setEmail("gabrielle@email.com");
		userDTO.setTelefone("1111-2222");
		userDTO.setDataCadastro(new Date());

		UserDTO userDTO2 = new UserDTO();
		userDTO2.setNome("Maria");
		userDTO2.setCpf("987654");
		userDTO2.setEndereco("Rua 7");
		userDTO2.setEmail("maria@email.com");
		userDTO2.setTelefone("3333-8888");
		userDTO2.setDataCadastro(new Date());

		UserDTO userDTO3 = new UserDTO();
		userDTO3.setNome("Laura");
		userDTO3.setCpf("634851");
		userDTO3.setEndereco("Rua dos 9");
		userDTO3.setEmail("laura@email.com");
		userDTO3.setTelefone("9874-6512");
		userDTO3.setDataCadastro(new Date());

		usuarios.add(userDTO);
		usuarios.add(userDTO2);
		usuarios.add(userDTO3);
	}

}
