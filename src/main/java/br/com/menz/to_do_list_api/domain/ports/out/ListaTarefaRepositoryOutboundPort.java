package br.com.menz.to_do_list_api.domain.ports.out;

import br.com.menz.to_do_list_api.domain.model.ListaTarefa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ListaTarefaRepositoryOutboundPort {

    ListaTarefa salvarListaTarefa (ListaTarefa listaTarefa);

    Optional<ListaTarefa> buscarListaTarefaBySequencial(ListaTarefa listaTarefa);

    List<ListaTarefa> buscarTodasAsListaTarefa ();

    ListaTarefa editarListaTarefa(ListaTarefa listaTarefa);

    void deletarListaTarefaBySequencial(UUID sequencial);
}
