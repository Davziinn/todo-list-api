package br.com.menz.to_do_list_api.infraestructure.dto;

import br.com.menz.to_do_list_api.domain.enums.StatusTarefaEnum;
import br.com.menz.to_do_list_api.domain.model.ListaTarefa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefaDTO {
    private UUID sequencial;
    private String tituloTarefa;
    private String descricaoTarefa;
    private StatusTarefaEnum statusTarefa;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private LocalDate prazoTarefa;
    private ListaTarefa listaTarefa;
    private TarefaTagDTO tarefaTag;
}
