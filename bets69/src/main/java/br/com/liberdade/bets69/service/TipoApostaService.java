package br.com.liberdade.bets69.service;

import br.com.liberdade.bets69.dto.TipoApostaDTO;
import br.com.liberdade.bets69.model.TipoAposta;
import br.com.liberdade.bets69.repository.TipoApostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoApostaService {

    private final TipoApostaRepository tipoApostaRepository;

    @Autowired
    public TipoApostaService(TipoApostaRepository tipoApostaRepository) {
        this.tipoApostaRepository = tipoApostaRepository;
    }

    public List<TipoApostaDTO> getAllTiposAposta() {
        return tipoApostaRepository.findAll().stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }

    public TipoApostaDTO getTipoApostaById(Long id) {
        TipoAposta tipoAposta = tipoApostaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tipo de Aposta não encontrado"));
        return convertToDto(tipoAposta);
    }

    public TipoApostaDTO criarTipoAposta(TipoApostaDTO tipoApostaDTO) {
        TipoAposta tipoAposta = convertToEntity(tipoApostaDTO);
        tipoAposta = tipoApostaRepository.save(tipoAposta);
        return convertToDto(tipoAposta);
    }

    public void deletarTipoAposta(Long id) {
        tipoApostaRepository.deleteById(id);
    }

    private TipoApostaDTO convertToDto(TipoAposta tipoAposta) {
        return new TipoApostaDTO(
            tipoAposta.getId(),
            tipoAposta.getNome(),
            tipoAposta.isSimples(),
            tipoAposta.isMultipla(),
            tipoAposta.isSistema(),
            tipoAposta.getDescricao()
        );
    }

    private TipoAposta convertToEntity(TipoApostaDTO tipoApostaDTO) {
        return new TipoAposta(
            tipoApostaDTO.getNome(),
            tipoApostaDTO.isSimples(),
            tipoApostaDTO.isMultipla(),
            tipoApostaDTO.isSistema(),
            tipoApostaDTO.getDescricao()
        );
    }
}
