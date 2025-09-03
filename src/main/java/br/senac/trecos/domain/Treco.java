package br.senac.trecos.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.sql.Update;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Data
@Table(name = "trecos")
public class Treco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Campo nome é obrigatório")
    @Column(nullable = false)
    private String nome;

    private String descricao;

    @NotBlank(message = "Campo nome é obrigatório")
    @Positive(message= "O Preço deve ser positivo")
    @Column(nullable = false, precision = 16, scale =2)
    private BigDecimal preco;


    private Boolean ativo = true;

    //treco 1
    @ManyToOne (optional = false, fetch = FetchType.LAZY)
    @JoinColumn (name = "categoria_id", nullable = false)
    private Categoria Categoria;

    //0..1
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "marca_id")
    private Marca marca;
    @Column(name = "criado_em", nullable = false)
    private OffsetDateTime criadoEm;
    @Column(name = "atualizado_em", nullable = false)
    private OffsetDateTime atualizadoEm;

    @PrePersist
    public void prePersist(){
        OffsetDateTime agora = OffsetDateTime.now();
        if (ativo == null) ativo = true;
        this.criadoEm = agora;
        this.atualizadoEm = agora;

    }
    @PreUpdate
    public void preUpdate() {
        this.atualizadoEm = OffsetDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Treco)) return false;
        Treco that = (Treco)o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
