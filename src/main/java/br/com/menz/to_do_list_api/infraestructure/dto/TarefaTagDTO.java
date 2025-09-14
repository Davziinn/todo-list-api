package br.com.menz.to_do_list_api.infraestructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TarefaTagDTO {
    private TarefaDTO sequencialTarefa;
    private TagDTO sequencialTag;
}
