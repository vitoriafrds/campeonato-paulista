package br.com.laboratoriobd.paulistao.service;

import br.com.laboratoriobd.paulistao.model.Grupo;
import br.com.laboratoriobd.paulistao.model.dto.GrupoDTO;
import br.com.laboratoriobd.paulistao.repositories.GrupoRepository;
import br.com.laboratoriobd.paulistao.repositories.procedures.ProcedureBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GrupoService {

    private GrupoRepository repository;
    private ProcedureBuilder builder;

    @Autowired
    public GrupoService(GrupoRepository repository, ProcedureBuilder builder) {
        this.repository = repository;
        this.builder = builder;
    }

    public void gerar() {
        log.info("Inciando geracao dos grupos. Timestamp [{}}", LocalDateTime.now());
        builder.gerarGruposPaulistao();
        log.info("Grupos gerados com sucesso. Timestamp [{}}", LocalDateTime.now());
    }

    public List<GrupoDTO> listar() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "codigoGrupo")).stream().map(Grupo::toResponse)
        .collect(Collectors.toList());
    }
}
