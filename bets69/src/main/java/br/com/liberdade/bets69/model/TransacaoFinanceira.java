package br.com.liberdade.bets69.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.liberdade.bets69.records.TransactionType;
import br.com.liberdade.bets69.records.TransactionStatus;  
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "transactions")
public class TransacaoFinanceira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Relacionamento com a entidade User

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType tipo;  // Tipo de transação (depósito, saque, aposta)

    @Column(nullable = false)
    private BigDecimal valor;  // Valor da transação

    @Column(nullable = false)
    private LocalDateTime dataTransacao;  // Data da transação

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status;  // Status da transação (concluído, pendente)

    // Construtor padrão
    public TransacaoFinanceira() {
        this.dataTransacao = LocalDateTime.now();  // Atribui a data e hora atual
        this.status = TransactionStatus.PENDENTE;  // Status inicial
    }

    // Construtor com parâmetros
    public TransacaoFinanceira(User user, TransactionType tipo, BigDecimal valor, TransactionStatus status) {
        this.user = user;
        this.tipo = tipo;
        this.valor = valor;
        this.dataTransacao = LocalDateTime.now();
        this.status = status;
    }

    // Getters e Setters adicionais
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
