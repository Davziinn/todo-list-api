package br.com.menz.to_do_list_api.infraestructure.adapter.out;

import br.com.menz.to_do_list_api.domain.model.Tag;
import br.com.menz.to_do_list_api.domain.ports.out.TagRepositoryOutboundPort;
import br.com.menz.to_do_list_api.infraestructure.entity.TagEntity;
import br.com.menz.to_do_list_api.infraestructure.mapper.TagMapper;
import br.com.menz.to_do_list_api.infraestructure.repository.TagSpringRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class TagRepositoryOutboundAdapter implements TagRepositoryOutboundPort {

    private final TagSpringRepositoryJPA repositoryJPA;
    private final TagMapper mapper;

    public TagRepositoryOutboundAdapter(TagSpringRepositoryJPA repositoryJPA, TagMapper mapper) {
        this.repositoryJPA = repositoryJPA;
        this.mapper = mapper;
    }

    @Override
    public Tag salvarTag(Tag tag) {
        return mapper.toModel(repositoryJPA.save(mapper.toEntity(tag)));
    }

    @Override
    public Optional<Tag> buscarBySequencial(UUID sequencial) {
        Optional<TagEntity> tagBuscada = repositoryJPA.findById(sequencial);
        return tagBuscada.map(mapper::toModel);
    }

    @Override
    public List<Tag> buscarTodasTags() {
        List<TagEntity> listaDeTagsBuscadas = repositoryJPA.findAll();

        return listaDeTagsBuscadas.stream()
                .map(mapper::toModel)
                .toList();

    }

    @Override
    public Tag editarTag(Tag tag) {
        return mapper.toModel(repositoryJPA.save(mapper.toEntity(tag)));
    }

    @Override
    public void deletarTagBySequencial(UUID sequencial) {
        repositoryJPA.deleteById(sequencial);
    }
}
