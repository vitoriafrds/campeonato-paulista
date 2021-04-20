package br.com.laboratoriobd.paulistao.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JogoDTO {

    private String primeiroTime;
    private String segundoTime;
    private String data;
    private int golsPrimeiroTime;
    private int golsSegundoTime;
}
