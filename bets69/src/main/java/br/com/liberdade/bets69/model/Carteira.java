package br.com.liberdade.bets69.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "carteiras")
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Relacionamento com a entidade User

    @Column(nullable = false)
    private BigDecimal saldoDisponivel;  // Saldo disponível para saques e apostas

    @Column(nullable = false)
    private BigDecimal saldoBloqueado;  // Saldo bloqueado por apostas em andamento

    // Construtor padrão
    public Carteira() {
        this.saldoDisponivel = BigDecimal.ZERO;  // Saldo inicial disponível
        this.saldoBloqueado = BigDecimal.ZERO;  // Saldo inicial bloqueado
    }

    // Construtor com parâmetros
    public Carteira(User user, BigDecimal saldoDisponivel, BigDecimal saldoBloqueado) {
        this.user = user;
        this.saldoDisponivel = saldoDisponivel;
        this.saldoBloqueado = saldoBloqueado;
    }

    // Métodos para gerenciar o saldo
    public void adicionarSaldo(BigDecimal valor) {
        this.saldoDisponivel = this.saldoDisponivel.add(valor);  // Adiciona saldo disponível
    }

    public void bloquearSaldo(BigDecimal valor) {
        if (this.saldoDisponivel.compareTo(valor) >= 0) {
            this.saldoDisponivel = this.saldoDisponivel.subtract(valor);  // Subtrai do saldo disponível
            this.saldoBloqueado = this.saldoBloqueado.add(valor);  // Adiciona ao saldo bloqueado
        } else {
            throw new IllegalArgumentException("Saldo insuficiente para bloquear.");
        }
    }

    public void liberarSaldoBloqueado(BigDecimal valor) {
        if (this.saldoBloqueado.compareTo(valor) >= 0) {
            this.saldoBloqueado = this.saldoBloqueado.subtract(valor);  // Subtrai do saldo bloqueado
            this.saldoDisponivel = this.saldoDisponivel.add(valor);  // Adiciona ao saldo disponível
        } else {
            throw new IllegalArgumentException("Valor a liberar excede o saldo bloqueado.");
        }
    }

    public void deduzirSaldo(BigDecimal valor) {
        if (this.saldoDisponivel.compareTo(valor) >= 0) {
            this.saldoDisponivel = this.saldoDisponivel.subtract(valor);  // Deduz do saldo disponível
        } else {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
    }

    
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
