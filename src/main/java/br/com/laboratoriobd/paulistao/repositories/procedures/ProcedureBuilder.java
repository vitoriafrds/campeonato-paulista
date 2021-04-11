package br.com.laboratoriobd.paulistao.repositories.procedures;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ProcedureBuilder {

    private static final String PROCEDURE_GRUPOS = "gerarGruposCampeonato";
    private static final String PROCEDURE_JOGOS = "montarConfrontosPaulistao";

    @PersistenceContext
    private EntityManager entityManager;


    public void gerarGruposPaulistao() {
      entityManager.createStoredProcedureQuery(PROCEDURE_GRUPOS).execute();
    }


    public void montarJogosCampeonato() {
        entityManager.createStoredProcedureQuery(PROCEDURE_JOGOS).execute();
    }
}
