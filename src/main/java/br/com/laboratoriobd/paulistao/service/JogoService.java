package br.com.laboratoriobd.paulistao.service;

import br.com.laboratoriobd.paulistao.exception.BusinessException;
import br.com.laboratoriobd.paulistao.model.Jogo;
import br.com.laboratoriobd.paulistao.model.Time;
import br.com.laboratoriobd.paulistao.model.dto.JogoDTO;
import br.com.laboratoriobd.paulistao.repositories.JogoRepository;
import br.com.laboratoriobd.paulistao.repositories.TimeRepository;
import br.com.laboratoriobd.paulistao.repositories.procedures.ProcedureBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class JogoService {

    private JogoRepository repository;
    private TimeRepository repositoryTime;
    private ProcedureBuilder builder;

    @Autowired
    public JogoService(JogoRepository repository, TimeRepository timeRepository, ProcedureBuilder builder) {
        this.repository = repository;
        this.repositoryTime = timeRepository;
        this.builder = builder;
    }
    
    public void gerarJogos() {
        log.info("Iniciando geracao dos jogos. timestamp [{}]", LocalDateTime.now());
        builder.montarJogosCampeonato();
        log.info("Jogos gerados com sucesso.   timestamp[{}]", LocalDateTime.now());
    }

    public void definirPlacar(int placarTimeA, int placarTimeB, String dataJogo) {
        Optional<Jogo> jogo = repository.findFirstByData(dataJogo);

        jogo.ifPresent(x -> {
            jogo.get().setTotalGolsPrimeiroTime(placarTimeA);
            jogo.get().setTotalGolsSegundoTime(placarTimeB);
            repository.save(jogo.get());
        });
    }

    public JogoDTO detalheJogo(String data) {

        JogoDTO retorno = new JogoDTO();
        Optional<Jogo> jogo = repository.findFirstByData(data);

        jogo.ifPresent(x -> {
            retorno.setData(x.getData());
            retorno.setGolsPrimeiroTime(x.getTotalGolsPrimeiroTime());
            retorno.setGolsSegundoTime(x.getTotalGolsSegundoTime());
            retorno.setPrimeiroTime(buscarNomeTime(x.getId().getCodigoPrimeiroTime()));
            retorno.setSegundoTime(buscarNomeTime(x.getId().getCodigoSegundoTime()));
        });

        return retorno;
    }

    private String buscarNomeTime(int codigoTime) {
        return repositoryTime.findByCodigoTime(codigoTime).map(Time::getNome).orElse(null);
    }
}

