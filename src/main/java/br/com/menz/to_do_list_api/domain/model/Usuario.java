package br.com.menz.to_do_list_api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario implements Serializable {

    private UUID sequencial;
    private String nome;
    private String email;
    private String senha;
    // private List<ListaTarefa> listasTarefas;
}
