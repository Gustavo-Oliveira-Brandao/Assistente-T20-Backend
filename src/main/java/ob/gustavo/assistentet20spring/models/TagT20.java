package ob.gustavo.assistentet20spring.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Entity(name = "tag_t20")
public class TagT20 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @NotNull
    @Length(max = 100)
    @Column(nullable = false, length = 100)
    private String label;

    @ManyToOne
    @JoinColumn(name = "poder_t20_id")
    @JsonIgnore
    private PoderT20 poder;
}
