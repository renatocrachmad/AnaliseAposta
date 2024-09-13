package br.com.liberdade.bets69.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PromocoesDTO {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal valorBonus;
    private LocalDateTime dataValidade;

    // Construtor padrão
    public PromocoesDTO() {
    }

    // Construtor com parâmetros
    public PromocoesDTO(Long id, String nome, String descricao, BigDecimal valorBonus, LocalDateTime dataValidade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valorBonus = valorBonus;
        this.dataValidade = dataValidade;
    }

    // Getters e Setters
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

    // Método para verificar validade da promoção
    public boolean isValida() {
        return LocalDateTime.now().isBefore(dataValidade);
    }
}
