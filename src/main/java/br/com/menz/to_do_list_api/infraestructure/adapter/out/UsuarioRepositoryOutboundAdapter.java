package br.com.menz.to_do_list_api.infraestructure.adapter.out;

import br.com.menz.to_do_list_api.domain.model.Usuario;
import br.com.menz.to_do_list_api.domain.ports.out.UsuarioRepositoryOutboundPort;
import br.com.menz.to_do_list_api.infraestructure.entity.UsuarioEntity;
import br.com.menz.to_do_list_api.infraestructure.mapper.UsuarioMapper;
import br.com.menz.to_do_list_api.infraestructure.repository.UsuarioSpringRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UsuarioRepositoryOutboundAdapter implements UsuarioRepositoryOutboundPort {

    private final UsuarioSpringRepositoryJPA repositoryJPA;
    private final UsuarioMapper mapper;

    public UsuarioRepositoryOutboundAdapter(UsuarioSpringRepositoryJPA repositoryJPA, UsuarioMapper mapper) {
        this.repositoryJPA = repositoryJPA;
        this.mapper = mapper;
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        return mapper.toModel(repositoryJPA.save(mapper.toEntity(usuario)));
    }

    @Override
    public Optional<Usuario> buscarBySequencial(Usuario usuario) {
        UUID sequencialExtraidoDoObjeto = usuario.getSequencial();

        Optional<UsuarioEntity> usuarioBuscado = repositoryJPA.findById(sequencialExtraidoDoObjeto);

        return usuarioBuscado.map(mapper::toModel);
    }

    @Override
    public List<Usuario> buscarTodos() {
        List<UsuarioEntity> listaDeUsuarios = repositoryJPA.findAll();

        return listaDeUsuarios.stream()
                .map(mapper::toModel)
                .toList();
    }

    @Override
    public Usuario editarUsuario(Usuario usuario) {
        return mapper.toModel(repositoryJPA.save(mapper.toEntity(usuario)));
    }

    @Override
    public void deletarUsuarioBySequencial(UUID sequencial) {
        repositoryJPA.deleteById(sequencial);
    }
}
