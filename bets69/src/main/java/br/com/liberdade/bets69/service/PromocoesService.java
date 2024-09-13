package br.com.liberdade.bets69.service;

import br.com.liberdade.bets69.dto.PromocoesDTO;
import br.com.liberdade.bets69.model.Promocoes;
import br.com.liberdade.bets69.repository.PromocoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromocoesService {

    private final PromocoesRepository promocoesRepository;

    @Autowired
    public PromocoesService(PromocoesRepository promocoesRepository) {
        this.promocoesRepository = promocoesRepository;
    }

    public List<PromocoesDTO> getAllPromocoes() {
        return promocoesRepository.findAll().stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }

    public PromocoesDTO getPromocaoById(Long id) {
        Promocoes promocao = promocoesRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Promoção não encontrada"));
        return convertToDto(promocao);
    }

    public PromocoesDTO criarPromocao(PromocoesDTO promocoesDTO) {
        Promocoes promocao = convertToEntity(promocoesDTO);
        promocao = promocoesRepository.save(promocao);
        return convertToDto(promocao);
    }

    public void deletarPromocao(Long id) {
        promocoesRepository.deleteById(id);
    }

    private PromocoesDTO convertToDto(Promocoes promocao) {
        return new PromocoesDTO(
            promocao.getId(),
            promocao.getNome(),
            promocao.getDescricao(),
            promocao.getValorBonus(),
            promocao.getDataValidade()
        );
    }

    private Promocoes convertToEntity(PromocoesDTO promocoesDTO) {
        return new Promocoes(
            promocoesDTO.getNome(),
            promocoesDTO.getDescricao(),
            promocoesDTO.getValorBonus(),
            promocoesDTO.getDataValidade()
        );
    }
}
