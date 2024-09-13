package br.com.liberdade.bets69.repository;

import br.com.liberdade.bets69.model.EventoEsportivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoEsportivoRepository extends JpaRepository<EventoEsportivo, Long> {
}
