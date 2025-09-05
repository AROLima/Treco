package br.senac.trecos.repository;

import br.senac.trecos.domain.Marca;
import br.senac.trecos.domain.Treco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrecoRepository extends JpaRepository <Treco,Long> {
    Optional<Treco> findByNomeIgnoreCase(String nome);
}
