package org.serratec.api.exception;

public class RecursoNaoEncontradoException extends RuntimeException {
    
    public String message;

    public RecursoNaoEncontradoException(String message) {
        super(message);
    }
}