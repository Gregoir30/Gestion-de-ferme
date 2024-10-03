package gregoir_services.org.gestiondeferme.Services;

import gregoir_services.org.gestiondeferme.Model.User;
import gregoir_services.org.gestiondeferme.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor

public class AuthentificationUtilisateurService implements UserDetailsService {


    private final UserRepository userRepository;

    // Charger un utilisateur par nom d'utilisateur (ou email dans ce cas)
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = (User) userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé avec l'email : " + email);
        }
        // Retourne l'utilisateur en tant que UserDetails
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                new ArrayList<>()
        );
    }
}
