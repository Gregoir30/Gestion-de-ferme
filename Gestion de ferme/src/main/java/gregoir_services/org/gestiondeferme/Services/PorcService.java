package gregoir_services.org.gestiondeferme.Services;

import gregoir_services.org.gestiondeferme.Exception.ResourceNotFoundException;
import gregoir_services.org.gestiondeferme.Model.Porc;
import gregoir_services.org.gestiondeferme.Repository.PorcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PorcService {

    @Autowired
    private PorcRepository porcRepository;

    // Récupérer tous les porcs
    public List<Porc> getAllPorcs() {
        return porcRepository.findAll();
    }

    // Récupérer un porc par ID
    public Porc getPorcById(Long id) {
        return porcRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Porc not found with id: " + id));
    }

    // Ajouter un nouveau porc
    public Porc addPorc(Porc porc) {
        return porcRepository.save(porc);
    }

    // Mettre à jour un porc existant
    public Porc updatePorc(Long id, Porc porc) {
        Porc existingPorc = getPorcById(id);
        existingPorc.setName(porc.getName());
        existingPorc.setAge(porc.getAge());
        existingPorc.setHealthStatus(porc.getHealthStatus());
        return porcRepository.save(existingPorc);
    }

    // Supprimer un porc par ID
    public void deletePorc(Long id) {
        if (!porcRepository.existsById(id)) {
            throw new ResourceNotFoundException("Porc not found with id: " + id);
        }
        porcRepository.deleteById(id);
    }

    // Méthode pour trouver tous les porcs (équivalente à getAllPorcs)
    public List<Porc> findAll() {
        return getAllPorcs();
    }

    // Méthode pour trouver un porc par ID (équivalente à getPorcById)
    public Porc findById(Long id) {
        return getPorcById(id);
    }

    // Méthode pour mettre à jour un porc (équivalente à updatePorc)
    public Porc update(Porc porc) {
        // Supposons que le porc a un ID
        return updatePorc(porc.getId(), porc);
    }

    // Méthode pour sauvegarder un porc (équivalente à addPorc)
    public Porc save(Porc porc) {
        return addPorc(porc);
    }

    // Méthode pour supprimer un porc par ID (équivalente à deletePorc)
    public boolean delete(Long id) {
        try {
            deletePorc(id);
            return true; // Suppression réussie
        } catch (ResourceNotFoundException e) {
            return false; // Le porc n'a pas été trouvé
        }
    }
}
