package ob.gustavo.assistentet20spring.repositories;

import ob.gustavo.assistentet20spring.models.PersonagemT20;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonagemT20Repository extends JpaRepository<PersonagemT20, Long> {
}
