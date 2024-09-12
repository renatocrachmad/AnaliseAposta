package br.com.liberdade.bets69.service;

import br.com.liberdade.bets69.model.User;
import br.com.liberdade.bets69.model.Role;
import br.com.liberdade.bets69.records.RoleEnum;
import br.com.liberdade.bets69.repository.UserRepository;
import br.com.liberdade.bets69.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Método para criar um novo usuário sem definir a role
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // Método para criar um novo usuário com uma role específica
    public User createUser(String username, String password, RoleEnum roleEnum) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        // Busca a role no banco de dados
        Role userRole = roleRepository.findByName(roleEnum)
                .orElseThrow(() -> new RuntimeException("Role não encontrada"));

        // Define a role do usuário
        user.setRoles(Set.of(userRole));

        // Salva o usuário com a role associada
        return userRepository.save(user);
    }

    // Método para atualizar um usuário existente
    public User updateUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // Método para buscar um usuário pelo username
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

    // Método para buscar um usuário pelo ID
    public User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

	public void deleteUserById(Long userId) {
		userRepository.deleteById(userId);
		
	}
}
