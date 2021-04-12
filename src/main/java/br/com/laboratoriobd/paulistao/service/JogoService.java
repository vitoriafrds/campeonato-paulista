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

    public List<JogoDTO> pesquisar(String dataJogo) {
        List<JogoDTO> jogos = new ArrayList<>();

        List<Jogo> jogoExistentes = repository.findByData(dataJogo);

        if (!jogoExistentes.isEmpty()) {
            for (int i=0; i < jogoExistentes.size(); i++) {
                JogoDTO retorno = new JogoDTO();
                retorno.setData(jogoExistentes.get(i).getData());
                repositoryTime.findByCodigoTime(jogoExistentes.get(i).getId().getCodigoPrimeiroTime()).
                        ifPresent(time -> retorno.setPrimeiroTime(time.getNome()));
                repositoryTime.findByCodigoTime(jogoExistentes.get(i).getId().getCodigoSegundoTime()).
                        ifPresent(time -> retorno.setSegundoTime(time.getNome()));
                jogos.add(retorno);
            }
         } else {
            throw new BusinessException("NAO HA JOGOS PARA ESSA DATA");
        }


        return jogos;
    }

    private List<Time> detalheTimes(int timeA, int timeB) {
        return repositoryTime.listarPorNome(timeA, timeB);
    }

    public void gerarJogos() {
        log.info("Iniciando geracao dos jogos. timestamp [{}]", LocalDateTime.now());
        builder.montarJogosCampeonato();
        log.info("Jogos gerados com sucesso.   timestamp[{}]", LocalDateTime.now());
    }
}

