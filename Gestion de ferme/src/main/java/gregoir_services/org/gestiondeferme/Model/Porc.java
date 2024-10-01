package gregoir_services.org.gestiondeferme.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Porc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private int age;

    private double poids;

    private String sexe; // Mâle ou Femelle

    private LocalDate dateNaissance;

    private String etatDeSante; // Exemple : "Sain", "Malade"

    @ManyToOne
    @JoinColumn(name = "porche_id")
    private Porche porche; // Un porc appartient à un porche

    @OneToMany(mappedBy = "porc", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vaccin> vaccins;

    @OneToMany(mappedBy = "porc", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alimentation> alimentations;

    @OneToMany(mappedBy = "porc", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Soins> soins;

    // Constructeurs, getters et setters
    public Porc() {
    }

    public Porc(String nom, int age, double poids, String sexe, LocalDate dateNaissance, String etatDeSante) {
        this.nom = nom;
        this.age = age;
        this.poids = poids;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.etatDeSante = etatDeSante;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEtatDeSante() {
        return etatDeSante;
    }

    public void setEtatDeSante(String etatDeSante) {
        this.etatDeSante = etatDeSante;
    }

    public Porche getPorche() {
        return porche;
    }

    public void setPorche(Porche porche) {
        this.porche = porche;
    }

    public List<Vaccin> getVaccins() {
        return vaccins;
    }

    public void setVaccins(List<Vaccin> vaccins) {
        this.vaccins = vaccins;
    }

    public List<Alimentation> getAlimentations() {
        return alimentations;
    }

    public void setAlimentations(List<Alimentation> alimentations) {
        this.alimentations = alimentations;
    }

    public List<Soins> getSoins() {
        return soins;
    }

    public void setSoins(List<Soins> soins) {
        this.soins = soins;
    }

    public String getName() {
        return nom; // Renvoie le nom en tant que String
    }

    public void setName(String name) {
        this.nom = name; // Accepte un String en entrée
    }

    public String getHealthStatus() {
        return etatDeSante; // Renvoie l'état de santé en tant que String
    }

    public void setHealthStatus(String healthStatus) {
        this.etatDeSante = healthStatus; // Accepte un String pour l'état de santé
    }

}
