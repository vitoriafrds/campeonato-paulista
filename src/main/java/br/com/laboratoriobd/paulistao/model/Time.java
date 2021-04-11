package br.com.laboratoriobd.paulistao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "TIMES")
@NoArgsConstructor
@AllArgsConstructor
public class Time {

    @Id
    @Column(name = "CODIGO_TIME")
    private int codigoTime;

    @Column(name = "NOME_TIME")
    private String nome;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "ESTADIO")
    private String estadio;
}
