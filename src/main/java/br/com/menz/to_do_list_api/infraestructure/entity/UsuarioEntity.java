package br.com.menz.to_do_list_api.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "T01USU")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "SQ_USU")
    private UUID sequencial;

    @Column(name = "NM_USU", nullable = false, length = 50)
    private String nome;

    @Column(name = "EML_USU", nullable = false, length = 50)
    private String email;

    @Column(name = "SEN_USU", nullable = false, length = 255)
    private String senha;

    @OneToMany(mappedBy = "usuario")
    private List<ListaTarefaEntity> listasTarefas;
}
