package gregoir_services.org.gestiondeferme.Repository;

import gregoir_services.org.gestiondeferme.Model.Alimentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlimentationRepository extends JpaRepository<Alimentation, Long> {

    // Trouver tous les aliments d'un porc spécifique
    List<Alimentation> findByPorcId(Long porcId);

    // Trouver un aliment par son type
    List<Alimentation> findByType(String type);

    // Vérifier si un aliment existe par son id
    boolean existsById(Long id);

    List<Alimentation> findByName(String name);
}

