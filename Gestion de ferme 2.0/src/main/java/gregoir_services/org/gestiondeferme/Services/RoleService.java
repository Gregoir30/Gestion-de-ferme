package gregoir_services.org.gestiondeferme.Services;

import gregoir_services.org.gestiondeferme.Model.Role;
import gregoir_services.org.gestiondeferme.Model.TypeRole;
import gregoir_services.org.gestiondeferme.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    // Trouver un rôle par nom
    public Optional<Role> findByName(TypeRole name) {
        return Optional.ofNullable(roleRepository.findByName(name));
    }

    // Créer un nouveau rôle
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    // Récupérer tous les rôles
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    // Supprimer un rôle par ID
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
