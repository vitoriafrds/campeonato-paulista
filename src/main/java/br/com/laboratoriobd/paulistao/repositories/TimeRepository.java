package br.com.laboratoriobd.paulistao.repositories;

import br.com.laboratoriobd.paulistao.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeRepository extends JpaRepository<Time, Integer> {

    @Query(value = "SELECT * FROM TIMES WHERE CODIGO_TIME IN(?1, ?2) ORDER BY CODIGO_TIME ASC", nativeQuery = true)
    List<Time> listarPorNome(int codigoPrimeiroTime, int codigoSegundoTime);
}
