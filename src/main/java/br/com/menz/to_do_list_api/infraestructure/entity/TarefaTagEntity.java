package br.com.menz.to_do_list_api.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "T01TTAG")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TarefaTagEntity {

    @EmbeddedId
    private TarefaTagEntityPK sequencial;

    @ManyToOne
    @MapsId("sequencialTarefa")
    @JoinColumn(name = "SQ_TAR")
    private TarefaEntity sequencialTarefa;

    @ManyToOne
    @MapsId("sequencialTag")
    @JoinColumn(name = "SQ_TAG")
    private TagEntity sequencialTag;
}
