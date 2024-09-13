package br.com.liberdade.bets69.controller;

import br.com.liberdade.bets69.dto.PromocoesDTO;
import br.com.liberdade.bets69.service.PromocoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promocoes")
public class PromocoesController {

    private final PromocoesService promocoesService;

    @Autowired
    public PromocoesController(PromocoesService promocoesService) {
        this.promocoesService = promocoesService;
    }

    @GetMapping
    public ResponseEntity<List<PromocoesDTO>> getAllPromocoes() {
        return ResponseEntity.ok(promocoesService.getAllPromocoes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PromocoesDTO> getPromocaoById(@PathVariable Long id) {
        return ResponseEntity.ok(promocoesService.getPromocaoById(id));
    }

    @PostMapping
    public ResponseEntity<PromocoesDTO> criarPromocao(@RequestBody PromocoesDTO promocoesDTO) {
        return ResponseEntity.ok(promocoesService.criarPromocao(promocoesDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPromocao(@PathVariable Long id) {
        promocoesService.deletarPromocao(id);
        return ResponseEntity.noContent().build();
    }
}
