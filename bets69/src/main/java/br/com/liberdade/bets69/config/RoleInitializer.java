package br.com.liberdade.bets69.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.liberdade.bets69.model.Role;
import br.com.liberdade.bets69.records.RoleEnum;
import br.com.liberdade.bets69.repository.RoleRepository;
import jakarta.annotation.PostConstruct;

@Component
public class RoleInitializer {

    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void init() {
        // Verifica se as roles já existem, caso contrário, as insere
        if (roleRepository.findByName(RoleEnum.USER).isEmpty()) {
            roleRepository.save(new Role(RoleEnum.USER));
        }
        if (roleRepository.findByName(RoleEnum.ADMIN).isEmpty()) {
            roleRepository.save(new Role(RoleEnum.ADMIN));
        }
    }
}
