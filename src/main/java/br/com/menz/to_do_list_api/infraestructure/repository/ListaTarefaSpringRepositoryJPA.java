package br.com.menz.to_do_list_api.infraestructure.repository;

import br.com.menz.to_do_list_api.infraestructure.entity.ListaTarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ListaTarefaSpringRepositoryJPA extends JpaRepository<ListaTarefaEntity, UUID> {
}
