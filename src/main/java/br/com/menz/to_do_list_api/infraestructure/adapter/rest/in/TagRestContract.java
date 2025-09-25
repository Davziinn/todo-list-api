package br.com.menz.to_do_list_api.infraestructure.adapter.rest.in;

import br.com.menz.to_do_list_api.infraestructure.dto.TagDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface TagRestContract {

    @PostMapping
    ResponseEntity<TagDTO> cadastrarTag (@Valid @RequestBody TagDTO tag);
}
