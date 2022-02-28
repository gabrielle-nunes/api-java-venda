package com.user.api.casadocodigo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.api.casadocodigo.dto.UserDTO;
import com.user.api.casadocodigo.entities.User;
import com.user.api.casadocodigo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserDTO> getAll() {
		List<User> usuarios = userRepository.findAll();

		/*
		 * Transforma a lista em um stream e chama o método map para transformar a lista
		 * de entidades em uma lista de DTOS
		 */
		return usuarios.stream().map(UserDTO::convert).collect(Collectors.toList());
	}

	public UserDTO findById(Long userId) {
		Optional<User> usuario = userRepository.findById(userId);
		if (usuario.isPresent()) {
			return UserDTO.convert(usuario.get());
		}
		return null;
	}

	public UserDTO save(UserDTO userDTO) {
		User user = userRepository.save(User.convert(userDTO));
		return UserDTO.convert(user);
	}

	public UserDTO delete(Long userID) {
		Optional<User> user = userRepository.findById(userID);
		if (user.isPresent()) {
			userRepository.delete(user.get());
		}
		return null;
	}
	
	public UserDTO findByCpf(String cpf) {
		User user = userRepository.findByCpf(cpf);
		if(user != null) {
			return UserDTO.convert(user);
		}
		
		return null;
	}
	
	public List<UserDTO> queryByName(String nome){
		List<User> usuarios = userRepository.queryByNomeLike(nome);
		return usuarios.stream().map(UserDTO::convert).collect(Collectors.toList());
	}

}
