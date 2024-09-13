package br.com.liberdade.bets69.controller;

import br.com.liberdade.bets69.dto.TransacaoFinanceiraDTO;
import br.com.liberdade.bets69.service.TransacaoFinanceiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoFinanceiraController {

    private final TransacaoFinanceiraService transacaoFinanceiraService;

    @Autowired
    public TransacaoFinanceiraController(TransacaoFinanceiraService transacaoFinanceiraService) {
        this.transacaoFinanceiraService = transacaoFinanceiraService;
    }

    @GetMapping
    public ResponseEntity<List<TransacaoFinanceiraDTO>> getAllTransacoes() {
        return ResponseEntity.ok(transacaoFinanceiraService.getAllTransacoes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransacaoFinanceiraDTO> getTransacaoById(@PathVariable Long id) {
        return ResponseEntity.ok(transacaoFinanceiraService.getTransacaoById(id));
    }

    @PostMapping
    public ResponseEntity<TransacaoFinanceiraDTO> criarTransacao(@RequestBody TransacaoFinanceiraDTO transacaoFinanceiraDTO) {
        return ResponseEntity.ok(transacaoFinanceiraService.criarTransacao(transacaoFinanceiraDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTransacao(@PathVariable Long id) {
        transacaoFinanceiraService.deletarTransacao(id);
        return ResponseEntity.noContent().build();
    }
}
