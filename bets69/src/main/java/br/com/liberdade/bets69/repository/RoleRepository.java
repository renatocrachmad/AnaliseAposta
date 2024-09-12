package br.com.liberdade.bets69.repository;

import java.util.Optional;
import br.com.liberdade.bets69.model.Role;
import br.com.liberdade.bets69.records.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(RoleEnum name);
}

