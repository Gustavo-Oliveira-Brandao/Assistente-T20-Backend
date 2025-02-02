package ob.gustavo.assistentet20spring.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@Entity(name = "personagem_t20")
public class PersonagemT20 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
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
