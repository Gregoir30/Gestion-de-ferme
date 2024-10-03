package gregoir_services.org.gestiondeferme.Repository;

import gregoir_services.org.gestiondeferme.Model.Role;
import gregoir_services.org.gestiondeferme.Model.TypeRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(TypeRole name);
}