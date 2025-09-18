package br.com.menz.to_do_list_api.infraestructure.adapter.out;

import br.com.menz.to_do_list_api.domain.model.Tarefa;
import br.com.menz.to_do_list_api.domain.ports.out.TarefaRepositoryOutboundPort;
import br.com.menz.to_do_list_api.infraestructure.entity.TarefaEntity;
import br.com.menz.to_do_list_api.infraestructure.mapper.TarefaMapper;
import br.com.menz.to_do_list_api.infraestructure.repository.TarefaSpringRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class TarefaRepositoryOutboundAdapter implements TarefaRepositoryOutboundPort {

    private final TarefaSpringRepositoryJPA repositoryJPA;
    private final TarefaMapper mapper;

    public TarefaRepositoryOutboundAdapter(TarefaSpringRepositoryJPA repositoryJPA, TarefaMapper mapper) {
        this.repositoryJPA = repositoryJPA;
        this.mapper = mapper;
    }

    @Override
    public Tarefa salvarTarefa(Tarefa tarefa) {
        return mapper.toModel(repositoryJPA.save(mapper.toEntity(tarefa)));
    }

    @Override
    public Optional<Tarefa> buscarTarefaBySequencial(Tarefa tarefa) {
        UUID extrairSequenciaDoObjeto = tarefa.getSequencial();

        Optional<TarefaEntity> tarefaBuscada = repositoryJPA.findById(extrairSequenciaDoObjeto);

        return tarefaBuscada.map(mapper::toModel);
    }

    @Override
    public List<Tarefa> buscarTodasAsTarafas() {
        List<TarefaEntity> listaDeTarefasBuscadas = repositoryJPA.findAll();

        return listaDeTarefasBuscadas.stream()
                .map(mapper::toModel)
                .toList();
    }

    @Override
    public Tarefa editarTarefa(Tarefa tarefa) {
        return mapper.toModel(repositoryJPA.save(mapper.toEntity(tarefa)));
    }

    @Override
    public void deletarTarefaBySequencial(UUID sequencial) {
        repositoryJPA.deleteById(sequencial);
    }
}
