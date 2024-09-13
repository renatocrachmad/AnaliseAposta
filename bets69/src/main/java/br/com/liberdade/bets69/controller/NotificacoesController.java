package br.com.liberdade.bets69.controller;

import br.com.liberdade.bets69.dto.NotificacoesDto;
import br.com.liberdade.bets69.model.Notificacoes;
import br.com.liberdade.bets69.service.NotificacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificacoes")
public class NotificacoesController {

    private final NotificacoesService notificacoesService;

    @Autowired
    public NotificacoesController(NotificacoesService notificacoesService) {
        this.notificacoesService = notificacoesService;
    }

    @GetMapping
    public ResponseEntity<List<NotificacoesDto>> getAllNotificacoes() {
        return ResponseEntity.ok(notificacoesService.getAllNotificacoes());
    }

    @PostMapping
    public ResponseEntity<NotificacoesDto> criarNotificacao(@RequestBody NotificacoesDto notificacaoDto) {
        return ResponseEntity.ok(notificacoesService.criarNotificacao(notificacaoDto));
    }

    @PutMapping("/{id}/marcar-como-lida")
    public ResponseEntity<Void> marcarComoLida(@PathVariable Long id) {
        notificacoesService.marcarComoLida(id);
        return ResponseEntity.ok().build();
    }
}
