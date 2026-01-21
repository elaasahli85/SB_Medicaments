package pharmacie.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dispensaire {
    @Id
    private String code;
    private String contact;
    private String telephone;
    private String fax;
    private String adresse;
    private String ville;
    private String region;
    private String pays;
    private String codeP;


    @OneToMany(mappedBy = "dispensaire") // ⚠️ doit correspondre à l'attribut dans Commande
    private List<Commande> commandes;
}
