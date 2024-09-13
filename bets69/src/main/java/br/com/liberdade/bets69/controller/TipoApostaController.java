package br.com.liberdade.bets69.controller;

import br.com.liberdade.bets69.dto.TipoApostaDTO;
import br.com.liberdade.bets69.service.TipoApostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-aposta")
public class TipoApostaController {

    private final TipoApostaService tipoApostaService;

    @Autowired
    public TipoApostaController(TipoApostaService tipoApostaService) {
        this.tipoApostaService = tipoApostaService;
    }

    @GetMapping
    public ResponseEntity<List<TipoApostaDTO>> getAllTiposAposta() {
        return ResponseEntity.ok(tipoApostaService.getAllTiposAposta());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoApostaDTO> getTipoApostaById(@PathVariable Long id) {
        return ResponseEntity.ok(tipoApostaService.getTipoApostaById(id));
    }

    @PostMapping
    public ResponseEntity<TipoApostaDTO> criarTipoAposta(@RequestBody TipoApostaDTO tipoApostaDTO) {
        return ResponseEntity.ok(tipoApostaService.criarTipoAposta(tipoApostaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTipoAposta(@PathVariable Long id) {
        tipoApostaService.deletarTipoAposta(id);
        return ResponseEntity.noContent().build();
    }
}
