package gregoir_services.org.gestiondeferme.Services;

import gregoir_services.org.gestiondeferme.Model.Alimentation;
import gregoir_services.org.gestiondeferme.Repository.AlimentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlimentationService {

    private final AlimentationRepository alimentationRepository;

    @Autowired
    public AlimentationService(AlimentationRepository alimentationRepository) {
        this.alimentationRepository = alimentationRepository;
    }

    public List<Alimentation> getAllAlimentations() {
        return alimentationRepository.findAll();
    }

    public Optional<Alimentation> getAlimentationById(Long id) {
        return alimentationRepository.findById(id);
    }

    public Alimentation createAlimentation(Alimentation alimentation) {
        return alimentationRepository.save(alimentation);
    }

    public Alimentation updateAlimentation(Long id, Alimentation updatedAlimentation) {
        updatedAlimentation.setId(id);
        return alimentationRepository.save(updatedAlimentation);
    }

    public void deleteAlimentation(Long id) {
        alimentationRepository.deleteById(id);
    }
}
