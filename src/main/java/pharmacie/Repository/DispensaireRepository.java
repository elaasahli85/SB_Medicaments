package pharmacie.Repository;

import pharmacie.entity.Commande;
import pharmacie.entity.Dispensaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DispensaireRepository extends JpaRepository<Dispensaire, Long> {

    // Calculer le nombre d'articles déjà commandés par un dispensaire connu par sa clé
    // la commande doit avoir déjà été envoyée, le champ envoyeele doit être renseigné
    @Query("SELECT SUM(l.quantite) FROM ligne l JOIN l.commande c WHERE c.dispensaire.code = :dispensaireId AND c.envoyeeLe IS NOT NULL")
    Long countArticlesOrderedByDispensaireId(@Param("dispensaireId") Long dispensaireId);

    // Trouver toutes les commandes en cours pour un dispensaire connu par sa clé
    // Une commande est en cours si sa date d'envoi envoyeele n'est pas renseignée
    @Query("SELECT c FROM Commande c WHERE c.dispensaire.code = :dispensaireId AND c.envoyeeLe IS NULL")
    List<Commande> findCurrentOrdersByDispensaireId(@Param("dispensaireId") Long dispensaireId);
}
