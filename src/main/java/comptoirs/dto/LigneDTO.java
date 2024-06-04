package comptoirs.dto;
import lombok.Data;
@Data
public class LigneDTO {
    private Integer id;
    // Produit pour la ligne
    private ProduitDTO produit;
    private Integer quantite;
}
