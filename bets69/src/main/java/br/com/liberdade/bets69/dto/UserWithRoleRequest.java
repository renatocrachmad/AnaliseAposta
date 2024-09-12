package br.com.liberdade.bets69.dto;

import br.com.liberdade.bets69.records.RoleEnum;

public class UserWithRoleRequest {
	 private String username;
     private String password;
     private RoleEnum role;

     // Getters e Setters
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


