package mx.code.develop.sisab.queries;

import mx.code.develop.sisab.repository.users.UserRepository;
import mx.code.develop.sisab.shared.AppException;
import mx.code.develop.sisab.shared.Messages;
import mx.code.develop.sisab.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserQueries {

    @Autowired private PasswordEncoder passwordEncoder;

    @Autowired private UserRepository userRepository;

    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> new AppException(Messages.user_wrongUsername));
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new AppException(Messages.user_wrongUsername));
    }
}
