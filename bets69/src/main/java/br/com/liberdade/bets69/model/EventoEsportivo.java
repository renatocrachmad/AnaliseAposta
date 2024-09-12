package br.com.liberdade.bets69.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.liberdade.bets69.records.EventStatus;

@Data
@Entity
@Table(name = "sporting_events")
public class EventoEsportivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String esporte;  // Nome do esporte (ex: futebol, basquete)

    @Column(nullable = false)
    private String timeCasa;  // Nome do time da casa

    @Column(nullable = false)
    private String timeVisitante;  // Nome do time visitante

    @Column(nullable = false)
    private LocalDateTime dataHora;  // Data e hora do evento

    @Column(nullable = false)
    private BigDecimal oddsCasa;  // Odds para o time da casa

    @Column(nullable = false)
    private BigDecimal oddsEmpate;  // Odds para empate (se aplicável)

    @Column(nullable = false)
    private BigDecimal oddsVisitante;  // Odds para o time visitante

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventStatus status;  // Status do evento

    // Construtor padrão
    public EventoEsportivo() {
        this.status = EventStatus.AGENDADO;  // Status inicial
    }

    // Construtor com parâmetros
    public EventoEsportivo(String esporte, String timeCasa, String timeVisitante, LocalDateTime dataHora, BigDecimal oddsCasa, BigDecimal oddsEmpate, BigDecimal oddsVisitante, EventStatus status) {
        this.esporte = esporte;
        this.timeCasa = timeCasa;
        this.timeVisitante = timeVisitante;
        this.dataHora = dataHora;
        this.oddsCasa = oddsCasa;
        this.oddsEmpate = oddsEmpate;
        this.oddsVisitante = oddsVisitante;
        this.status = status;
    }

    // Getters e Setters adicionais
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEsporte() {
        return esporte;
    }

    public void setEsporte(String esporte) {
        this.esporte = esporte;
    }

    public String getTimeCasa() {
        return timeCasa;
    }

    public void setTimeCasa(String timeCasa) {
        this.timeCasa = timeCasa;
    }

    public String getTimeVisitante() {
        return timeVisitante;
    }

    public void setTimeVisitante(String timeVisitante) {
        this.timeVisitante = timeVisitante;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public BigDecimal getOddsCasa() {
        return oddsCasa;
    }

    public void setOddsCasa(BigDecimal oddsCasa) {
        this.oddsCasa = oddsCasa;
    }

    public BigDecimal getOddsEmpate() {
        return oddsEmpate;
    }

    public void setOddsEmpate(BigDecimal oddsEmpate) {
        this.oddsEmpate = oddsEmpate;
    }

    public BigDecimal getOddsVisitante() {
        return oddsVisitante;
    }

    public void setOddsVisitante(BigDecimal oddsVisitante) {
        this.oddsVisitante = oddsVisitante;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }
}
