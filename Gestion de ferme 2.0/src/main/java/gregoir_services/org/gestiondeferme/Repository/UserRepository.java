package gregoir_services.org.gestiondeferme.Repository;

import gregoir_services.org.gestiondeferme.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    // Trouver un user par son email
    User findByEmail(String email);

    // Trouver tous les users par leur nom
    List<User> findByUsernameContaining(String username);

    // Vérifier si un user existe par son email
    boolean existsByEmail(String email);

    // Compter le nombre d'users dans la base de données
    long count();
}






