package br.com.liberdade.bets69.dto;

import br.com.liberdade.bets69.model.Role;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class UserDTO {

	private Long id;
	private String username;
	private String nome;
	private String email;
	private BigDecimal saldo;
	private LocalDateTime dataCadastro;
	private Set<Role> roles;

	public UserDTO() {
	}

	public UserDTO(Long id, String username, String nome, String email, BigDecimal saldo, LocalDateTime dataCadastro,
			Set<Role> roles) {
		this.id = id;
		this.username = username;
		this.nome = nome;
		this.email = email;
		this.saldo = saldo;
		this.dataCadastro = dataCadastro;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
