package br.com.liberdade.bets69.controller;


import br.com.liberdade.bets69.dto.AdminDTO;
import br.com.liberdade.bets69.model.Admin;
import br.com.liberdade.bets69.model.User;
import br.com.liberdade.bets69.service.AdminService;
import br.com.liberdade.bets69.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService; // Serviço para encontrar usuários

    // Cria um novo administrador
    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody AdminDTO adminDTO) {
        User usuario = userService.findUserById(adminDTO.getUserId()); // Obter o usuário associado
        if (usuario == null) {
            return ResponseEntity.badRequest().build(); // Usuário não encontrado
        }
        Admin admin = adminService.createAdmin(usuario, adminDTO.isGerenciarEventos(), adminDTO.isGerenciarApostas(), adminDTO.isGerenciarUsuarios());
        return ResponseEntity.ok(admin);
    }

    // Atualiza um administrador existente
    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody AdminDTO adminDTO) {
        User usuario = userService.findUserById(adminDTO.getUserId()); // Obter o usuário associado
        if (usuario == null) {
            return ResponseEntity.badRequest().build(); // Usuário não encontrado
        }
        Admin admin = adminService.updateAdmin(id, adminDTO.isGerenciarEventos(), adminDTO.isGerenciarApostas(), adminDTO.isGerenciarUsuarios());
        return ResponseEntity.ok(admin);
    }

    // Obtém um administrador pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        if (admin == null) {
            return ResponseEntity.notFound().build(); // Admin não encontrado
        }
        return ResponseEntity.ok(admin);
    }

    // Exclui um administrador pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        if (admin == null) {
            return ResponseEntity.notFound().build(); // Admin não encontrado
        }
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }

    // Gerencia eventos para um administrador
    @PostMapping("/{id}/manage-events")
    public ResponseEntity<Void> manageEvents(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        if (admin == null) {
            return ResponseEntity.notFound().build(); // Admin não encontrado
        }
        adminService.manageEvents(admin);
        return ResponseEntity.ok().build();
    }

    // Verifica transações para um administrador
    @PostMapping("/{id}/verify-transactions")
    public ResponseEntity<Void> verifyTransactions(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        if (admin == null) {
            return ResponseEntity.notFound().build(); // Admin não encontrado
        }
        adminService.verifyTransactions(admin);
        return ResponseEntity.ok().build();
    }

    // Valida apostas para um administrador
    @PostMapping("/{id}/validate-bets")
    public ResponseEntity<Void> validateBets(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        if (admin == null) {
            return ResponseEntity.notFound().build(); // Admin não encontrado
        }
        adminService.validateBets(admin);
        return ResponseEntity.ok().build();
    }

    // Gerencia usuários para um administrador
    @PostMapping("/{id}/manage-users")
    public ResponseEntity<Void> manageUsers(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        if (admin == null) {
            return ResponseEntity.notFound().build(); // Admin não encontrado
        }
        adminService.manageUsers(admin);
        return ResponseEntity.ok().build();
    }
}
