package mx.code.develop.sisab.repository.users;

import mx.code.develop.sisab.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

    Integer countByUsername(String username);

    @Query("SELECT COUNT(*) FROM User u " +
            "WHERE u.username=:curp ")
    Integer getUserByUsernameExist(String curp);
}
