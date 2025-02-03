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
    private Integer caminhada;

    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private Integer escalada;

    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private Integer voo;

    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private Integer natacao;

    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private Integer escavacao;

    @OneToOne(mappedBy = "deslocamento")
    @JsonIgnore
    private PersonagemT20 personagem;
}
