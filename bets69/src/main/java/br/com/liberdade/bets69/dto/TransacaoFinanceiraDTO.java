package br.com.liberdade.bets69.dto;

import br.com.liberdade.bets69.records.TransactionType;
import br.com.liberdade.bets69.records.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoFinanceiraDTO {

    private Long id;
    private Long userId;
    private TransactionType tipo;
    private BigDecimal valor;
    private LocalDateTime dataTransacao;
    private TransactionStatus status;

    // Construtor padrão
    public TransacaoFinanceiraDTO() {
    }

    // Construtor com parâmetros
    public TransacaoFinanceiraDTO(Long id, Long userId, TransactionType tipo, BigDecimal valor, LocalDateTime dataTransacao, TransactionStatus status) {
        this.id = id;
        this.userId = userId;
        this.tipo = tipo;
        this.valor = valor;
        this.dataTransacao = dataTransacao;
        this.status = status;
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

    public TransactionType getTipo() {
        return tipo;
    }

    public void setTipo(TransactionType tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDateTime dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }
}
