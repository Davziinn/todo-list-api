package br.com.menz.to_do_list_api.infraestructure.mapper;

import br.com.menz.to_do_list_api.domain.model.ListaTarefa;
import br.com.menz.to_do_list_api.infraestructure.dto.ListaTarefaDTO;
import br.com.menz.to_do_list_api.infraestructure.entity.ListaTarefaEntity;

public interface ListaTarefaMapper {

    ListaTarefa toModel (ListaTarefaDTO dto);

    ListaTarefaEntity toEntity (ListaTarefa model);

    ListaTarefa toModel (ListaTarefaEntity entity);

    ListaTarefaDTO toDTO (ListaTarefa model);
}
