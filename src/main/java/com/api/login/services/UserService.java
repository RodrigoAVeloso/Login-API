package com.api.login.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.login.entity.UserEntity;
import com.api.login.entity.dtos.UserDTO;
import com.api.login.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<UserEntity> getAll() {
		return repository.findAll();
	}

	public Optional<UserEntity> getOne(Integer id) {
		return repository.findById(id);
	}

	public UserEntity create(@Valid UserDTO dto) {
		return repository.save(new UserEntity(dto));
	}
}
