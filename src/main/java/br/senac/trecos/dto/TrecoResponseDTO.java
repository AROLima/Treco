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
import java.time.OffsetDateTime;
@Data
public class TrecoResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Boolean ativo = true;
    private SimpleRef categoria;
    private SimpleRef marca;
    private OffsetDateTime criadoEm;
    private OffsetDateTime atualizadoEm;

    public static class SimpleRef{
        private Long id;
        private String nome;

        public SimpleRef(){}
        public SimpleRef(Long id, String nome){this.id = id; this.nome = nome;}
        public Long getId() {return id;}
        public void setId(Long id) {this.id = id;}
        public String getNome() {return nome;}
        public void setNome(String nome) {this.nome = nome;}

    }

}
