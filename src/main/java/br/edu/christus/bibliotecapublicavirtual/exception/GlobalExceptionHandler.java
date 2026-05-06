package br.edu.christus.bibliotecapublicavirtual.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> tratarErroDeEnumInvalido(HttpMessageNotReadableException ex) {
        if (ex.getMessage().contains("not one of the values accepted for Enum class")) {
            return ResponseEntity.badRequest().body("Erro: Valor inválido. Verifique se a série ou matéria foram digitadas corretamente.");
        }

        return ResponseEntity.badRequest().body("Erro na leitura do JSON da requisição.");
    }
}