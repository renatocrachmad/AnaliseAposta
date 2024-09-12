package br.com.liberdade.bets69.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.liberdade.bets69.model.Jogo;
import br.com.liberdade.bets69.model.User;
import br.com.liberdade.bets69.service.JogoService;
import br.com.liberdade.bets69.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/jogos")
public class JogoController {

    private final JogoService jogoService;
    private final UserService userService;

    @Autowired
    public JogoController(JogoService jogoService, UserService userService) {
        this.jogoService = jogoService;
        this.userService = userService;
    }

    // Buscar jogo por ID
    @GetMapping("/{jogoId}")
    public ResponseEntity<Jogo> getJogoById(@PathVariable Long jogoId) {
        Jogo jogo = jogoService.findJogoById(jogoId);
        return ResponseEntity.ok(jogo);
    }

    // Listar todos os jogos
    @GetMapping
    public ResponseEntity<List<Jogo>> getAllJogos() {
        List<Jogo> jogos = jogoService.findAllJogos();
        return ResponseEntity.ok(jogos);
    }

    // Criar um novo jogo
    @PostMapping
    public ResponseEntity<Jogo> createJogo(@RequestParam Long autorId, @RequestBody Jogo jogoRequest) {
        User autor = userService.findUserById(autorId);
        Jogo novoJogo = new Jogo();
        novoJogo.setNome(jogoRequest.getNome());
        novoJogo.setAutor(autor);

        Jogo jogoCriado = jogoService.createJogo(novoJogo);
        return ResponseEntity.ok(jogoCriado);
    }

    // Atualizar um jogo
    @PutMapping("/{jogoId}")
    public ResponseEntity<Jogo> updateJogo(@PathVariable Long jogoId, @RequestBody Jogo jogoRequest) {
        Jogo jogoExistente = jogoService.findJogoById(jogoId);
        jogoExistente.setNome(jogoRequest.getNome());
        
        if (jogoRequest.getAutor() != null) {
            User autor = userService.findUserById(jogoRequest.getAutor().getId());
            jogoExistente.setAutor(autor);
        }

        Jogo jogoAtualizado = jogoService.updateJogo(jogoExistente);
        return ResponseEntity.ok(jogoAtualizado);
    }

    // Deletar um jogo
    @DeleteMapping("/{jogoId}")
    public ResponseEntity<Void> deleteJogo(@PathVariable Long jogoId) {
        jogoService.deleteJogoById(jogoId);
        return ResponseEntity.noContent().build();
    }
}
