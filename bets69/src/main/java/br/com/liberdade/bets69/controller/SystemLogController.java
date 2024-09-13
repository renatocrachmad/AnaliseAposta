package br.com.liberdade.bets69.controller;

import br.com.liberdade.bets69.dto.SystemLogDTO;
import br.com.liberdade.bets69.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/system-logs")
public class SystemLogController {

    private final SystemLogService systemLogService;

    @Autowired
    public SystemLogController(SystemLogService systemLogService) {
        this.systemLogService = systemLogService;
    }

    @GetMapping
    public ResponseEntity<List<SystemLogDTO>> getAllSystemLogs() {
        return ResponseEntity.ok(systemLogService.getAllSystemLogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SystemLogDTO> getSystemLogById(@PathVariable Long id) {
        return ResponseEntity.ok(systemLogService.getSystemLogById(id));
    }

    @PostMapping
    public ResponseEntity<SystemLogDTO> criarSystemLog(@RequestBody SystemLogDTO systemLogDTO) {
        return ResponseEntity.ok(systemLogService.criarSystemLog(systemLogDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSystemLog(@PathVariable Long id) {
        systemLogService.deletarSystemLog(id);
        return ResponseEntity.noContent().build();
    }
}
