package br.com.laboratoriobd.paulistao.repositories;

import br.com.laboratoriobd.paulistao.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, String> {
}
