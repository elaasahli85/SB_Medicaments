package pharmacie.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commande {

    @Id
    private Integer numero;

    private LocalDate saisieLe;

    private LocalDate envoyeeLe;

    private BigDecimal port;

    private BigDecimal remise;

    private String destinataire;

    private String adresse;

    private String ville;

    private String region;

    private String pays;

    private String codePostal;
    @ManyToOne
    @JoinColumn(name = "dispensaire_id")
    private Dispensaire dispensaire; // ⚠️ le nom exact ici !

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ligne> lignes;
}
