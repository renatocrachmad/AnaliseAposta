package br.com.liberdade.bets69.dto;

import br.com.liberdade.bets69.model.User;

public class JogoDTO {

    private Long id;
    private String nome;
    private User autor;

    // Construtor padrão
    public JogoDTO() {
    }

    // Construtor com parâmetros
    public JogoDTO(Long id, String nome, User autor) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
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

    public User getAutor() {
        return autor;
    }

    public void setAutor(User autor) {
        this.autor = autor;
    }
}
