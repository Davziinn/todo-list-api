package br.com.menz.to_do_list_api.infraestructure.mapper;

import br.com.menz.to_do_list_api.domain.model.ListaTarefa;
import br.com.menz.to_do_list_api.infraestructure.dto.ListaTarefaDTO;
import br.com.menz.to_do_list_api.infraestructure.entity.ListaTarefaEntity;

public class ListaTarefaMapperImpl implements ListaTarefaMapper {

    @Override
    public ListaTarefa toModel(ListaTarefaDTO dto) {
        return ListaTarefa.builder()
                .sequencial(dto.getSequencial())
                .tituloLista(dto.getTituloLista())
                .descricaoLista(dto.getDescricaoLista())
                .usuario(dto.getUsuario())
                .build();
    }

    @Override
    public ListaTarefaEntity toEntity(ListaTarefa model) {
        return ListaTarefaEntity.builder()
                .sequencial(model.getSequencial())
                .tituloLista(model.getTituloLista())
                .descricaoLista(model.getDescricaoLista())
                .build();
    }

    @Override
    public ListaTarefa toModel(ListaTarefaEntity entity) {
        return ListaTarefa.builder()
                .sequencial(entity.getSequencial())
                .tituloLista(entity.getTituloLista())
                .descricaoLista(entity.getDescricaoLista())
                .build();
    }

    @Override
    public ListaTarefaDTO toDTO(ListaTarefa model) {
        return ListaTarefaDTO.builder()
                .sequencial(model.getSequencial())
                .tituloLista(model.getTituloLista())
                .descricaoLista(model.getDescricaoLista())
                .usuario(model.getUsuario())
                .build();
    }
}
