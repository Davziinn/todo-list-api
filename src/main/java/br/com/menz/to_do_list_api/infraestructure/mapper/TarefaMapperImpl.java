package br.com.menz.to_do_list_api.infraestructure.mapper;

import br.com.menz.to_do_list_api.domain.model.Tarefa;
import br.com.menz.to_do_list_api.infraestructure.dto.TarefaDTO;
import br.com.menz.to_do_list_api.infraestructure.entity.TarefaEntity;

public class TarefaMapperImpl implements TarefaMapper {

    @Override
    public Tarefa toModel(TarefaDTO dto) {
        return Tarefa.builder()
                .sequencial(dto.getSequencial())
                .tituloTarefa(dto.getTituloTarefa())
                .descricaoTarefa(dto.getDescricaoTarefa())
                .dataInicio(dto.getDataInicio())
                .dataFim(dto.getDataFim())
                .prazoTarefa(dto.getPrazoTarefa())
                .statusTarefa(dto.getStatusTarefa())
                .listaTarefa(dto.getListaTarefa())
                .build();
    }

    @Override
    public TarefaEntity toEntity(Tarefa model) {
        return TarefaEntity.builder()
                .sequencial(model.getSequencial())
                .tituloTarefa(model.getTituloTarefa())
                .descricaoTarefa(model.getDescricaoTarefa())
                .dataInicio(model.getDataInicio())
                .dataFim(model.getDataFim())
                .prazoTarefa(model.getPrazoTarefa())
                .statusTarefa(model.getStatusTarefa())
                .build();
    }

    @Override
    public Tarefa toModel(TarefaEntity entity) {
        return Tarefa.builder()
                .sequencial(entity.getSequencial())
                .tituloTarefa(entity.getTituloTarefa())
                .descricaoTarefa(entity.getDescricaoTarefa())
                .dataInicio(entity.getDataInicio())
                .dataFim(entity.getDataFim())
                .prazoTarefa(entity.getPrazoTarefa())
                .statusTarefa(entity.getStatusTarefa())
                .build();
    }

    @Override
    public TarefaDTO toDTO(Tarefa model) {
        return TarefaDTO.builder()
                .sequencial(model.getSequencial())
                .tituloTarefa(model.getTituloTarefa())
                .descricaoTarefa(model.getDescricaoTarefa())
                .dataInicio(model.getDataInicio())
                .dataFim(model.getDataFim())
                .prazoTarefa(model.getPrazoTarefa())
                .statusTarefa(model.getStatusTarefa())
                .build();
    }
}
