package br.com.liberdade.bets69.dto;

import br.com.liberdade.bets69.records.RoleEnum;
import java.util.Set;

public class UserUpdateRequest {
	private String username;
	private String password;
	private Set<RoleEnum> roles;

	public UserUpdateRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserUpdateRequest(String username, String password, Set<RoleEnum> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<RoleEnum> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleEnum> roles) {
		this.roles = roles;
	}

}
