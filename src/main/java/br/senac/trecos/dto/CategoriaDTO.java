package br.senac.trecos.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoriaDTO {
    private Long id;

    @NotBlank(message = "Campo nome é obrigatório")
    private String nome;
    private String descricao;
}
