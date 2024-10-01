package gregoir_services.org.gestiondeferme.Repository;

import gregoir_services.org.gestiondeferme.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    // Trouver un utilisateur par son email
    Utilisateur findByEmail(String email);

    // Trouver tous les utilisateurs par leur nom
    List<Utilisateur> findByNomContaining(String nom);

    // Vérifier si un utilisateur existe par son email
    boolean existsByEmail(String email);

    // Compter le nombre d'utilisateurs dans la base de données
    long count();
}
