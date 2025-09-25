package br.com.menz.to_do_list_api.infraestructure.adapter.rest.in;

import br.com.menz.to_do_list_api.domain.ports.in.UsuarioServiceInboundPort;
import br.com.menz.to_do_list_api.infraestructure.dto.UsuarioDTO;
import br.com.menz.to_do_list_api.infraestructure.mapper.UsuarioMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController implements UsuarioRestContract {

    private final UsuarioServiceInboundPort usuarioService;
    private final UsuarioMapper mapper;

    public UsuarioController(UsuarioServiceInboundPort usuarioService, UsuarioMapper mapper) {
        this.usuarioService = usuarioService;
        this.mapper = mapper;
    }

    @Override
    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioSalvo = mapper.toDTO(usuarioService.criarUsuario(mapper.toModel(usuarioDTO)));

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }

    @Override
    @GetMapping("/{email}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioByEmail(@PathVariable String email) {
        UsuarioDTO emailBuscado = mapper.toDTO(usuarioService.buscarUsuarioByEmail(email));
        return ResponseEntity.status(HttpStatus.OK).body(emailBuscado);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> buscarTodosOsUsuarios() {
        List<UsuarioDTO> usuariosBuscados = usuarioService.buscarTodosOsUsuarios()
                .stream()
                .map(mapper::toDTO)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(usuariosBuscados);
    }

    @Override
    @PutMapping("/{sequencial}")
    public ResponseEntity<UsuarioDTO> editarUsuario(@Valid @PathVariable UUID sequencial, @RequestBody UsuarioDTO usuarioEditado) {
        UsuarioDTO novoUsuarioEditado = mapper.toDTO(usuarioService.editarUsuario(sequencial, mapper.toModel(usuarioEditado)));

        return ResponseEntity.status(HttpStatus.OK).body(novoUsuarioEditado);
    }
}
