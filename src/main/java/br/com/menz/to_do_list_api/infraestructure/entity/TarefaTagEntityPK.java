package br.com.menz.to_do_list_api.infraestructure.entity;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Embeddable
@EqualsAndHashCode
public class TarefaTagEntityPK {

    private UUID sequencialTarefa;

    private UUID sequencialTag;
}
