package org.serratec.api.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ErroResposta(Integer status, String titulo, LocalDateTime dataHora, List<String> erros) {
}