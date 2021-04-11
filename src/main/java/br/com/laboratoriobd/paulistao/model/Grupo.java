package br.com.laboratoriobd.paulistao.model;

import br.com.laboratoriobd.paulistao.model.dto.GrupoDTO;
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
@Table(name = "GRUPOS")
@NoArgsConstructor
@AllArgsConstructor
public class Grupo {

    @Id
    @Column(name = "CODIGO_TIME")
    private int codigoTime;

    @Column(name = "CODIGO_GRUPO")
    private String codigoGrupo;

    @Column(name = "NUMERO_SEQUENCIAL_GRUPO")
    private int sequencialGrupo;

    public static GrupoDTO toResponse(Grupo grupo) {
        return new GrupoDTO(grupo);
    }
}
