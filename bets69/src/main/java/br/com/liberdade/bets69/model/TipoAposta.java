package br.com.liberdade.bets69.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tipo_aposta")
public class TipoAposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;  // Nome do tipo de aposta (ex: simples, múltipla, sistema)

    @Column(nullable = false)
    private boolean simples;  // Indica se a aposta é do tipo simples

    @Column(nullable = false)
    private boolean multipla;  // Indica se a aposta é do tipo múltipla

    @Column(nullable = false)
    private boolean sistema;  // Indica se a aposta é do tipo sistema

    @Column(length = 500)
    private String descricao;  // Descrição do tipo de aposta

    // Construtor padrão
    public TipoAposta() {
    }

    // Construtor com parâmetros
    public TipoAposta(String nome, boolean simples, boolean multipla, boolean sistema, String descricao) {
        this.nome = nome;
        this.simples = simples;
        this.multipla = multipla;
        this.sistema = sistema;
        this.descricao = descricao;
    }

    
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

    public boolean isSimples() {
        return simples;
    }

    public void setSimples(boolean simples) {
        this.simples = simples;
    }

    public boolean isMultipla() {
        return multipla;
    }

    public void setMultipla(boolean multipla) {
        this.multipla = multipla;
    }

    public boolean isSistema() {
        return sistema;
    }

    public void setSistema(boolean sistema) {
        this.sistema = sistema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
