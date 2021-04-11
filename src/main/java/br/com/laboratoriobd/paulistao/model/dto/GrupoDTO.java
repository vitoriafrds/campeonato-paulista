package br.com.laboratoriobd.paulistao.model.dto;

import br.com.laboratoriobd.paulistao.model.Grupo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GrupoDTO {
    private String codigoGrupo;
    private int codigoTime;


    public GrupoDTO(Grupo entidade) {
        super();
        this.codigoGrupo = entidade.getCodigoGrupo();
        this.codigoTime = entidade.getCodigoTime();
    }
}
