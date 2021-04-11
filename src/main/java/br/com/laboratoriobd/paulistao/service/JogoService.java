package br.com.laboratoriobd.paulistao.service;

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

    public JogoDTO pesquisar(String dataJogo) {
        JogoDTO retorno = new JogoDTO();
        Optional<Jogo> jogo = repository.findByData(dataJogo);

        if (jogo.isPresent()) {
            retorno.setData(jogo.get().getData());

            List<Time> times = detalheTimes(jogo.get().getId().getCodigoPrimeiroTime(), jogo.get().getId().getCodigoSegundoTime());
            retorno.setPrimeiroTime(times.get(0).getNome());
            retorno.setSegundoTime(times.get(1).getNome());
        }
        return retorno;
    }

    private List<Time> detalheTimes(int timeA, int timeB) {
        return repositoryTime.listarPorNome(timeA, timeB);
    }

    public void gerarJogos() {
        log.info("Iniciando geracao dos jogos... timestamp[{}]", LocalDateTime.now());
        builder.montarJogosCampeonato();
        log.info("Jogos gerados com sucesso... timestamp[{}]", LocalDateTime.now());
    }
}
