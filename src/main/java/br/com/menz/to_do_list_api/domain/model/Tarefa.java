package br.com.menz.to_do_list_api.domain.model;

import br.com.menz.to_do_list_api.domain.enums.StatusTarefaEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tarefa implements Serializable {

    private UUID sequencial;
    private String tituloTarefa;
    private String descricaoTarefa;
    private StatusTarefaEnum statusTarefa;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private LocalDate prazoTarefa;
    private ListaTarefa listaTarefa;
    // private TarefaTag tarefaTag;
}
