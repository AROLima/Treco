package br.senac.trecos.mapper;

import br.senac.trecos.domain.Categoria;
import br.senac.trecos.domain.Marca;
import br.senac.trecos.domain.Treco;
import br.senac.trecos.dto.TrecoRequestDTO;
import br.senac.trecos.dto.TrecoResponseDTO;

public class TrecoMapper {
    public static Treco toEntity(TrecoRequestDTO dto, Categoria categoria, Marca marca){
        Treco t = new Treco();
        t.setNome(dto.getNome());
        t.setDescricao(dto.getDescricao());
        t.setPreco(dto.getPreco());
        t.setAtivo(dto.getAtivo() == null ? Boolean.TRUE: dto.getAtivo());
        t.setMarca(dto.getMarca());
        return t;

    }

    public static void copyToEntity(TrecoRequestDTO dto, Categoria categoria, Marca marca){
        Treco t = new Treco();
        t.setNome(dto.getNome());
        t.setDescricao(dto.getDescricao());
        t.setPreco(dto.getPreco());
        t.setAtivo(dto.getAtivo() == null ? Boolean.TRUE: dto.getAtivo());
        t.setCategoria((categoria));
        t.setMarca(marca);
    }

    public static TrecoResponseDTO toDto(Treco t){
        TrecoResponseDTO d = new TrecoResponseDTO();
        d.setId(t.getId());
        d.setNome(t.getNome());
        d.setDescricao(t.getDescricao());
        d.setAtivo(t.getAtivo());
        d.setCriadoEm(t.getCriadoEm());
        d.setAtualizadoEm(t.getAtualizadoEm());
        if (t.getCategoria() != null){
            d.setCategoria(new TrecoResponseDTO.SimpleRef(t.getCategoria().getId(),t.getCategoria().getNome()));
        }
        if (t.getMarca() != null){
            d.setMarca(new TrecoResponseDTO.SimpleRef((t.getMarca().getId(),t.getMarca().getNome()));
        }
        return d;
    }
}
