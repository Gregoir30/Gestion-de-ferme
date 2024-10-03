package gregoir_services.org.gestiondeferme.Controller;

import gregoir_services.org.gestiondeferme.Model.Vaccin;
import gregoir_services.org.gestiondeferme.Services.VaccinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vaccins")
public class VaccinController {

    @Autowired
    private VaccinService vaccinService;

    // Récupérer tous les vaccins
    @GetMapping
    public ResponseEntity<List<Vaccin>> getAllVaccins() {
        List<Vaccin> vaccinList = vaccinService.findAll();
        return new ResponseEntity<>(vaccinList, HttpStatus.OK);
    }

    // Récupérer un vaccin par ID
    @GetMapping("/{id}")
    public ResponseEntity<Vaccin> getVaccinById(@PathVariable Long id) {
        Vaccin vaccin = vaccinService.findById(id);
        return vaccin != null ? new ResponseEntity<>(vaccin, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Créer un nouveau vaccin
    @PostMapping
    public ResponseEntity<Vaccin> createVaccin(@RequestBody Vaccin vaccin) {
        Vaccin createdVaccin = vaccinService.save(vaccin);
        return new ResponseEntity<>(createdVaccin, HttpStatus.CREATED);
    }

    // Mettre à jour un vaccin existant
    @PutMapping("/{id}")
    public ResponseEntity<Vaccin> updateVaccin(@PathVariable Long id, @RequestBody Vaccin vaccin) {
        vaccin.setId(id);
        Vaccin updatedVaccin = vaccinService.update(vaccin);
        return updatedVaccin != null ? new ResponseEntity<>(updatedVaccin, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Supprimer un vaccin par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVaccin(@PathVariable Long id) {
        boolean isDeleted = vaccinService.delete(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

