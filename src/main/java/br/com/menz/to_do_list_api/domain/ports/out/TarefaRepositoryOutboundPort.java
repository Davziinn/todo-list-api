package br.com.menz.to_do_list_api.domain.ports.out;

import br.com.menz.to_do_list_api.domain.model.Tarefa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TarefaRepositoryOutboundPort {

    Tarefa salvarTarefa (Tarefa tarefa);

    Optional<Tarefa> buscarTarefaBySequencial (Tarefa tarefa);

    List<Tarefa> buscarTodasAsTarafas ();

    Tarefa editarTarefa(Tarefa tarefa);

    void deletarTarefaBySequencial (UUID sequencial);
}
