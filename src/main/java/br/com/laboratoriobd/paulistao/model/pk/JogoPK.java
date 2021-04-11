package br.com.laboratoriobd.paulistao.model.pk;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class JogoPK implements Serializable {

    @Column(name = "CODIGO_TIME_A")
    private int codigoPrimeiroTime;

    @Column(name = "CODIGO_TIME_B")
    private int codigoSegundoTime;
}
