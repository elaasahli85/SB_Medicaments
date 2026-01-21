package pharmacie.dao;


import pharmacie.entity.Categorie;
import pharmacie.entity.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Categorie, Long> {

    // Trouver tous les médicaments disponibles à la commande pour une catégorie connue par sa clé
    // Un médicament est disponible à la commande si il n'est pas indisponible et si sa quantité en stock unitesEnStock est supérieure ou égale à sa quantité en commande unitesCommandees
    @Query("SELECT m FROM Medicament m WHERE m.categorie.code = :categorieId AND m.indisponible = false AND m.unitesEnStock >= m.unitesCommandees")
    List<Medicament> findAvailableMedicamentsByCategoriecode(@Param("categoriecode") Long categorieId);

    // Vérifier si une catégorie a des médicaments
    @Query("SELECT COUNT(m) > 0 FROM Medicament m WHERE m.categorie.code = :id")
    boolean hasMedicaments(@Param("code") Long code);
    Categorie findByLibelle(String libelle);
    List<Categorie> findByLibelleContaining(String libellePart);
}
