package gregoir_services.org.gestiondeferme.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Porche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private int capacité;

    private String typeDePorche; // Exemple : "Maternité", "Engraissement"

    private String emplacement;

    @OneToMany(mappedBy = "porche", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Porc> porcs; // Un porche contient plusieurs porcs

    // Constructeurs, getters et setters
    public Porche() {
    }

    public Porche(String nom, int capacité, String typeDePorche, String emplacement) {
        this.nom = nom;
        this.capacité = capacité;
        this.typeDePorche = typeDePorche;
        this.emplacement = emplacement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCapacité() {
        return capacité;
    }

    public void setCapacité(int capacité) {
        this.capacité = capacité;
    }

    public String getTypeDePorche() {
        return typeDePorche;
    }

    public void setTypeDePorche(String typeDePorche) {
        this.typeDePorche = typeDePorche;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public List<Porc> getPorcs() {
        return porcs;
    }

    public void setPorcs(List<Porc> porcs) {
        this.porcs = porcs;
    }

    public Object getName() {
        return nom;
    }
    public void setName(Object name) {
        this.nom = (String) name;
    }

    public Object getLocation() {
        return emplacement;
    }
    public void setLocation(Object location) {
        this.emplacement = (String) location;
    }
}
