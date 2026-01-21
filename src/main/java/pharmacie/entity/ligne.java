package pharmacie.entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ligne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Min(1)
    private Integer quantite;

    @ManyToOne(optional = false)
    @JoinColumn(name = "commande_numero")
    private Commande commande;

    @ManyToOne(optional = false)
    @JoinColumn(name = "medicament_reference")
    private Medicament medicament;
}
