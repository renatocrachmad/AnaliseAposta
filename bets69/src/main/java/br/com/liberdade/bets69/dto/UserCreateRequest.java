package br.com.liberdade.bets69.dto;

import br.com.liberdade.bets69.records.RoleEnum;

public class UserCreateRequest {
    private String username;
    private String password;
    private RoleEnum role;

    public UserCreateRequest() {
    }

    public UserCreateRequest(String username, String password, RoleEnum role) {
        this.username = username;
        this.password = password;
        this.role = role;
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

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}
