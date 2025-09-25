package br.com.menz.to_do_list_api.domain.ports.in;

import br.com.menz.to_do_list_api.domain.model.Tag;

public interface TagServiceInboundPort {

    Tag cadastrarTag (Tag tag);
}
