package gregoir_services.org.gestiondeferme.Controller;

import gregoir_services.org.gestiondeferme.Model.Porc;
import gregoir_services.org.gestiondeferme.Services.PorcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/porcs")
public class PorcController {

    @Autowired
    private PorcService porcService;

    // Récupérer tous les porcs
    @GetMapping
    public ResponseEntity<List<Porc>> getAllPorcs() {
        List<Porc> porcList = porcService.findAll();
        return new ResponseEntity<>(porcList, HttpStatus.OK);
    }

    // Récupérer un porc par ID
    @GetMapping("/{id}")
    public ResponseEntity<Porc> getPorcById(@PathVariable Long id) {
        Porc porc = porcService.findById(id);
        return porc != null ? new ResponseEntity<>(porc, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Créer un nouveau porc
    @PostMapping
    public ResponseEntity<Porc> createPorc(@RequestBody Porc porc) {
        Porc createdPorc = porcService.save(porc);
        return new ResponseEntity<>(createdPorc, HttpStatus.CREATED);
    }

    // Mettre à jour un porc existant
    @PutMapping("/{id}")
    public ResponseEntity<Porc> updatePorc(@PathVariable Long id, @RequestBody Porc porc) {
        porc.setId(id);
        Porc updatedPorc = porcService.update(porc);
        return updatedPorc != null ? new ResponseEntity<>(updatedPorc, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Supprimer un porc par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePorc(@PathVariable Long id) {
        boolean isDeleted = porcService.delete(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

