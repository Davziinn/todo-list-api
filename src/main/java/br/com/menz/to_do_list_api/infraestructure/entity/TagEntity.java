package br.com.menz.to_do_list_api.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "T01TAG")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "SQ_TAG")
    private UUID sequencial;

    @Column(name = "NM_TAGJ")
    private String nomeTag;

    @OneToMany(mappedBy = "sequencialTag", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TarefaTagEntity> tarefasTags;
}
