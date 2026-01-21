package pharmacie.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
public class Medicament {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE) // la clé est autogénérée par la BD, On ne veut pas de "setter"
	private Integer reference = null;

	@NonNull
	@Column(unique=true, length = 255)
	private String nom;

	private String quantiteParUnite = "Une boîte de 12";

	@PositiveOrZero
	private BigDecimal prixUnitaire = BigDecimal.TEN;

	/**
	 * Nombre d'unités en stock
	 * Décrémenté quand on expédie une commande contenant ce médicament
	 */

    public void ajouterUnitesCommandees(int quantite) {
        if (quantite < 0) {
            throw new IllegalArgumentException("Quantité négative interdite");
        }
        this.unitesCommandees += quantite;
    }

    @ToString.Exclude
	@PositiveOrZero
	private int unitesEnStock = 0;

	/**
	 * Nombre d'unités "en commande"
	 * Un médicament est "en commande" si il est dans une commande qui n'est pas encore expédiée
	 * Incrementé quand on ajoute des unités de ce médicament à une ligne de commande
	 * Décrémenté quand on expédie une commande contenant ce médicament
	 */
    public void expedier(int quantite) {
        if (quantite < 0) {
            throw new IllegalArgumentException("Quantité négative interdite");
        }
        if (quantite > unitesEnStock) {
            throw new IllegalStateException("Stock insuffisant");
        }
        this.unitesEnStock -= quantite;
        this.unitesCommandees -= quantite;
    }

    @ToString.Exclude
	@PositiveOrZero
	private int unitesCommandees = 0;

	/**
	 * Niveau de reapprovisionnement
	 * Si le stock devient inférieur ou égal à ce niveau,
	 * on doit approvisionner de nouvelles unités de ce médicament auprès d'un fournisseur
	 */

	@ToString.Exclude
	@PositiveOrZero
	private int niveauDeReappro = 0;

	/**
	 * Indique si le médicament est indisponible
	 */
	@ToString.Exclude
	private boolean indisponible = false;

	@Column(length = 500)
	private String imageURL;
    public boolean doitEtreReapprovisionne() {
        return unitesEnStock <= niveauDeReappro;
    }

	@ManyToOne(optional = false)
	@NonNull
	@ToString.Exclude

	private Categorie categorie ;
    @OneToMany(mappedBy = "medicament")
    private List<ligne> lignes;

}
