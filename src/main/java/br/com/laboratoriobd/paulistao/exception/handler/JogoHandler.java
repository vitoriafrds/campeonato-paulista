package br.com.laboratoriobd.paulistao.exception.handler;

import br.com.laboratoriobd.paulistao.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class JogoHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<TicketError> handlerJogo(BusinessException exception) {
        TicketError error = TicketError.builder()
                .status(HttpStatus.NOT_FOUND)
                .detail(exception.getMensagem())
                .timestamp(LocalDateTime.now()).build();

        return ResponseEntity.ok().body(error);
    }
}
