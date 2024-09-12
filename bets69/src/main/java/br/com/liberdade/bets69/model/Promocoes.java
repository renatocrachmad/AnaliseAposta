package br.com.liberdade.bets69.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "promocoes")
public class Promocoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;  // Nome da promoção (ex: "Bônus de Boas-Vindas", "Promoção de Fim de Semana")

    @Column(nullable = false, length = 1000)
    private String descricao;  // Descrição detalhada da promoção

    @Column(nullable = false)
    private BigDecimal valorBonus;  // Valor do bônus oferecido

    @Column(nullable = false)
    private LocalDateTime dataValidade;  // Data e hora até quando a promoção é válida

    // Construtor padrão
    public Promocoes() {
    }

    // Construtor com parâmetros
    public Promocoes(String nome, String descricao, BigDecimal valorBonus, LocalDateTime dataValidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.valorBonus = valorBonus;
        this.dataValidade = dataValidade;
    }

    // Métodos para verificar se a promoção está válida
    public boolean isValida() {
        return LocalDateTime.now().isBefore(dataValidade);  // Verifica se a promoção ainda está válida
    }

    // Getters e Setters adicionais
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorBonus() {
        return valorBonus;
    }

    public void setValorBonus(BigDecimal valorBonus) {
        this.valorBonus = valorBonus;
    }

    public LocalDateTime getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDateTime dataValidade) {
        this.dataValidade = dataValidade;
    }
}
