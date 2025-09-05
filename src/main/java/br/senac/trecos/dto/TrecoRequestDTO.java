package br.senac.trecos.dto;

import br.senac.trecos.domain.Categoria;
import br.senac.trecos.domain.Marca;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TrecoRequestDTO {
    @NotBlank(message = "Campo nome é obrigatório")
    @Column(nullable = false)
    private String nome;

    private String descricao;

    @NotBlank(message = "Campo nome é obrigatório")
    @Positive(message = "O Preço deve ser positivo")
    @Column(nullable = false, precision = 16, scale = 2)
    private BigDecimal preco;


    private Boolean ativo = true;

    //treco 1
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", nullable = false)
    private br.senac.trecos.domain.Categoria Categoria;

    //0..1
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marca_id")
    private Marca marca;

    private Long categoriaId;

    private Long marcaId;

}
