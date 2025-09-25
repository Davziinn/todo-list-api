package br.com.menz.to_do_list_api.infraestructure.adapter.rest.in;

import br.com.menz.to_do_list_api.domain.ports.in.TagServiceInboundPort;
import br.com.menz.to_do_list_api.infraestructure.dto.TagDTO;
import br.com.menz.to_do_list_api.infraestructure.mapper.TagMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/tags")
public class TagController implements TagRestContract {

    private final TagServiceInboundPort tagService;
    private final TagMapper mapper;

    public TagController(TagServiceInboundPort tagService, TagMapper mapper) {
        this.tagService = tagService;
        this.mapper = mapper;
    }

    @Override
    @PostMapping
    public ResponseEntity<TagDTO> cadastrarTag(@Valid @RequestBody TagDTO tag) {
        TagDTO tagSalva = mapper.toDTO(tagService.cadastrarTag(mapper.toModel(tag)));

        return ResponseEntity.status(HttpStatus.CREATED).body(tagSalva);
    }
}
