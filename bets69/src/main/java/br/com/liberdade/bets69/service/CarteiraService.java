package br.com.liberdade.bets69.service;

import br.com.liberdade.bets69.model.Carteira;
import br.com.liberdade.bets69.repository.CarteiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CarteiraService {

    private final CarteiraRepository carteiraRepository;

    @Autowired
    public CarteiraService(CarteiraRepository carteiraRepository) {
        this.carteiraRepository = carteiraRepository;
    }

    // Cria uma nova carteira
    public Carteira createCarteira(Carteira carteira) {
        return carteiraRepository.save(carteira);
    }

    // Atualiza uma carteira existente
    public Carteira updateCarteira(Carteira carteira) {
        return carteiraRepository.save(carteira);
    }

    // Busca uma carteira pelo ID do usuário
    public Optional<Carteira> findByUserId(Long userId) {
        return carteiraRepository.findByUserId(userId);
    }

    // Adiciona saldo disponível à carteira
    public void adicionarSaldo(Long userId, BigDecimal valor) {
        Carteira carteira = findByUserId(userId).orElseThrow(() -> new RuntimeException("Carteira não encontrada."));
        carteira.adicionarSaldo(valor);
        carteiraRepository.save(carteira);
    }

    // Bloqueia saldo da carteira
    public void bloquearSaldo(Long userId, BigDecimal valor) {
        Carteira carteira = findByUserId(userId).orElseThrow(() -> new RuntimeException("Carteira não encontrada."));
        carteira.bloquearSaldo(valor);
        carteiraRepository.save(carteira);
    }

    // Libera saldo bloqueado
    public void liberarSaldoBloqueado(Long userId, BigDecimal valor) {
        Carteira carteira = findByUserId(userId).orElseThrow(() -> new RuntimeException("Carteira não encontrada."));
        carteira.liberarSaldoBloqueado(valor);
        carteiraRepository.save(carteira);
    }

    // Deduz saldo disponível
    public void deduzirSaldo(Long userId, BigDecimal valor) {
        Carteira carteira = findByUserId(userId).orElseThrow(() -> new RuntimeException("Carteira não encontrada."));
        carteira.deduzirSaldo(valor);
        carteiraRepository.save(carteira);
    }
}
