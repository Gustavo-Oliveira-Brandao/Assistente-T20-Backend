package ob.gustavo.assistentet20spring.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Entity(name = "mana_t20")
public class ManaT20 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Integer valorAtual;

    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private Integer valorTemporario;

    @NotNull
    @Column(nullable = false)
    private Integer bonusPorNivel;

    @NotNull
    @Column(nullable = false)
    private Integer bonusBase;

    @OneToOne(mappedBy = "mana")
    @JsonIgnore
    private PersonagemT20 personagem;

}
