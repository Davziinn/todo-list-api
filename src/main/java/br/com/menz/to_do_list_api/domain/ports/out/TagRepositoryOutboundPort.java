package br.com.menz.to_do_list_api.domain.ports.out;

import br.com.menz.to_do_list_api.domain.model.Tag;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TagRepositoryOutboundPort {

    Tag salvarTag (Tag tag);

    Optional<Tag> buscarBySequencial (UUID sequencial);

    List<Tag> buscarTodasTags ();

    Tag editarTag (Tag tag);

    void deletarTagBySequencial (UUID sequencial);
}
