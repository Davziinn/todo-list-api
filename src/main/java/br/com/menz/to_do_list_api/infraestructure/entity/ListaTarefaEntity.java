package br.com.menz.to_do_list_api.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "T01LTAF")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListaTarefaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "SQ_LTAF")
    private UUID sequencial;

    @Column(name = "TIT_LST")
    private String tituloLista;

    @Column(name = "DES_LST")
    private String descricaoLista;

    @ManyToOne
    @JoinColumn(name = "SQ_USU")
    private UsuarioEntity usuario;

    @OneToMany(mappedBy = "listaTarefa")
    private List<TarefaEntity> tarefas;
}
