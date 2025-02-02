package ob.gustavo.assistentet20spring.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Entity(name = "pericia_t20")
public class PericiaT20 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @NotNull
    @Length(max = 100)
    @Column(nullable = false, length = 100)
    private String nome;

    @NotNull
    @Column(nullable = false)
    private Boolean ehTreinado;

    @NotNull
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String categoria;

    @NotNull
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String atributo;

    @NotNull
    @Column(nullable = false)
    private Boolean requerTreinamento;

    @NotNull
    @Column(nullable = false)
    private Boolean sofrePenalidadeArmadura;

    @ManyToOne
    @JoinColumn(name = "personagem_t20_id")
    @JsonIgnore
    private PersonagemT20 personagem;
}
