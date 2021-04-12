package br.com.laboratoriobd.paulistao.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessException extends RuntimeException {
    private String mensagem;

    public BusinessException(String mensagem) {
        super(mensagem);
        this.mensagem = mensagem;
    }

}
