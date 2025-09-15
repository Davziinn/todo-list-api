package br.com.menz.to_do_list_api.infraestructure.repository;

import br.com.menz.to_do_list_api.infraestructure.entity.TarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TarefaSpringRepositoryJPA extends JpaRepository<TarefaEntity, UUID> {
}
