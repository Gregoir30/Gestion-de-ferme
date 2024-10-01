package gregoir_services.org.gestiondeferme.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Soins {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // Type de soin (ex : "Vétérinaire", "Hygiène")

    private String description; // Description du soin

    private LocalDate date; // Date du soin

    @ManyToOne
    @JoinColumn(name = "porc_id")
    private Porc porc; // Un soin est associé à un porc

    // Constructeurs, getters et setters
    public Soins() {
    }

    public Soins(String type, String description, LocalDate date) {
        this.type = type;
        this.description = description;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
