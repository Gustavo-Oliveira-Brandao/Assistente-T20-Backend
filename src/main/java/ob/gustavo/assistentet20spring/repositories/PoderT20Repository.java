package ob.gustavo.assistentet20spring.repositories;

import ob.gustavo.assistentet20spring.models.PoderT20;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoderT20Repository extends JpaRepository<PoderT20, Long> {

}
