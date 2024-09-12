package br.com.liberdade.bets69.service;

import br.com.liberdade.bets69.model.Aposta;
import br.com.liberdade.bets69.repository.ApostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApostaService {

    private final ApostaRepository apostaRepository;

    @Autowired
    public ApostaService(ApostaRepository apostaRepository) {
        this.apostaRepository = apostaRepository;
    }

    // Cria uma nova aposta
    public Aposta createAposta(Aposta aposta) {
        return apostaRepository.save(aposta);
    }

    // Atualiza uma aposta existente
    public Aposta updateAposta(Aposta aposta) {
        return apostaRepository.save(aposta);
    }

    // Busca uma aposta pelo ID
    public Optional<Aposta> getApostaById(Long id) {
        return apostaRepository.findById(id);
    }

    // Exclui uma aposta pelo ID
    public void deleteAposta(Long id) {
        apostaRepository.deleteById(id);
    }

    // Busca todas as apostas
    public List<Aposta> getAllApostas() {
        return apostaRepository.findAll();
    }
}
