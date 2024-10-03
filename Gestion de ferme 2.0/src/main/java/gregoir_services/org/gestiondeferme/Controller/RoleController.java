package gregoir_services.org.gestiondeferme.Controller;

import gregoir_services.org.gestiondeferme.Model.Role;
import gregoir_services.org.gestiondeferme.Model.TypeRole;
import gregoir_services.org.gestiondeferme.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    // Récupérer tous les rôles
    @GetMapping("/all")
    public List<Role> getAllRoles() {
        return roleService.findAllRoles();
    }

    // Trouver un rôle par nom
    @GetMapping("/{name}")
    public Optional<Role> getRoleByName(@PathVariable TypeRole name) {
        return roleService.findByName(name);
    }

    // Créer un nouveau rôle
    @PostMapping("/create")
    public Role createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    // Supprimer un rôle par ID
    @DeleteMapping("/delete/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }
}
