package br.senac.trecos.dto;

import br.senac.trecos.domain.Marca;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TrecoPatchDTO {

    @Positive(message = "O Preço deve ser positivo")
    @Column(nullable = false, precision = 16, scale = 2)
    private BigDecimal preco;

    private Boolean ativo = true;

}
