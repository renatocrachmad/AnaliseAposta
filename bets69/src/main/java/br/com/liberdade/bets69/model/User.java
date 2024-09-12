package br.com.liberdade.bets69.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nome;  // Novo atributo nome

    @Column(nullable = false, unique = true)
    private String email;  // Novo atributo email

    @Column(nullable = false)
    private BigDecimal saldo;  // Novo atributo saldo

    @Column(nullable = false)
    private LocalDateTime dataCadastro;  // Novo atributo dataCadastro

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_roles", 
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    // Construtor padrão
    public User() {
        this.dataCadastro = LocalDateTime.now();  // Atribui a data atual
        this.saldo = BigDecimal.ZERO;  // Inicia o saldo como 0
    }

    // Construtor com parâmetros
    public User(String username, String password, String nome, String email, BigDecimal saldo, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.email = email;
        this.saldo = saldo;
        this.dataCadastro = LocalDateTime.now();
        this.roles = roles;
    }

    // Getters e Setters adicionais
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
