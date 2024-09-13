package br.com.liberdade.bets69.dto;

import br.com.liberdade.bets69.records.EventStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventoEsportivoDTO {
    private Long id;
    private String esporte;
    private String timeCasa;
    private String timeVisitante;
    private LocalDateTime dataHora;
    private BigDecimal oddsCasa;
    private BigDecimal oddsEmpate;
    private BigDecimal oddsVisitante;
    private EventStatus status;

    public EventoEsportivoDTO() {
    }

    // Getters e Setters
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
