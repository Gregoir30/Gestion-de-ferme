package gregoir_services.org.gestiondeferme.Controller;

import gregoir_services.org.gestiondeferme.Model.Porche;
import gregoir_services.org.gestiondeferme.Services.PorcheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/porches")
public class PorcheController {

    @Autowired
    private PorcheService porcheService;

    // Récupérer tous les porches
    @GetMapping
    public ResponseEntity<List<Porche>> getAllPorches() {
        List<Porche> porcheList = porcheService.findAll();
        return new ResponseEntity<>(porcheList, HttpStatus.OK);
    }

    // Récupérer un porche par ID
    @GetMapping("/{id}")
    public ResponseEntity<Porche> getPorcheById(@PathVariable Long id) {
        Porche porche = porcheService.findById(id);
        return porche != null ? new ResponseEntity<>(porche, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Créer un nouveau porche
    @PostMapping
    public ResponseEntity<Porche> createPorche(@RequestBody Porche porche) {
        Porche createdPorche = porcheService.save(porche);
        return new ResponseEntity<>(createdPorche, HttpStatus.CREATED);
    }

    // Mettre à jour un porche existant
    @PutMapping("/{id}")
    public ResponseEntity<Porche> updatePorche(@PathVariable Long id, @RequestBody Porche porche) {
        porche.setId(id);
        Porche updatedPorche = porcheService.update(porche);
        return updatedPorche != null ? new ResponseEntity<>(updatedPorche, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Supprimer un porche par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePorche(@PathVariable Long id) {
        boolean isDeleted = porcheService.delete(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

