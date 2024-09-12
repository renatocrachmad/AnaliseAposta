package br.com.liberdade.bets69.service;

import br.com.liberdade.bets69.model.Admin;
import br.com.liberdade.bets69.model.User;
import br.com.liberdade.bets69.repository.AdminRepository;
import br.com.liberdade.bets69.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    // Método para criar um novo administrador
    public Admin createAdmin(User usuario, boolean gerenciarEventos, boolean gerenciarApostas, boolean gerenciarUsuarios) {
        Admin admin = new Admin(usuario, gerenciarEventos, gerenciarApostas, gerenciarUsuarios);
        return adminRepository.save(admin);
    }

    // Método para atualizar um administrador existente
    public Admin updateAdmin(Long id, boolean gerenciarEventos, boolean gerenciarApostas, boolean gerenciarUsuarios) {
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin não encontrado"));
        admin.setGerenciarEventos(gerenciarEventos);
        admin.setGerenciarApostas(gerenciarApostas);
        admin.setGerenciarUsuarios(gerenciarUsuarios);
        return adminRepository.save(admin);
    }

    // Método para buscar um administrador por ID
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin não encontrado"));
    }

    // Método para excluir um administrador por ID
    public void deleteAdmin(Long id) {
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin não encontrado"));
        adminRepository.delete(admin);
    }

    // Método para gerenciar eventos (verifica se o administrador tem privilégios)
    public void manageEvents(Admin admin) {
        if (admin.podeGerenciarEventos()) {
            // Lógica para gerenciar eventos
        } else {
            throw new SecurityException("O administrador não tem privilégios para gerenciar eventos.");
        }
    }

    // Método para verificar transações (verifica se o administrador tem privilégios)
    public void verifyTransactions(Admin admin) {
        if (admin.podeGerenciarApostas()) {
            // Lógica para verificar transações
        } else {
            throw new SecurityException("O administrador não tem privilégios para verificar transações.");
        }
    }

    // Método para validar apostas (verifica se o administrador tem privilégios)
    public void validateBets(Admin admin) {
        if (admin.podeGerenciarApostas()) {
            // Lógica para validar apostas
        } else {
            throw new SecurityException("O administrador não tem privilégios para validar apostas.");
        }
    }

    // Método para gerenciar usuários (verifica se o administrador tem privilégios)
    public void manageUsers(Admin admin) {
        if (admin.podeGerenciarUsuarios()) {
            // Lógica para gerenciar usuários
        } else {
            throw new SecurityException("O administrador não tem privilégios para gerenciar usuários.");
        }
    }
}
