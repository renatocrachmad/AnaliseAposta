package br.com.liberdade.bets69.repository;

import br.com.liberdade.bets69.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    // Métodos adicionais podem ser definidos aqui, se necessário
}
