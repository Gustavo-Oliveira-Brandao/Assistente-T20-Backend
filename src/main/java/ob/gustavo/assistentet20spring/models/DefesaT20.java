package ob.gustavo.assistentet20spring.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Entity(name = "defesa_t20")
public class DefesaT20 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Integer valorArmadura;

    @NotNull
    @Column(nullable = false)
    private Integer valorEscudo;

    @NotNull
    @Column(nullable = false)
    private Integer valorOutros;

    @NotNull
    @Column(nullable = false)
    private Integer valorPenalidadeArmadura;

    @NotNull
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String atributo;

    @OneToOne(mappedBy = "defesa")
    @JsonIgnore
    private PersonagemT20 personagem;
}
