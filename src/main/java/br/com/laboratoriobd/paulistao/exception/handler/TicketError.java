package br.com.laboratoriobd.paulistao.exception.handler;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
public class TicketError {
    private HttpStatus status;
    private String detail;
    private LocalDateTime timestamp;

    public TicketError(HttpStatus status, String detail, LocalDateTime timestamp) {
        super();
        this.status = status;
        this.detail = detail;
        this.timestamp = timestamp;
    }
}
