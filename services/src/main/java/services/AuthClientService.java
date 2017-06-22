package services;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import services.user.UserService;

/**
 * Created by Corentin on 20/06/2017.
 */
@Component
public class AuthClientService implements UserDetailsService {

    private UserService userService;

    @Autowired
    public AuthClientService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findByUsername(s);
        if(user != null) return user;

        throw new UsernameNotFoundException("Username not found");
    }
}
