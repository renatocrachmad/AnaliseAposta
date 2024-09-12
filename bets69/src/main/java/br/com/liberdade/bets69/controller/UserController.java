package br.com.liberdade.bets69.controller;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.liberdade.bets69.dto.UserCreateRequest;
import br.com.liberdade.bets69.dto.UserUpdateRequest;
import br.com.liberdade.bets69.model.Role;
import br.com.liberdade.bets69.model.User;
import br.com.liberdade.bets69.service.RoleService;
import br.com.liberdade.bets69.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.findUserById(userId);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserCreateRequest createRequest) {
        User user = userService.createUser(createRequest.getUsername(), createRequest.getPassword(), createRequest.getRole());
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody UserUpdateRequest updateRequest) {
        User user = userService.findUserById(userId);

        // Atualiza os detalhes do usuário
        if (updateRequest.getRoles() != null) {
            Set<Role> roles = updateRequest.getRoles().stream()
                .map(roleEnum -> roleService.findByName(roleEnum) // Usa o RoleService para encontrar roles
                    .orElseThrow(() -> new RuntimeException("Role não encontrada")))
                .collect(Collectors.toSet());
            user.setRoles(roles);
        }
              

        // Atualiza o usuário no banco de dados
        userService.updateUser(user);
        return ResponseEntity.ok(user);
    }
    
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }
}
