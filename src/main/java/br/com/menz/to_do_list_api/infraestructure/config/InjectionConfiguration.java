package br.com.menz.to_do_list_api.infraestructure.config;

import br.com.menz.to_do_list_api.domain.ports.in.TagServiceInboundPort;
import br.com.menz.to_do_list_api.domain.ports.in.UsuarioServiceInboundPort;
import br.com.menz.to_do_list_api.domain.ports.out.TagRepositoryOutboundPort;
import br.com.menz.to_do_list_api.domain.ports.out.UsuarioRepositoryOutboundPort;
import br.com.menz.to_do_list_api.domain.service.TagService;
import br.com.menz.to_do_list_api.domain.service.UsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InjectionConfiguration {

    @Bean
    public UsuarioServiceInboundPort usuarioService(UsuarioRepositoryOutboundPort usuarioRepositoryOutboundPort) {
        return new UsuarioService(usuarioRepositoryOutboundPort);
    }

    @Bean
    public TagServiceInboundPort tagService (TagRepositoryOutboundPort tagRepositoryOutboundPort) {
        return new TagService(tagRepositoryOutboundPort);
    }

}
