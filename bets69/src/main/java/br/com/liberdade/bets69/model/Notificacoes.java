package br.com.liberdade.bets69.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notificacoes")
public class Notificacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User usuario;  // Relacionamento com a entidade User (o destinatário da notificação)

    @Column(nullable = false, length = 500)
    private String mensagem;  // Conteúdo da notificação

    @Column(nullable = false)
    private boolean lida;  // Indica se a notificação já foi lida

    @Column(nullable = false)
    private LocalDateTime dataEnvio;  // Data e hora em que a notificação foi enviada

    // Construtor padrão
    public Notificacoes() {
        this.lida = false;  // Inicializa como não lida
        this.dataEnvio = LocalDateTime.now();  // Atribui a data e hora atual
    }

    // Construtor com parâmetros
    public Notificacoes(User usuario, String mensagem) {
        this.usuario = usuario;
        this.mensagem = mensagem;
        this.lida = false;  // Inicializa como não lida
        this.dataEnvio = LocalDateTime.now();
    }

    // Métodos para marcar como lida
    public void marcarComoLida() {
        this.lida = true;
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

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isLida() {
        return lida;
    }

    public void setLida(boolean lida) {
        this.lida = lida;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
}
