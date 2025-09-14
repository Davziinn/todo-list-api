package br.com.menz.to_do_list_api.infraestructure.mapper;

import br.com.menz.to_do_list_api.domain.model.Tag;
import br.com.menz.to_do_list_api.infraestructure.dto.TagDTO;
import br.com.menz.to_do_list_api.infraestructure.entity.TagEntity;

public interface TagMapper {

    Tag toModel (TagDTO dto);

    TagEntity toEntity(Tag model);

    Tag toModel(TagEntity entity);

    TagDTO toDTO(Tag model);
}
