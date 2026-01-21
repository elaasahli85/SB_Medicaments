package pharmacie.dao;

import pharmacie.entity.ligne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneRepository extends JpaRepository<ligne, Long> {
}
