    package br.com.menz.to_do_list_api.infraestructure.entity;

    import br.com.menz.to_do_list_api.domain.enums.StatusTarefaEnum;
    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import org.hibernate.annotations.CreationTimestamp;

    import java.time.LocalDate;
    import java.util.Set;
    import java.util.UUID;

    @Entity
    @Table(name = "T01TARF")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class TarefaEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        @Column(name = "SQ_TAR")
        private UUID sequencial;

        @Column(name = "TT_TAR")
        private String tituloTarefa;

        @Column(name = "DE_TAR")
        private String descricaoTarefa;

        @Enumerated(EnumType.STRING)
        @Column(name = "ST_TAR", nullable = false, length = 20)
        private StatusTarefaEnum statusTarefa;

        @CreationTimestamp
        @Column(name = "DT_INI")
        private LocalDate dataInicio;

        @Column(name = "DT_FIM")
        private LocalDate dataFim;

        @Column(name = "PR_TAF")
        private LocalDate prazoTarefa;

        @ManyToOne
        @JoinColumn(name = "SQ_LTAF")
        private ListaTarefaEntity listaTarefa;

        @OneToMany(mappedBy = "sequencialTarefa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private Set<TarefaTagEntity> tarefasTags;
    }
