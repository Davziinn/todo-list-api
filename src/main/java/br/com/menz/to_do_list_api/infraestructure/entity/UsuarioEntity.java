package br.com.menz.to_do_list_api.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "T01USU")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "SQ_USU")
    private UUID sequencial;

    @Column(name = "NM_USU")
    private String nomeCompleto;

    @Column(name = "EM_USU")
    private String email;

    @Column(name = "PSS_USU")
    private String password;
}
