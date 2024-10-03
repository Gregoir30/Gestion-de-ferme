package gregoir_services.org.gestiondeferme.Controller;

import gregoir_services.org.gestiondeferme.Model.Soins;
import gregoir_services.org.gestiondeferme.Services.SoinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/soins")
public class SoinsController {

    @Autowired
    private SoinsService soinsService;

    // Récupérer tous les soins
    @GetMapping
    public ResponseEntity<List<Soins>> getAllSoins() {
        List<Soins> soinsList = soinsService.findAll();
        return new ResponseEntity<>(soinsList, HttpStatus.OK);
    }

    // Récupérer un soin par ID
    @GetMapping("/{id}")
    public ResponseEntity<Soins> getSoinById(@PathVariable Long id) {
        Soins soin = soinsService.findById(id);
        return soin != null ? new ResponseEntity<>(soin, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Créer un nouveau soin
    @PostMapping
    public ResponseEntity<Soins> createSoin(@RequestBody Soins soin) {
        Soins createdSoin = soinsService.save(soin);
        return new ResponseEntity<>(createdSoin, HttpStatus.CREATED);
    }

    // Mettre à jour un soin existant
    @PutMapping("/{id}")
    public ResponseEntity<Soins> updateSoin(@PathVariable Long id, @RequestBody Soins soin) {
        soin.setId(id);
        Soins updatedSoin = soinsService.update(soin);
        return updatedSoin != null ? new ResponseEntity<>(updatedSoin, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Supprimer un soin par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSoin(@PathVariable Long id) {
        boolean isDeleted = soinsService.delete(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

