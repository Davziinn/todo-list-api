package br.com.menz.to_do_list_api.infraestructure.adapter.rest.in;

import br.com.menz.to_do_list_api.domain.ports.in.TagServiceInboundPort;
import br.com.menz.to_do_list_api.infraestructure.dto.TagDTO;
import br.com.menz.to_do_list_api.infraestructure.mapper.TagMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @Override
    @GetMapping("/{sequencial}")
    public ResponseEntity<TagDTO> buscarTagBySequencial (@PathVariable UUID sequencial) {
        TagDTO tagBuscada = mapper.toDTO(tagService.buscarTagBySequencial(sequencial));

        return ResponseEntity.status(HttpStatus.FOUND).body(tagBuscada);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<TagDTO>> listarTodasTags() {
        List<TagDTO> tagsEncontradas = tagService.buscarTodasTags()
                .stream()
                .map(mapper::toDTO)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(tagsEncontradas);
    }

    @Override
    @PutMapping("/{sequencial}")
    public ResponseEntity<TagDTO> editarTag(@PathVariable UUID sequencial, @RequestBody TagDTO tagDTO) {
        TagDTO tagEditada = mapper.toDTO(tagService.editarTag(mapper.toModel(tagDTO)));

        return ResponseEntity.status(HttpStatus.CREATED).body(tagEditada);
    }

    @Override
    @DeleteMapping("/{sequencial}")
    public ResponseEntity<Void> deletarTagBySequencial(@PathVariable UUID sequencial) {
        tagService.deletarTagBySequencial(sequencial);

        return ResponseEntity.noContent().build();
    }
}
