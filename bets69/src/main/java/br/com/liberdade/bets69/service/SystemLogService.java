package br.com.liberdade.bets69.service;

import br.com.liberdade.bets69.dto.SystemLogDTO;
import br.com.liberdade.bets69.model.SystemLog;
import br.com.liberdade.bets69.model.User;
import br.com.liberdade.bets69.repository.SystemLogRepository;
import br.com.liberdade.bets69.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SystemLogService {

    private final SystemLogRepository systemLogRepository;
    private final UserRepository userRepository;

    @Autowired
    public SystemLogService(SystemLogRepository systemLogRepository, UserRepository userRepository) {
        this.systemLogRepository = systemLogRepository;
        this.userRepository = userRepository;
    }

    public List<SystemLogDTO> getAllSystemLogs() {
        return systemLogRepository.findAll().stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }

    public SystemLogDTO getSystemLogById(Long id) {
        SystemLog systemLog = systemLogRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Log não encontrado"));
        return convertToDto(systemLog);
    }

    public SystemLogDTO criarSystemLog(SystemLogDTO systemLogDTO) {
        User usuario = userRepository.findById(systemLogDTO.getUsuarioId())
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        SystemLog systemLog = convertToEntity(systemLogDTO, usuario);
        systemLog = systemLogRepository.save(systemLog);
        return convertToDto(systemLog);
    }

    public void deletarSystemLog(Long id) {
        systemLogRepository.deleteById(id);
    }

    private SystemLogDTO convertToDto(SystemLog systemLog) {
        return new SystemLogDTO(
            systemLog.getId(),
            systemLog.getUsuario().getId(),
            systemLog.getAcao(),
            systemLog.getDataHora(),
            systemLog.getDetalhes()
        );
    }

    private SystemLog convertToEntity(SystemLogDTO systemLogDTO, User usuario) {
        return new SystemLog(
            usuario,
            systemLogDTO.getAcao(),
            systemLogDTO.getDetalhes()
        );
    }
}
