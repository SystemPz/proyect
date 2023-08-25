package mx.code.develop.sisab.service;


import mx.code.develop.sisab.queries.UserQueries;
import mx.code.develop.sisab.model.users.User;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private UserQueries userQueries;

    private void validateIsDevAdmin(Integer adminId) {
        User userAdmin = userQueries.getUserById(adminId);

    }
}

