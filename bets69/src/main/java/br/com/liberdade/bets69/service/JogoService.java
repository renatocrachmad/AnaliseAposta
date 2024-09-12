package br.com.liberdade.bets69.service;

import br.com.liberdade.bets69.model.Jogo;
import br.com.liberdade.bets69.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    private final JogoRepository jogoRepository;

    @Autowired
    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    // Método para criar um novo jogo
    public Jogo createJogo(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    // Método para buscar um jogo pelo ID
    public Jogo findJogoById(Long jogoId) {
        return jogoRepository.findById(jogoId)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado"));
    }

    // Método para buscar todos os jogos
    public List<Jogo> findAllJogos() {
        return jogoRepository.findAll();
    }

    // Método para atualizar um jogo existente
    public Jogo updateJogo(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    // Método para deletar um jogo pelo ID
    public void deleteJogoById(Long jogoId) {
        jogoRepository.deleteById(jogoId);
    }
}
