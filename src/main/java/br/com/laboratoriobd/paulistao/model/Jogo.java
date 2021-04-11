package br.com.laboratoriobd.paulistao.model;
import br.com.laboratoriobd.paulistao.model.pk.JogoPK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "JOGOS")
@NoArgsConstructor
@AllArgsConstructor
public class Jogo {

    @EmbeddedId
    private JogoPK id;

    @Column(name = "QTD_GOLS_TIME_A")
    private int totalGolsPrimeiroTime;

    @Column(name = "QTD_GOLS_TIME_B")
    private int totalGolsSegundoTime;

    @Column(name = "DATA_JOGO")
    private String data;
}
