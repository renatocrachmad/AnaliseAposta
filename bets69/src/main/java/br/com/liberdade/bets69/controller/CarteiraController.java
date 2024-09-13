package br.com.liberdade.bets69.controller;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.liberdade.bets69.dto.CarteiraDTO;
import br.com.liberdade.bets69.model.Carteira;
import br.com.liberdade.bets69.model.User;
import br.com.liberdade.bets69.service.CarteiraService;

@RestController
@RequestMapping("/carteiras")
public class CarteiraController {

    private final CarteiraService carteiraService;

    @Autowired
    public CarteiraController(CarteiraService carteiraService) {
        this.carteiraService = carteiraService;
    }

    // Cria uma nova carteira
    @PostMapping
    public ResponseEntity<Carteira> createCarteira(@RequestBody CarteiraDTO carteiraDTO) {
        Carteira carteira = convertToEntity(carteiraDTO);
        Carteira createdCarteira = carteiraService.createCarteira(carteira);
        return ResponseEntity.ok(createdCarteira);
    }

    // Atualiza uma carteira existente
    @PutMapping("/{userId}")
    public ResponseEntity<Carteira> updateCarteira(@PathVariable Long userId, @RequestBody CarteiraDTO carteiraDTO) {
        Optional<Carteira> existingCarteira = carteiraService.findByUserId(userId);
        if (existingCarteira.isPresent()) {
            Carteira carteira = convertToEntity(carteiraDTO);
            carteira.setId(existingCarteira.get().getId());
            Carteira updatedCarteira = carteiraService.updateCarteira(carteira);
            return ResponseEntity.ok(updatedCarteira);
        }
        return ResponseEntity.notFound().build();
    }

    // Busca carteira pelo ID do usuário
    @GetMapping("/{userId}")
    public ResponseEntity<Carteira> getCarteiraByUserId(@PathVariable Long userId) {
        Optional<Carteira> carteira = carteiraService.findByUserId(userId);
        return carteira.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Adiciona saldo
    @PostMapping("/{userId}/adicionar")
    public ResponseEntity<Void> adicionarSaldo(@PathVariable Long userId, @RequestParam BigDecimal valor) {
        carteiraService.adicionarSaldo(userId, valor);
        return ResponseEntity.ok().build();
    }

    // Bloqueia saldo
    @PostMapping("/{userId}/bloquear")
    public ResponseEntity<Void> bloquearSaldo(@PathVariable Long userId, @RequestParam BigDecimal valor) {
        carteiraService.bloquearSaldo(userId, valor);
        return ResponseEntity.ok().build();
    }

    // Libera saldo bloqueado
    @PostMapping("/{userId}/liberar")
    public ResponseEntity<Void> liberarSaldo(@PathVariable Long userId, @RequestParam BigDecimal valor) {
        carteiraService.liberarSaldoBloqueado(userId, valor);
        return ResponseEntity.ok().build();
    }

    // Deduz saldo
    @PostMapping("/{userId}/deduzir")
    public ResponseEntity<Void> deduzirSaldo(@PathVariable Long userId, @RequestParam BigDecimal valor) {
        carteiraService.deduzirSaldo(userId, valor);
        return ResponseEntity.ok().build();
    }

    // Método auxiliar para converter CarteiraDTO em Carteira
    private Carteira convertToEntity(CarteiraDTO carteiraDTO) {
        Carteira carteira = new Carteira();
        carteira.setUser(new User()); 
        carteira.setSaldoDisponivel(carteiraDTO.getSaldoDisponivel());
        carteira.setSaldoBloqueado(carteiraDTO.getSaldoBloqueado());
        return carteira;
    }
}
