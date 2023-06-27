package com.api.login.entity.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.api.login.entity.UserEntity;

public class UserDTO {

	
	private Integer id;
	
	@Email(regexp = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$")
	private String email;
	
	@Size(min = 7)
	private String senha;
	
	@Size(min = 7)
	private String confirmarSenha;

	public UserDTO() {}
	
	public UserDTO(UserEntity entity) {
		this.id = entity.getId();
		this.email = entity.getEmail();
		this.senha = entity.getSenha();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}
	
	public Boolean confirmaSenha(String senha, String confirmar) {
		if (senha.equals(confirmar)) {
			return true;
		}
		return false;
	}
	
	
}
