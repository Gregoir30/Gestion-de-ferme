package gregoir_services.org.gestiondeferme.Repository;

import gregoir_services.org.gestiondeferme.Model.Porche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PorcheRepository extends JpaRepository<Porche, Long> {

    // Trouver un porche par son nom
    Porche findByNom(String nom);

    // Trouver tous les porches par type
    List<Porche> findByTypeDePorche(String typeDePorche);

    // Vérifier si un porche existe par son id
    boolean existsById(Long id);
}

