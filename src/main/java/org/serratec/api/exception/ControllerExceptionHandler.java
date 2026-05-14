package org.serratec.api.exception;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResposta> tratarValidacao(MethodArgumentNotValidException ex) {
        List<String> erros = ex.getBindingResult().getFieldErrors()
                .stream().map(e -> e.getField() + ": " + e.getDefaultMessage()).toList();

        ErroResposta erro = new ErroResposta(400, "Dados Inválidos", LocalDateTime.now(), erros);
        return ResponseEntity.badRequest().body(erro);
    }

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ErroResposta> tratar404(RecursoNaoEncontradoException ex) {
        ErroResposta erro = new ErroResposta(404, ex.getMessage(), LocalDateTime.now(), null);
        return ResponseEntity.status(404).body(erro);
    }
}