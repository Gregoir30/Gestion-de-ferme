package gregoir_services.org.gestiondeferme.Repository;

import gregoir_services.org.gestiondeferme.Model.Soins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoinsRepository extends JpaRepository<Soins, Long> {

    // Trouver tous les soins d'un porc spécifique
    List<Soins> findByPorcId(Long porcId);

    // Trouver un soin par son type
    List<Soins> findByType(String type);

    // Vérifier si un soin existe par son id
    boolean existsById(Long id);
}

