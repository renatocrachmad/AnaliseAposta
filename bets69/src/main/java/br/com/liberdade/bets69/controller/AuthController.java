package br.com.liberdade.bets69.controller;

import br.com.liberdade.bets69.security.JwtTokenProvider;
import br.com.liberdade.bets69.DTO.UserWithRoleRequest;
import br.com.liberdade.bets69.model.User;
import br.com.liberdade.bets69.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService; 

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody User loginRequest) {
        // Autenticação do usuário com base no nome de usuário e senha
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // Geração do token JWT
        String token = jwtTokenProvider.generateToken(authentication.getName());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        //  cria um usuário com a senha criptografada
        userService.createUser(user);
        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }
    
    @PostMapping("/register-with-role")
    public ResponseEntity<?> registerUserWithRole(@RequestBody UserWithRoleRequest request) {
        // Cria um novo usuário com uma role específica
        userService.createUser(request.getUsername(), request.getPassword(), request.getRole());
        return ResponseEntity.ok("Usuário registrado com sucesso com a role: " + request.getRole());
    }
    
}