package br.com.liberdade.bets69.repository;

import br.com.liberdade.bets69.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
    
}
