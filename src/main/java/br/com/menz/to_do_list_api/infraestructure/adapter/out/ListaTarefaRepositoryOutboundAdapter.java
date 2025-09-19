package br.com.menz.to_do_list_api.infraestructure.adapter.out;

import br.com.menz.to_do_list_api.domain.model.ListaTarefa;
import br.com.menz.to_do_list_api.domain.ports.out.ListaTarefaRepositoryOutboundPort;
import br.com.menz.to_do_list_api.infraestructure.entity.ListaTarefaEntity;
import br.com.menz.to_do_list_api.infraestructure.mapper.ListaTarefaMapper;
import br.com.menz.to_do_list_api.infraestructure.repository.ListaTarefaSpringRepositoryJPA;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ListaTarefaRepositoryOutboundAdapter implements ListaTarefaRepositoryOutboundPort {

    private final ListaTarefaSpringRepositoryJPA repositoryJPA;
    private final ListaTarefaMapper mapper;

    public ListaTarefaRepositoryOutboundAdapter(ListaTarefaSpringRepositoryJPA repositoryJPA, ListaTarefaMapper mapper) {
        this.repositoryJPA = repositoryJPA;
        this.mapper = mapper;
    }

    @Override
    public ListaTarefa salvarListaTarefa(ListaTarefa listaTarefa) {
        return mapper.toModel(repositoryJPA.save(mapper.toEntity(listaTarefa)));
    }

    @Override
    public Optional<ListaTarefa> buscarListaTarefaBySequencial(ListaTarefa listaTarefa) {
        UUID sequencialExtraidoDoObjeto = listaTarefa.getSequencial();

        Optional<ListaTarefaEntity> listaTarefaBuscada = repositoryJPA.findById(sequencialExtraidoDoObjeto);

        return listaTarefaBuscada.map(mapper::toModel);
    }

    @Override
    public List<ListaTarefa> buscarTodasAsListaTarefa() {
        List<ListaTarefaEntity> listasBuscadas = repositoryJPA.findAll();

        return listasBuscadas.stream()
                .map(mapper::toModel)
                .toList();
    }

    @Override
    public ListaTarefa editarListaTarefa(ListaTarefa listaTarefa) {
        return mapper.toModel(repositoryJPA.save(mapper.toEntity(listaTarefa)));
    }

    @Override
    public void deletarListaTarefaBySequencial(UUID sequencial) {
        repositoryJPA.deleteById(sequencial);
    }
}
