package gregoir_services.org.gestiondeferme.Services;

import gregoir_services.org.gestiondeferme.Exception.ResourceNotFoundException;
import gregoir_services.org.gestiondeferme.Model.Porche;
import gregoir_services.org.gestiondeferme.Repository.PorcheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PorcheService {

    @Autowired
    private PorcheRepository porcheRepository;

    // Récupérer tous les porches
    public List<Porche> getAllPorches() {
        return porcheRepository.findAll();
    }

    // Récupérer un porche par ID
    public Porche getPorcheById(Long id) {
        return porcheRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Porche not found with id: " + id));
    }

    // Ajouter un nouveau porche
    public Porche addPorche(Porche porche) {
        return porcheRepository.save(porche);
    }

    // Mettre à jour un porche existant
    public Porche updatePorche(Long id, Porche porche) {
        Porche existingPorche = getPorcheById(id);
        existingPorche.setName(porche.getName());
        existingPorche.setLocation(porche.getLocation());
        // Ajoute d'autres attributs si nécessaire
        return porcheRepository.save(existingPorche);
    }

    // Supprimer un porche par ID
    public void deletePorche(Long id) {
        if (!porcheRepository.existsById(id)) {
            throw new ResourceNotFoundException("Porche not found with id: " + id);
        }
        porcheRepository.deleteById(id);
    }

    // Méthode pour trouver tous les porches (équivalente à getAllPorches)
    public List<Porche> findAll() {
        return getAllPorches();
    }

    // Méthode pour trouver un porche par ID (équivalente à getPorcheById)
    public Porche findById(Long id) {
        return getPorcheById(id);
    }

    // Méthode pour sauvegarder un porche (équivalente à addPorche)
    public Porche save(Porche porche) {
        return addPorche(porche);
    }

    // Méthode pour mettre à jour un porche (équivalente à updatePorche)
    public Porche update(Porche porche) {
        return updatePorche(porche.getId(), porche);
    }

    // Méthode pour supprimer un porche par ID (équivalente à deletePorche)
    public boolean delete(Long id) {
        try {
            deletePorche(id);
            return true; // Suppression réussie
        } catch (ResourceNotFoundException e) {
            return false; // Le porche n'a pas été trouvé
        }
    }
}
