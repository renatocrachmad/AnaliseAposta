package br.com.liberdade.bets69.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User usuario;  // Relacionamento com a entidade User, representa o administrador

    @Column(nullable = false)
    private boolean gerenciarEventos;  // Privilegio para gerenciar eventos esportivos

    @Column(nullable = false)
    private boolean gerenciarApostas;   // Privilegio para gerenciar apostas

    @Column(nullable = false)
    private boolean gerenciarUsuarios;  // Privilegio para gerenciar usuários

    // Construtor padrão
    public Admin() {
    }

    // Construtor com parâmetros
    public Admin(User usuario, boolean gerenciarEventos, boolean gerenciarApostas, boolean gerenciarUsuarios) {
        this.usuario = usuario;
        this.gerenciarEventos = gerenciarEventos;
        this.gerenciarApostas = gerenciarApostas;
        this.gerenciarUsuarios = gerenciarUsuarios;
    }

    // Métodos para verificar privilégios e gerenciar funções
    public boolean podeGerenciarEventos() {
        return gerenciarEventos;
    }

    public boolean podeGerenciarApostas() {
        return gerenciarApostas;
    }

    public boolean podeGerenciarUsuarios() {
        return gerenciarUsuarios;
    }

    // Métodos para gerenciar eventos, apostas e usuários
    public void gerenciarEventos() {
        if (gerenciarEventos) {
            // Lógica para gerenciar eventos
        } else {
            throw new SecurityException("O administrador não tem privilégios para gerenciar eventos.");
        }
    }

    public void verificarTransacoes() {
        if (gerenciarApostas) {
            // Lógica para verificar transações
        } else {
            throw new SecurityException("O administrador não tem privilégios para gerenciar apostas.");
        }
    }

    public void validarApostas() {
        if (gerenciarApostas) {
            // Lógica para validar apostas
        } else {
            throw new SecurityException("O administrador não tem privilégios para validar apostas.");
        }
    }

    public void gerenciarUsuarios() {
        if (gerenciarUsuarios) {
            // Lógica para gerenciar usuários
        } else {
            throw new SecurityException("O administrador não tem privilégios para gerenciar usuários.");
        }
    }

    // Getters e Setters adicionais
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public boolean isGerenciarEventos() {
        return gerenciarEventos;
    }

    public void setGerenciarEventos(boolean gerenciarEventos) {
        this.gerenciarEventos = gerenciarEventos;
    }

    public boolean isGerenciarApostas() {
        return gerenciarApostas;
    }

    public void setGerenciarApostas(boolean gerenciarApostas) {
        this.gerenciarApostas = gerenciarApostas;
    }

    public boolean isGerenciarUsuarios() {
        return gerenciarUsuarios;
    }

    public void setGerenciarUsuarios(boolean gerenciarUsuarios) {
        this.gerenciarUsuarios = gerenciarUsuarios;
    }
}
