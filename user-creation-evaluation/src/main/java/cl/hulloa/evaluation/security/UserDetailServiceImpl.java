package cl.hulloa.evaluation.security;

import cl.hulloa.evaluation.models.Usuario;
import cl.hulloa.evaluation.repositories.UserInterface;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {


    private UserInterface userInterface;

    public UserDetailServiceImpl(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario = userInterface
                .findOneByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("El usuario con el email = "+email+"no existe"));
        return new UserDetailsImpl(usuario);

    }
}
