package br.com.liberdade.bets69.repository;

import br.com.liberdade.bets69.model.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
    Optional<Carteira> findByUserId(Long userId);
}
