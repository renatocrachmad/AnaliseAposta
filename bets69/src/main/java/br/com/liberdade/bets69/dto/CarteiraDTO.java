package br.com.liberdade.bets69.dto;

import java.math.BigDecimal;

public class CarteiraDTO {
    private Long id;
    private Long userId;
    private BigDecimal saldoDisponivel;
    private BigDecimal saldoBloqueado;

    public CarteiraDTO() {
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

    public BigDecimal getSaldoDisponivel() {
        return saldoDisponivel;
    }

    public void setSaldoDisponivel(BigDecimal saldoDisponivel) {
        this.saldoDisponivel = saldoDisponivel;
    }

    public BigDecimal getSaldoBloqueado() {
        return saldoBloqueado;
    }

    public void setSaldoBloqueado(BigDecimal saldoBloqueado) {
        this.saldoBloqueado = saldoBloqueado;
    }
}
