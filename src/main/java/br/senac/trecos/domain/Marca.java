package br.senac.trecos.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo é obrigatório")
    @Column(nullable = false, unique = true)
    private String nome;

    @Override
    public boolean equals(Object o) {
        if(this ==o) return true;
        if(!(o instanceof Marca)) return false;
        Marca that = (Marca)o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
