package br.com.menz.to_do_list_api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TarefaTag implements Serializable {

    private Tarefa sequencialTarefa;
    private Tag sequencialTag;
}
