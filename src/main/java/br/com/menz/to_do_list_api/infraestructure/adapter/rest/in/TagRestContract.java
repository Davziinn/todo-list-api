package br.com.menz.to_do_list_api.infraestructure.adapter.rest.in;

import br.com.menz.to_do_list_api.infraestructure.dto.TagDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface TagRestContract {

    @PostMapping
    ResponseEntity<TagDTO> cadastrarTag (@Valid @RequestBody TagDTO tag);

    @GetMapping("/{sequencial}")
    ResponseEntity<TagDTO> buscarTagBySequencial (@PathVariable UUID sequencial);

    @GetMapping
    ResponseEntity<List<TagDTO>> listarTodasTags ();

    @PutMapping("/{sequencial}")
    ResponseEntity<TagDTO> editarTag (@PathVariable UUID sequencial, @RequestBody TagDTO tagDTO);

    @DeleteMapping("/{sequencial}")
    ResponseEntity<Void> deletarTagBySequencial (@PathVariable UUID sequencial);
}
