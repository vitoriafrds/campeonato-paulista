package br.com.laboratoriobd.paulistao.exception.erros;

import lombok.Getter;

@Getter
public enum ErroAplicacao {

    ERRO_RODADA_SEM_JOGOS("NAO HAVAER JOGOS NESSA DATA");

    private String mensagem;

    ErroAplicacao(String mensagem) {
        this.mensagem = mensagem;
    }
}
