package br.com.laboratoriobd.paulistao.repositories;

import br.com.laboratoriobd.paulistao.model.Jogo;
import br.com.laboratoriobd.paulistao.model.pk.JogoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, JogoPK> {

    List<Jogo> findByData(String data);

    Optional<Jogo> findFirstByData(String data);
}
