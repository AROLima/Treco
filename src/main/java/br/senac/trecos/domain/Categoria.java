package br.senac.trecos.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "marca")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo é obrigatório")
    @Column(nullable = false, unique = true)
    private String nome;

    private String descricao;

    @Override
    public boolean equals(Object o) {
        if(this ==o) return true;
        if(!(o instanceof Categoria)) return false;
        Categoria that = (Categoria)o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
