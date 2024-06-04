package comptoirs.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import comptoirs.entity.Commande;
import comptoirs.entity.Ligne;
import comptoirs.entity.Produit;

import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean called LigneRepository

public interface LigneRepository extends JpaRepository<Ligne, Integer> {
    List<Ligne> findByCommande(Commande commande);
    List<Ligne> findByProduitReference(Integer reference);
    List<Ligne> findByCommandeNumero(Integer numero);
    /**
     * On trouve au plus une ligne pour une commande donnée et un produit donné
     * @param commande la commande cherchée
     * @param produit le produit cherché
     * @return la ligne correspondante (optionnelle)
     */
    Optional<Ligne> findByCommandeAndProduit(Commande commande, Produit produit);
}
