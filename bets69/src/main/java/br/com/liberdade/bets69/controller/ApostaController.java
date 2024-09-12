package br.com.liberdade.bets69.controller;

import br.com.liberdade.bets69.dto.ApostaDTO;
import br.com.liberdade.bets69.model.Aposta;
import br.com.liberdade.bets69.model.EventoEsportivo;
import br.com.liberdade.bets69.model.User;
import br.com.liberdade.bets69.service.ApostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apostas")
public class ApostaController {

    private final ApostaService apostaService;

    @Autowired
    public ApostaController(ApostaService apostaService) {
        this.apostaService = apostaService;
    }

    // Cria uma nova aposta
    @PostMapping
    public ResponseEntity<Aposta> createAposta(@RequestBody ApostaDTO apostaDTO) {
        Aposta aposta = convertToEntity(apostaDTO);
        Aposta createdAposta = apostaService.createAposta(aposta);
        return ResponseEntity.ok(createdAposta);
    }

    // Atualiza uma aposta existente
    @PutMapping("/{id}")
    public ResponseEntity<Aposta> updateAposta(@PathVariable Long id, @RequestBody ApostaDTO apostaDTO) {
        Optional<Aposta> existingAposta = apostaService.getApostaById(id);
        if (existingAposta.isPresent()) {
            Aposta aposta = convertToEntity(apostaDTO);
            aposta.setId(id);
            Aposta updatedAposta = apostaService.updateAposta(aposta);
            return ResponseEntity.ok(updatedAposta);
        }
        return ResponseEntity.notFound().build();
    }

    // Obtém uma aposta pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Aposta> getApostaById(@PathVariable Long id) {
        Optional<Aposta> aposta = apostaService.getApostaById(id);
        return aposta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Exclui uma aposta pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAposta(@PathVariable Long id) {
        apostaService.deleteAposta(id);
        return ResponseEntity.noContent().build();
    }

    // Obtém todas as apostas
    @GetMapping
    public ResponseEntity<List<Aposta>> getAllApostas() {
        List<Aposta> apostas = apostaService.getAllApostas();
        return ResponseEntity.ok(apostas);
    }

    // Método auxiliar para converter ApostaDTO em Aposta
    private Aposta convertToEntity(ApostaDTO apostaDTO) {
        Aposta aposta = new Aposta();
        aposta.setUser(new User()); // Substituir com a lógica correta de obtenção do User
        aposta.setEventoEsportivo(new EventoEsportivo()); // Substituir com a lógica correta de obtenção do EventoEsportivo
        aposta.setValorApostado(apostaDTO.getValorApostado());
        aposta.setOdds(apostaDTO.getOdds());
        aposta.setStatus(apostaDTO.getStatus());
        aposta.setResultado(apostaDTO.getResultado());
        return aposta;
    }
}
