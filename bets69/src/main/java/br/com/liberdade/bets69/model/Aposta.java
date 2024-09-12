package br.com.liberdade.bets69.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.liberdade.bets69.records.Status;

@Data
@Entity
@Table(name = "bets")
public class Aposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "evento_esportivo_id", nullable = false)
    private EventoEsportivo eventoEsportivo;

    @Column(nullable = false)
    private BigDecimal valorApostado;

    @Column(nullable = false)
    private BigDecimal odds;

    @Column(nullable = false)
    private LocalDateTime dataAposta;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(nullable = true)
    private String resultado;

    // Construtor padrão
    public Aposta() {
        this.dataAposta = LocalDateTime.now();
        this.status = Status.ATIVA;
    }

    // Construtor com parâmetros
    public Aposta(User user, EventoEsportivo eventoEsportivo, BigDecimal valorApostado, BigDecimal odds, Status status, String resultado) {
        this.user = user;
        this.eventoEsportivo = eventoEsportivo;
        this.valorApostado = valorApostado;
        this.odds = odds;
        this.dataAposta = LocalDateTime.now();
        this.status = status;
        this.resultado = resultado;
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

	public EventoEsportivo getEventoEsportivo() {
		return eventoEsportivo;
	}

	public void setEventoEsportivo(EventoEsportivo eventoEsportivo) {
		this.eventoEsportivo = eventoEsportivo;
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
