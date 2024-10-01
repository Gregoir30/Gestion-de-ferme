package gregoir_services.org.gestiondeferme.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Vaccin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String description;

    private LocalDate dateAdministration;

    private int doses; // Le nombre de doses nécessaires pour ce vaccin

    private LocalDate dateExpiration; // Date d'expiration du vaccin

    @ManyToOne
    @JoinColumn(name = "porc_id")
    private Porc porc; // Un vaccin est administré à un porc

    // Constructeurs, getters et setters
    public Vaccin() {
    }

    public Vaccin(String nom, String description, LocalDate dateAdministration, int doses, LocalDate dateExpiration) {
        this.nom = nom;
        this.description = description;
        this.dateAdministration = dateAdministration;
        this.doses = doses;
        this.dateExpiration = dateExpiration;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateAdministration() {
        return dateAdministration;
    }

    public void setDateAdministration(LocalDate dateAdministration) {
        this.dateAdministration = dateAdministration;
    }

    public int getDoses() {
        return doses;
    }

    public void setDoses(int doses) {
        this.doses = doses;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Porc getPorc() {
        return porc;
    }

    public void setPorc(Porc porc) {
        this.porc = porc;
    }
}
