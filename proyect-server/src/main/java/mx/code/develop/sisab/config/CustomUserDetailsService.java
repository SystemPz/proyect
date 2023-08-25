package mx.code.develop.sisab.config;

import mx.code.develop.sisab.shared.UserSession;
import mx.code.develop.sisab.model.users.User;
import mx.code.develop.sisab.queries.UserQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired private UserQueries userQueries;

    @Override @Transactional public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userQueries.getUserByUsername(username);
        return UserSession.create(user);
    }

    @Transactional public UserDetails loadUserById(Integer userId) {
        User user = userQueries.getUserById(userId);
        return UserSession.create(user);
    }
}
