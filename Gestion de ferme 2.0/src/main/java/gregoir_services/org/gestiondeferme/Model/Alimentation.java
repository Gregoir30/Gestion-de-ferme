package gregoir_services.org.gestiondeferme.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Alimentation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String type;
    private double quantité;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "porc_id", nullable = false)
    private Porc porc; // L'alimentation est associée à un porc

    // Constructeurs
    public Alimentation() {
    }

    public Alimentation(String name, String type, double quantité, LocalDate date, Porc porc) {
        this.name = name;
        this.type = type;
        this.quantité = quantité;
        this.date = date;
        this.porc = porc;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getQuantité() {
        return quantité;
    }

    public void setQuantité(double quantité) {
        this.quantité = quantité;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Porc getPorc() {
        return porc;
    }

    public void setPorc(Porc porc) {
        this.porc = porc;
    }
}
