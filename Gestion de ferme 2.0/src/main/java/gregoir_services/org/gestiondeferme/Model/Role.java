package gregoir_services.org.gestiondeferme.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

/*import javax.persistence.*;*/
import java.util.HashSet;
import java.util.Set;

@Setter
@Entity
@Table(name = "roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private TypeRole name;

    @ElementCollection
    private Set<String> permissions = new HashSet<>();

    // Constructeurs
    public Role() {}

    public Role(TypeRole name, Set<String> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public TypeRole getLibelle() {
        return name;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

}
