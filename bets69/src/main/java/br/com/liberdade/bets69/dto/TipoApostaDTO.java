package br.com.liberdade.bets69.dto;

public class TipoApostaDTO {

    private Long id;
    private String nome;
    private boolean simples;
    private boolean multipla;
    private boolean sistema;
    private String descricao;

   
    public TipoApostaDTO() {
    }

  
    public TipoApostaDTO(Long id, String nome, boolean simples, boolean multipla, boolean sistema, String descricao) {
        this.id = id;
        this.nome = nome;
        this.simples = simples;
        this.multipla = multipla;
        this.sistema = sistema;
        this.descricao = descricao;
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
