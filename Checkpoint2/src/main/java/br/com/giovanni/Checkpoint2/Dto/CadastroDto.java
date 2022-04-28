package br.com.giovanni.Checkpoint2.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CadastroDto {
	private Long id;
	
	@NotNull
	@NotBlank
	private String login;
	
	@NotNull
	@NotBlank
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
