package br.com.menz.to_do_list_api.infraestructure.adapter.rest.in;

import br.com.menz.to_do_list_api.infraestructure.dto.UsuarioDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
public interface UsuarioRestContract {

    @PostMapping
    ResponseEntity<UsuarioDTO> cadastrarUsuario (@Valid @RequestBody UsuarioDTO usuarioDTO);

    @GetMapping("/email")
    ResponseEntity<UsuarioDTO> buscarUsuarioByEmail (@PathVariable String email);
}
