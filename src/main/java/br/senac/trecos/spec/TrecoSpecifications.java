package br.senac.trecos.spec;

import br.senac.trecos.domain.Treco;
import org.springframework.data.jpa.domain.Specification;

public class TrecoSpecifications {
    public static Specification<Treco> nomeContains(String nome) {
        return (root, query, cb) -> nome == null || nome.isBlank()
                ? null
                : cb.like(cb.lower(root.get(nome)), "%" + nome.toLowerCase() + "%");
    }

    public static Specification<Treco> byCategoriaId(Long categoriaId) {
        return (root, query, cb) -> categoriaId == null
                ? null
                : cb.equal(root.get("categoria").get("id"), categoriaId);
    }

    public static Specification<Treco> byMarcaId(Long marcaId) {
        return (root, query, cb) -> marcaId == null
                ? null
                : cb.equal(root.get("marca").get("id"), marcaId);
    }

    public static Specification<Treco> byAtivo(Boolean ativo) {
        return (root, query, cb) -> ativo == null
                ? null
                : cb.equal(root.get("ativo").get("id"), ativo);
    }
}
