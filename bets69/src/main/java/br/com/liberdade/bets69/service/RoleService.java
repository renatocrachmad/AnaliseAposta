package br.com.liberdade.bets69.service;

import br.com.liberdade.bets69.model.Role;
import br.com.liberdade.bets69.records.RoleEnum;
import br.com.liberdade.bets69.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<Role> findByName(RoleEnum roleEnum) {
        return roleRepository.findByName(roleEnum);
    }
}
