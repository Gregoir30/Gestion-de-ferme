package gregoir_services.org.gestiondeferme.Services;

import gregoir_services.org.gestiondeferme.Exception.ResourceNotFoundException;
import gregoir_services.org.gestiondeferme.Model.Vaccin;
import gregoir_services.org.gestiondeferme.Repository.VaccinRepository; // Assurez-vous que le chemin est correct
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccinService {

    @Autowired
    private VaccinRepository vaccinRepository;

    // Récupérer tous les vaccins
    public List<Vaccin> findAll() {
        return vaccinRepository.findAll();
    }

    // Récupérer un vaccin par ID
    public Vaccin findById(Long id) {
        return vaccinRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vaccin not found with id: " + id));
    }

    // Sauvegarder un nouveau vaccin
    public Vaccin save(Vaccin vaccin) {
        return vaccinRepository.save(vaccin);
    }

    // Mettre à jour un vaccin existant
    public Vaccin update(Vaccin vaccin) {
        // On vérifie d'abord si le vaccin existe
        Vaccin existingVaccin = findById(vaccin.getId());
        existingVaccin.setNom(vaccin.getNom());
        existingVaccin.setDoses(vaccin.getDoses());
        existingVaccin.setDateExpiration(vaccin.getDateExpiration());
        // Ajoutez d'autres attributs si nécessaire
        return vaccinRepository.save(existingVaccin);
    }

    // Supprimer un vaccin par ID
    public boolean delete(Long id) {
        if (!vaccinRepository.existsById(id)) {
            throw new ResourceNotFoundException("Vaccin not found with id: " + id);
        }
        vaccinRepository.deleteById(id);
        return true; // Suppression réussie
    }
}
