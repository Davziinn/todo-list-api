package br.com.menz.to_do_list_api.infraestructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
public class TarefaTagEntityPK {

    @Column(name = "SQ_TAR")
    private UUID sequencialTarefa;

    @Column(name = "SQ_TAG")
    private UUID sequencialTag;
}
