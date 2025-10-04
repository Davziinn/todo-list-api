package br.com.menz.to_do_list_api.domain.ports.in;

import br.com.menz.to_do_list_api.domain.model.Tag;

import java.util.List;
import java.util.UUID;

public interface TagServiceInboundPort {

    Tag cadastrarTag (Tag tag);

    Tag buscarTagBySequencial (UUID sequencial);

    List<Tag> buscarTodasTags ();

    Tag editarTag (Tag novaTag);

    void deletarTagBySequencial(UUID sequencial);
}
