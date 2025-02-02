package ob.gustavo.assistentet20spring.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Entity(name = "deslocamento_t20")
public class DeslocamentoT20 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private Integer valorCaminhadaBase;

    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private Integer valorEscaladaBase;

    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private Integer valorVooBase;

    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private Integer valorNatacaoBase;

    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private Integer valorEscavacaoBase;

    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private Integer bonusCaminhada;

    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private Integer bonusEscalada;

    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private Integer bonusVoo;

    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private Integer bonusNatacao;

    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private Integer bonusEscavacao;


    @OneToOne(mappedBy = "deslocamento")
    @JsonIgnore
    private PersonagemT20 personagem;
}
