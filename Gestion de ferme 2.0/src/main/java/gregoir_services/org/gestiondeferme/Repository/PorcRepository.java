package gregoir_services.org.gestiondeferme.Repository;

import gregoir_services.org.gestiondeferme.Model.Porc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PorcRepository extends JpaRepository<Porc, Long> {

    // Trouver un porc par son nom
    List<Porc> findByNom(String nom);

    // Trouver tous les porcs d'un porche spécifique
    List<Porc> findByPorcheId(Long porcheId);

    // Vérifier si un porc existe par son id
    boolean existsById(Long id);
}

