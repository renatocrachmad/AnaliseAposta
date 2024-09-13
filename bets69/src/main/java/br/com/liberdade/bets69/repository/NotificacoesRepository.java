package br.com.liberdade.bets69.repository;

import br.com.liberdade.bets69.model.Notificacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacoesRepository extends JpaRepository<Notificacoes, Long> {
}
