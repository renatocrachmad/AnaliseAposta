package br.com.liberdade.bets69.service;

import br.com.liberdade.bets69.dto.TransacaoFinanceiraDTO;
import br.com.liberdade.bets69.model.TransacaoFinanceira;
import br.com.liberdade.bets69.repository.TransacaoFinanceiraRepository;
import br.com.liberdade.bets69.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransacaoFinanceiraService {

	private final TransacaoFinanceiraRepository transacaoFinanceiraRepository;
	private final UserService userService;

	@Autowired
	public TransacaoFinanceiraService(TransacaoFinanceiraRepository transacaoFinanceiraRepository,
			UserService userService) {
		this.transacaoFinanceiraRepository = transacaoFinanceiraRepository;
		this.userService = userService;
	}

	public List<TransacaoFinanceiraDTO> getAllTransacoes() {
		return transacaoFinanceiraRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}

	public TransacaoFinanceiraDTO getTransacaoById(Long id) {
		TransacaoFinanceira transacao = transacaoFinanceiraRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Transação não encontrada"));
		return convertToDto(transacao);
	}

	public TransacaoFinanceiraDTO criarTransacao(TransacaoFinanceiraDTO transacaoFinanceiraDTO) {
		TransacaoFinanceira transacao = convertToEntity(transacaoFinanceiraDTO);
		transacao = transacaoFinanceiraRepository.save(transacao);
		return convertToDto(transacao);
	}

	public void deletarTransacao(Long id) {
		transacaoFinanceiraRepository.deleteById(id);
	}

	private TransacaoFinanceiraDTO convertToDto(TransacaoFinanceira transacao) {
		return new TransacaoFinanceiraDTO(transacao.getId(), transacao.getUser().getId(), transacao.getTipo(),
				transacao.getValor(), transacao.getDataTransacao(), transacao.getStatus());
	}

	private TransacaoFinanceira convertToEntity(TransacaoFinanceiraDTO transacaoFinanceiraDTO) {
		TransacaoFinanceira transacao = new TransacaoFinanceira();
		transacao.setId(transacaoFinanceiraDTO.getId());
		transacao.setUser(userService.findUserById(transacaoFinanceiraDTO.getUserId()));
		transacao.setTipo(transacaoFinanceiraDTO.getTipo());
		transacao.setValor(transacaoFinanceiraDTO.getValor());
		transacao.setDataTransacao(transacaoFinanceiraDTO.getDataTransacao());
		transacao.setStatus(transacaoFinanceiraDTO.getStatus());
		return transacao;
	}
}
