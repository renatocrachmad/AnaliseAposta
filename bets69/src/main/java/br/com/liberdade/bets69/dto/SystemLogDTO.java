package br.com.liberdade.bets69.dto;

import java.time.LocalDateTime;

public class SystemLogDTO {

    private Long id;
    private Long usuarioId;
    private String acao;
    private LocalDateTime dataHora;
    private String detalhes;

    // Construtor padrão
    public SystemLogDTO() {
    }

    // Construtor com parâmetros
    public SystemLogDTO(Long id, Long usuarioId, String acao, LocalDateTime dataHora, String detalhes) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.acao = acao;
        this.dataHora = dataHora;
        this.detalhes = detalhes;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
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
