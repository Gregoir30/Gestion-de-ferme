package gregoir_services.org.gestiondeferme.Services;

import gregoir_services.org.gestiondeferme.Model.Soins;
import gregoir_services.org.gestiondeferme.Repository.SoinsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoinsService {

    @Autowired
    private SoinsRepository soinsRepository;

    public List<Soins> findAll() {
        return soinsRepository.findAll();
    }

    public Soins findById(Long id) {
        return soinsRepository.findById(id).orElse(null);
    }

    public Soins save(Soins soin) {
        return soinsRepository.save(soin);
    }

    public Soins update(Soins soin) {
        return soinsRepository.save(soin);
    }

    public boolean delete(Long id) {
        if (soinsRepository.existsById(id)) {
            soinsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

