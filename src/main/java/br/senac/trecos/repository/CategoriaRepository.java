package br.senac.trecos.repository;

import br.senac.trecos.domain.Categoria;
import br.senac.trecos.domain.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNomeIgnoreCase(String nome); //named query method
}
