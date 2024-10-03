package gregoir_services.org.gestiondeferme.Repository;

import gregoir_services.org.gestiondeferme.Model.Vaccin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccinRepository extends JpaRepository<Vaccin, Long> {

    // Trouver tous les vaccins d'un porc spécifique
    List<Vaccin> findByPorcId(Long porcId);

    // Trouver un vaccin par son nom
    Vaccin findByNom(String nom);

    // Vérifier si un vaccin existe par son id
    boolean existsById(Long id);
}

