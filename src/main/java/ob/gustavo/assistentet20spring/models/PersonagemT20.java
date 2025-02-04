package ob.gustavo.assistentet20spring.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity(name = "personagem_t20")
public class PersonagemT20 {

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
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String raca;

    @NotNull
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String classe;

    @NotNull
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String origem;

    @NotNull
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String divindade;

    @NotNull
    @Column(nullable = false)
    private Integer nivel;

    @NotNull
    @Column(nullable = false)
    private Integer experiencia;

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL)
    private List<AtributoT20> atributos;

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL)
    private List<PericiaT20> pericias;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "defesa_t20_id", referencedColumnName = "id")
    private DefesaT20 defesa;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vida_t20_id", referencedColumnName = "id")
    private VidaT20 vida;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mana_t20_id", referencedColumnName = "id")
    private ManaT20 mana;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deslocamento_t20_id", referencedColumnName = "id")
    private DeslocamentoT20 deslocamento;

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL)
    private List<PoderT20> poderes;

}
