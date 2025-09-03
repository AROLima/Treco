package br.senac.trecos.repository;

import br.senac.trecos.domain.Categoria;
import br.senac.trecos.domain.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarcaRepository  extends JpaRepository<Marca, Long> {
    Optional<Marca> findByNomeIgnoreCase(String nome); //named query method

}
