package br.com.liberdade.bets69.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "system_logs")
public class SystemLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User usuario;  // Relacionamento com a entidade User, representa o usuário que realizou a ação

    @Column(nullable = false, length = 255)
    private String acao;  // Descrição da ação realizada (ex: "Login", "Alteração de senha", "Criação de aposta")

    @Column(nullable = false)
    private LocalDateTime dataHora;  // Data e hora em que a ação foi realizada

    @Column(length = 1000)
    private String detalhes;  // Detalhes adicionais sobre a ação (opcional)

    // Construtor padrão
    public SystemLog() {
        this.dataHora = LocalDateTime.now();  // Atribui a data e hora atual por padrão
    }

    // Construtor com parâmetros
    public SystemLog(User usuario, String acao, String detalhes) {
        this.usuario = usuario;
        this.acao = acao;
        this.dataHora = LocalDateTime.now();  // Atribui a data e hora atual
        this.detalhes = detalhes;
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

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
}
