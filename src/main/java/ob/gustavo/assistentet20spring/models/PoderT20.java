package ob.gustavo.assistentet20spring.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@Entity(name = "poder_t20")
public class PoderT20 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull
    @Length(max = 100)
    @Column(nullable = false, length = 100)
    private String nome;

    @NotNull
    @Length(max = 500)
    @Column(nullable = false, length = 500)
    private String iconeURL;

    @NotNull
    @Length(max = 100)
    @Column(nullable = false, length = 100)
    private String tempoExecucao;

    @NotNull
    @Length(max = 5000)
    @Column(nullable = false, length = 5000)
    private String descricao;

    @NotNull
    @Length(max = 512)
    @Column(nullable = false, length = 512)
    private String preRequisitos;

    @ManyToOne
    @JoinColumn(name = "personagem_t20_id")
    @JsonIgnore
    private PersonagemT20 personagem;

    @OneToMany(mappedBy = "poder", cascade = CascadeType.ALL)
    private List<TagT20> tags;
}
