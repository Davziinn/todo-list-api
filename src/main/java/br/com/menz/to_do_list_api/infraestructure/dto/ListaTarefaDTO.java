package br.com.menz.to_do_list_api.infraestructure.dto;

import br.com.menz.to_do_list_api.domain.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListaTarefaDTO {

    private UUID sequencial;
    private String tituloLista;
    private String descricaoLista;
    private Usuario usuario;
    private List<TarefaDTO> tarefa;
}
