package br.com.liberdade.bets69.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.liberdade.bets69.records.Status;

public class ApostaDTO {
    private Long id;
    private Long userId;
    private Long eventoEsportivoId;
    private BigDecimal valorApostado;
    private BigDecimal odds;
    private LocalDateTime dataAposta;
    private Status status;
    private String resultado;

    public ApostaDTO() {
    }

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

    public Long getEventoEsportivoId() {
        return eventoEsportivoId;
    }

    public void setEventoEsportivoId(Long eventoEsportivoId) {
        this.eventoEsportivoId = eventoEsportivoId;
    }

    public BigDecimal getValorApostado() {
        return valorApostado;
    }

    public void setValorApostado(BigDecimal valorApostado) {
        this.valorApostado = valorApostado;
    }

    public BigDecimal getOdds() {
        return odds;
    }

    public void setOdds(BigDecimal odds) {
        this.odds = odds;
    }

    public LocalDateTime getDataAposta() {
        return dataAposta;
    }

    public void setDataAposta(LocalDateTime dataAposta) {
        this.dataAposta = dataAposta;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
