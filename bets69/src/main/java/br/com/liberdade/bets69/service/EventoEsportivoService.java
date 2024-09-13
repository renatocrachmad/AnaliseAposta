package br.com.liberdade.bets69.service;

import br.com.liberdade.bets69.model.EventoEsportivo;
import br.com.liberdade.bets69.repository.EventoEsportivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoEsportivoService {

    private final EventoEsportivoRepository eventoEsportivoRepository;

    @Autowired
    public EventoEsportivoService(EventoEsportivoRepository eventoEsportivoRepository) {
        this.eventoEsportivoRepository = eventoEsportivoRepository;
    }

    // Cria ou atualiza um evento esportivo
    public EventoEsportivo saveEventoEsportivo(EventoEsportivo eventoEsportivo) {
        return eventoEsportivoRepository.save(eventoEsportivo);
    }

    // Busca todos os eventos esportivos
    public List<EventoEsportivo> findAll() {
        return eventoEsportivoRepository.findAll();
    }

    // Busca um evento esportivo pelo ID
    public Optional<EventoEsportivo> findById(Long id) {
        return eventoEsportivoRepository.findById(id);
    }

    // Remove um evento esportivo
    public void deleteById(Long id) {
        eventoEsportivoRepository.deleteById(id);
    }
}
