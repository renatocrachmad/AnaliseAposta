package br.com.liberdade.bets69.controller;

import br.com.liberdade.bets69.dto.EventoEsportivoDTO;
import br.com.liberdade.bets69.model.EventoEsportivo;
import br.com.liberdade.bets69.service.EventoEsportivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos-esportivos")
public class EventoEsportivoController {

    private final EventoEsportivoService eventoEsportivoService;

    @Autowired
    public EventoEsportivoController(EventoEsportivoService eventoEsportivoService) {
        this.eventoEsportivoService = eventoEsportivoService;
    }

    // Cria um novo evento esportivo
    @PostMapping
    public ResponseEntity<EventoEsportivo> createEventoEsportivo(@RequestBody EventoEsportivoDTO eventoEsportivoDTO) {
        EventoEsportivo eventoEsportivo = convertToEntity(eventoEsportivoDTO);
        EventoEsportivo createdEvento = eventoEsportivoService.saveEventoEsportivo(eventoEsportivo);
        return ResponseEntity.ok(createdEvento);
    }

    // Busca todos os eventos esportivos
    @GetMapping
    public ResponseEntity<List<EventoEsportivo>> getAllEventosEsportivos() {
        List<EventoEsportivo> eventos = eventoEsportivoService.findAll();
        return ResponseEntity.ok(eventos);
    }

    // Busca evento esportivo por ID
    @GetMapping("/{id}")
    public ResponseEntity<EventoEsportivo> getEventoEsportivoById(@PathVariable Long id) {
        Optional<EventoEsportivo> eventoEsportivo = eventoEsportivoService.findById(id);
        return eventoEsportivo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualiza um evento esportivo existente
    @PutMapping("/{id}")
    public ResponseEntity<EventoEsportivo> updateEventoEsportivo(@PathVariable Long id, @RequestBody EventoEsportivoDTO eventoEsportivoDTO) {
        Optional<EventoEsportivo> existingEvento = eventoEsportivoService.findById(id);
        if (existingEvento.isPresent()) {
            EventoEsportivo eventoEsportivo = convertToEntity(eventoEsportivoDTO);
            eventoEsportivo.setId(existingEvento.get().getId());
            EventoEsportivo updatedEvento = eventoEsportivoService.saveEventoEsportivo(eventoEsportivo);
            return ResponseEntity.ok(updatedEvento);
        }
        return ResponseEntity.notFound().build();
    }

    // Deleta um evento esportivo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEventoEsportivo(@PathVariable Long id) {
        eventoEsportivoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // Método auxiliar para converter DTO em entidade
    private EventoEsportivo convertToEntity(EventoEsportivoDTO dto) {
        EventoEsportivo eventoEsportivo = new EventoEsportivo();
        eventoEsportivo.setEsporte(dto.getEsporte());
        eventoEsportivo.setTimeCasa(dto.getTimeCasa());
        eventoEsportivo.setTimeVisitante(dto.getTimeVisitante());
        eventoEsportivo.setDataHora(dto.getDataHora());
        eventoEsportivo.setOddsCasa(dto.getOddsCasa());
        eventoEsportivo.setOddsEmpate(dto.getOddsEmpate());
        eventoEsportivo.setOddsVisitante(dto.getOddsVisitante());
        eventoEsportivo.setStatus(dto.getStatus());
        return eventoEsportivo;
    }
}
