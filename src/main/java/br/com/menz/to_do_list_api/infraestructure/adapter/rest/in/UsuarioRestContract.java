package br.com.menz.to_do_list_api.infraestructure.adapter.rest.in;

import br.com.menz.to_do_list_api.infraestructure.dto.UsuarioDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface UsuarioRestContract {

    @PostMapping
    ResponseEntity<UsuarioDTO> cadastrarUsuario (@Valid @RequestBody UsuarioDTO usuarioDTO);

    @GetMapping("/email")
    ResponseEntity<UsuarioDTO> buscarUsuarioByEmail (@PathVariable String email);

    @GetMapping
    ResponseEntity<List<UsuarioDTO>> buscarTodosOsUsuarios ();

    @PutMapping("/{sequencial}")
    ResponseEntity<UsuarioDTO> editarUsuario (@Valid @PathVariable UUID sequencial, @RequestBody UsuarioDTO usuarioEditado);

    @DeleteMapping("/{sequencial}")
    ResponseEntity<Void> deletarUsuarioBySequencial (@PathVariable UUID sequencial);
}
