package br.com.liberdade.bets69.service;

import br.com.liberdade.bets69.dto.NotificacoesDto;
import br.com.liberdade.bets69.model.Notificacoes;
import br.com.liberdade.bets69.repository.NotificacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificacoesService {

    private final NotificacoesRepository notificacoesRepository;

    @Autowired
    public NotificacoesService(NotificacoesRepository notificacoesRepository) {
        this.notificacoesRepository = notificacoesRepository;
    }

    public List<NotificacoesDto> getAllNotificacoes() {
        return notificacoesRepository.findAll().stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }

    public NotificacoesDto criarNotificacao(NotificacoesDto notificacaoDto) {
        Notificacoes notificacao = new Notificacoes(notificacaoDto.getUsuario(), notificacaoDto.getMensagem());
        notificacao = notificacoesRepository.save(notificacao);
        return convertToDto(notificacao);
    }

    public void marcarComoLida(Long id) {
        Notificacoes notificacao = notificacoesRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Notificação não encontrada"));
        notificacao.marcarComoLida();
        notificacoesRepository.save(notificacao);
    }

    private NotificacoesDto convertToDto(Notificacoes notificacao) {
        return new NotificacoesDto(
            notificacao.getId(),
            notificacao.getUsuario(),
            notificacao.getMensagem(),
            notificacao.isLida(),
            notificacao.getDataEnvio()
        );
    }
}
