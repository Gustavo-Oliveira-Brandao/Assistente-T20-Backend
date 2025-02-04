package ob.gustavo.assistentet20spring.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull
    @Length(max = 100)
    @Column(nullable = false, length = 100)
    private String armaduraEquipada;

    @NotNull
    @Length(max = 100)
    @Column(nullable = false, length = 100)
    private String escudoEquipado;

    @NotNull
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String atributo;

    @OneToOne(mappedBy = "defesa")
    @JsonIgnore
    private PersonagemT20 personagem;
}
