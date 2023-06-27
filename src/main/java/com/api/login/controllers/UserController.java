package com.api.login.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.login.entity.UserEntity;
import com.api.login.entity.dtos.UserDTO;
import com.api.login.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOne(@PathVariable Integer id){
		Optional<UserEntity> userOptional = service.getOne(id);
		if(userOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario não encontrado.");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(new UserDTO(userOptional.get()));
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> create(@RequestBody @Valid UserDTO dto, BindingResult br){
		if(br.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar User.");
		}
		if(dto.confirmaSenha(dto.getSenha(), dto.getConfirmarSenha())) {
			service.create(dto);
			return ResponseEntity.status(HttpStatus.CREATED).body("User criado com sucesso!\r");
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar User.");
	}

}
