package br.com.menz.to_do_list_api.infraestructure.mapper;

import br.com.menz.to_do_list_api.domain.model.Tarefa;
import br.com.menz.to_do_list_api.infraestructure.dto.TarefaDTO;
import br.com.menz.to_do_list_api.infraestructure.entity.TarefaEntity;

public interface TarefaMapper {

    Tarefa toModel (TarefaDTO dto);

    TarefaEntity toEntity (Tarefa model);

    Tarefa toModel (TarefaEntity entity);

    TarefaDTO toDTO (Tarefa model);
}
