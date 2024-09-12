package br.com.liberdade.bets69.dto;

import java.io.Serializable;

public class AdminDTO implements Serializable {
    private Long id;
    private Long userId; // Referência ao usuário associado
    private boolean gerenciarEventos;
    private boolean gerenciarApostas;
    private boolean gerenciarUsuarios;

   
    public AdminDTO() {
    }

    
    public AdminDTO(Long id, Long userId, boolean gerenciarEventos, boolean gerenciarApostas, boolean gerenciarUsuarios) {
        this.id = id;
        this.userId = userId;
        this.gerenciarEventos = gerenciarEventos;
        this.gerenciarApostas = gerenciarApostas;
        this.gerenciarUsuarios = gerenciarUsuarios;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
