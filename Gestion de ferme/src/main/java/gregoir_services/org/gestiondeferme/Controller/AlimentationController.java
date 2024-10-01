package gregoir_services.org.gestiondeferme.Controller;

import gregoir_services.org.gestiondeferme.Model.Alimentation;
import gregoir_services.org.gestiondeferme.Services.AlimentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alimentation")
public class AlimentationController {

    private final AlimentationService alimentationService;

    @Autowired
    public AlimentationController(AlimentationService alimentationService) {
        this.alimentationService = alimentationService;
    }

    @GetMapping
    public List<Alimentation> getAllAlimentations() {
        return alimentationService.getAllAlimentations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alimentation> getAlimentationById(@PathVariable Long id) {
        return alimentationService.getAlimentationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Alimentation createAlimentation(@RequestBody Alimentation alimentation) {
        return alimentationService.createAlimentation(alimentation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alimentation> updateAlimentation(@PathVariable Long id, @RequestBody Alimentation alimentation) {
        return ResponseEntity.ok(alimentationService.updateAlimentation(id, alimentation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlimentation(@PathVariable Long id) {
        alimentationService.deleteAlimentation(id);
        return ResponseEntity.noContent().build();
    }
}
