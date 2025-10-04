package br.com.menz.to_do_list_api.domain.service;

import br.com.menz.to_do_list_api.domain.exceptions.TagNotFoundException;
import br.com.menz.to_do_list_api.domain.model.Tag;
import br.com.menz.to_do_list_api.domain.ports.in.TagServiceInboundPort;
import br.com.menz.to_do_list_api.domain.ports.out.TagRepositoryOutboundPort;

import java.util.List;
import java.util.UUID;

public class TagService implements TagServiceInboundPort {

    private final TagRepositoryOutboundPort tagRepositoryOutboundPort;

    public TagService(TagRepositoryOutboundPort tagRepositoryOutboundPort) {
        this.tagRepositoryOutboundPort = tagRepositoryOutboundPort;
    }

    @Override
    public Tag cadastrarTag(Tag tag) {
        return tagRepositoryOutboundPort.salvarTag(tag);
    }

    @Override
    public Tag buscarTagBySequencial(UUID sequencial) {
        return tagRepositoryOutboundPort.buscarBySequencial(sequencial)
                .orElseThrow(() -> new TagNotFoundException("Tag não encontrada"));
    }

    @Override
    public List<Tag> buscarTodasTags() {
        return tagRepositoryOutboundPort.buscarTodasTags();
    }

    @Override
    public Tag editarTag(Tag novaTag) {
        Tag tagBuscada = tagRepositoryOutboundPort.buscarBySequencial(novaTag.getSequencial())
                .orElseThrow(() -> new TagNotFoundException("Tag não encontrada"));

        tagBuscada.setNomeTag(novaTag.getNomeTag());

        return tagRepositoryOutboundPort.editarTag(tagBuscada);
    }

    @Override
    public void deletarTagBySequencial(UUID sequencial) {
        tagRepositoryOutboundPort.deletarTagBySequencial(sequencial);
    }


}
