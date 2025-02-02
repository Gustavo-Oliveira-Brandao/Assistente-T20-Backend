package ob.gustavo.assistentet20spring.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Entity(name = "atributo_t20")
public class AtributoT20 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @NotNull
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String nome;

    @NotNull
    @Column(nullable = false)
    private Integer valorBase;

    @ManyToOne
    @JoinColumn(name = "personagem_t20_id")
    @JsonIgnore
    private PersonagemT20 personagem;
}
