package br.com.liberdade.bets69.dto;

import br.com.liberdade.bets69.model.User;

import java.time.LocalDateTime;

public class NotificacoesDto {

    private Long id;
    private User usuario;
    private String mensagem;
    private boolean lida;
    private LocalDateTime dataEnvio;

    // Construtor padrão
    public NotificacoesDto() {
    }

    // Construtor com parâmetros
    public NotificacoesDto(Long id, User usuario, String mensagem, boolean lida, LocalDateTime dataEnvio) {
        this.id = id;
        this.usuario = usuario;
        this.mensagem = mensagem;
        this.lida = lida;
        this.dataEnvio = dataEnvio;
    }

    // Getters e Setters
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
