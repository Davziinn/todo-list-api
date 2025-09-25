package br.com.menz.to_do_list_api.domain.service;

import br.com.menz.to_do_list_api.domain.exceptions.TagNotFoundException;
import br.com.menz.to_do_list_api.domain.model.Tag;
import br.com.menz.to_do_list_api.domain.ports.in.TagServiceInboundPort;
import br.com.menz.to_do_list_api.domain.ports.out.TagRepositoryOutboundPort;

public class TagService implements TagServiceInboundPort {

    private final TagRepositoryOutboundPort tagRepositoryOutboundPort;

    public TagService(TagRepositoryOutboundPort tagRepositoryOutboundPort) {
        this.tagRepositoryOutboundPort = tagRepositoryOutboundPort;
    }

    @Override
    public Tag cadastrarTag(Tag tag) {

        return tagRepositoryOutboundPort.salvarTag(tag);
    }
}
